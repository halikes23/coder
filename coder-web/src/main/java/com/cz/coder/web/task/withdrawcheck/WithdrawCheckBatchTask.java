package com.fq.task.withdrawcheck;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fq.common.constant.RetCodeEnum;
import com.fq.common.constant.wallet.UserWalletConstant;
import com.fq.common.constant.wallet.UserWithdrawBatchConstant;
import com.fq.dao.dao.user.UserWalletDAO;
import com.fq.entity.vo.wallet.UserWithdrawAppVO;
import com.fq.entity.vo.wallet.UserWithdrawBatchVO;
import com.fq.task.Task;
import com.fq.task.TaskDistributor;
import com.fq.util.StringUtils;

@Service
public class WithdrawCheckBatchTask implements Task<String> {
	
	@Autowired
	private UserWalletDAO userWalletDAO ;
	
	@Autowired
	private TaskDistributor<WithdrawCheckTaskData> withdrawCheckTaskDistributor ;
	
	@Autowired
	private Task<WithdrawCheckTaskData> withdrawCheckTask ;
	
	@Override
	public RetCodeEnum execute(String batchNo) throws Exception {
		
		// do nothing
		
		return null ;
	}

	@Override
	public RetCodeEnum doExecute(String batchNo) throws Exception {
		Map<String,Object> params = new HashMap<String,Object>() ;
		params.put("batchNo", batchNo) ;
		// 获取批次状态
		UserWithdrawBatchVO withdrawBatch = userWalletDAO.queryWithdrawbatchByBatchNo(batchNo);
		String batchState = withdrawBatch.getState();
		
		if(!StringUtils.equals(UserWithdrawBatchConstant.STATE.UNCHECKED, batchState )){
			// 如果批次状态不为待审核，则返回状态错误
			return RetCodeEnum.BATCHTASK_STATE_WRONG ;
		}
		// 修改批次状态审核中
		withdrawBatch.setState(UserWithdrawBatchConstant.STATE.CHECKING);
		userWalletDAO.updateWithdrawBatchState(withdrawBatch);
		
		// 修改批次内所有审核状态为审核通过和审核失败的提现申请的审核状态为未审核
//		UserWithdrawAppVO app = new UserWithdrawAppVO() ;
//		app.setChkState(UserWalletConstant.CHK_STATE.UNCHECK);
//		app.setChkFailMsg(null);
//		app.setBatchNo(batchNo);
//		userWalletDAO.updateWithdrawAppChkState2OriginalByBatchNo(app);
		
		// 提现申请额度超过300元的 设置审核状态为失败
		userWalletDAO.updateWithdrawAppChkFailedByAmtLimit(batchNo,30000);
		
		// 将未审核的提现申请置为审核通过
		userWalletDAO.updateUncheckedWithdrawAppChkStateSuccess(batchNo);
		
		// 执行审核
//		try{
//			// 审核数据拆分
//			List<WithdrawCheckTaskData> dataList = withdrawCheckTaskDistributor.distribute(params, 5000);
//			// 分批次执行审核
//			for( WithdrawCheckTaskData data : dataList ){
//				withdrawCheckTask.doExecute(data);
//			}
//		}catch(Exception e){
//			// 修改审批状态为审核失败
//			withdrawBatch.setState(UserWithdrawBatchConstant.STATE.CHECKED_FAILED);
//			userWalletDAO.updateWithdrawBatchState(withdrawBatch);
//			return RetCodeEnum.SYSTEM_ERROR ;
//		}
		
		// 统计审核结果 申请通过数 ，审核通过金额 ，审核未通过数 ，审核胃痛过金额：
		this.userWalletDAO.updateCheckSummary(batchNo);
		
		// 修改状态未待核算
		withdrawBatch.setState(UserWithdrawBatchConstant.STATE.UNTRANSFER);
		userWalletDAO.updateWithdrawBatchState(withdrawBatch);
		return RetCodeEnum.SUCCESS;
	}

}
