package com.fq.task.withdraw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fq.common.constant.RetCodeEnum;
import com.fq.common.constant.wallet.UserWithdrawBatchConstant;
import com.fq.dao.dao.user.UserWalletDAO;
import com.fq.entity.vo.wallet.IoBatchTransferRecipientVO;
import com.fq.entity.vo.wallet.UserWithdrawAppVO;
import com.fq.entity.vo.wallet.UserWithdrawBatchVO;
import com.fq.task.Task;
import com.fq.task.TaskDistributor;
import com.fq.util.StringUtils;

@Service
public class WithdrawBatchTask implements Task<String> {
	
	@Autowired
	private UserWalletDAO userWalletDAO ;
	
	@Autowired
	private TaskDistributor<List<UserWithdrawAppVO>> wxPubWithdrawTaskDistributor ;
	
	@Autowired
	private TaskDistributor<List<IoBatchTransferRecipientVO>> alipayWithdrawTaskDistributor ;
	
	@Autowired
	private Task<List<UserWithdrawAppVO>> wxPubWithdrawTask ;
	
	@Autowired
	private Task<List<IoBatchTransferRecipientVO>> alipayWithdrawTask ;
	
	private final static Logger logger = LoggerFactory.getLogger(WithdrawBatchTask.class) ;
	
	@Override
	public RetCodeEnum execute(String batchNo) throws Exception {
		Map<String,Object> params = new HashMap<String,Object>() ;
		params.put("batchNo", batchNo) ;
		
		UserWithdrawBatchVO withdrawBatch = userWalletDAO.queryWithdrawbatchByBatchNo(batchNo);
		String batchState = withdrawBatch.getState();
		
		if(!StringUtils.equals(UserWithdrawBatchConstant.STATE.UNTRANSFER, batchState )){
			// 如果批次状态不为待结算，则返回状态错误
			return RetCodeEnum.BATCHTASK_STATE_WRONG ;
		}
	
		// 修改批次状态结算中
		withdrawBatch.setState(UserWithdrawBatchConstant.STATE.TRANSFERING);
		userWalletDAO.updateWithdrawBatchState(withdrawBatch);
		
		// 清理io_batch_transfer_recipient表
		userWalletDAO.deleteIoBatchTransferRecipientByBatchNo(batchNo) ;
		// 将当前批次渠道为阿里的，审核状态为审核通过，交易状态为待结算的提现申请信息 按支付渠道帐号和支付渠道用户姓名分组存入bt_alipay_batch_withdraw表中
		userWalletDAO.createIoBatchTransferRecipient(batchNo) ;
		// 修改审核失败的订单的交易为失败,交易状态为失败
		userWalletDAO.updateCheckFailedWithdrawApp2Fail(batchNo) ;
		// 修改审核失败的订单所对应钱包的冻结金额为 冻结金额-申请金额
		userWalletDAO.updateCheckFailedWithdrawAppFrozen2Zero(batchNo) ;
		
		try{
			// 处理微信提现申请
			List<List<UserWithdrawAppVO>> appsList = wxPubWithdrawTaskDistributor.distribute(params, 5000);
			logger.info("拆分出"+appsList.size()+"组微信任务");
			for( List<UserWithdrawAppVO> apps : appsList ){
				wxPubWithdrawTask.execute(apps);
			}
			
			// 处理支付宝提现申请
			List<List<IoBatchTransferRecipientVO>> alipayWithdraws = alipayWithdrawTaskDistributor.distribute(params, 5000);
			logger.info("拆分出"+alipayWithdraws.size()+"组支付宝任务");
			for( List<IoBatchTransferRecipientVO> apps : alipayWithdraws ){
				alipayWithdrawTask.execute(apps);
			}
			
			// 清空失败的提现申请对应的红包批次号
			userWalletDAO.updateRedPacketBatchNo2Null4Fail(batchNo);
			
			// 修改批次状态为结算成功
			withdrawBatch.setState(UserWithdrawBatchConstant.STATE.TRANSFER_SUCCESS);
			userWalletDAO.updateWithdrawBatchState(withdrawBatch);
			return RetCodeEnum.SUCCESS;
		}catch(Exception e){
			// 修改批次状态为结算失败
			logger.error( "结算失败 批次号：" + batchNo ,e);
			withdrawBatch.setState(UserWithdrawBatchConstant.STATE.TRANSFERED_FAILED);
			userWalletDAO.updateWithdrawBatchState(withdrawBatch);
			return RetCodeEnum.SYSTEM_ERROR ;
		}
		
	}

	@Override
	public RetCodeEnum doExecute(String batchNo) throws Exception {
		
		// do nothing
		
		return null;
		
	}

}
