package com.fq.task.withdrawcheck;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fq.common.constant.RetCodeEnum;
import com.fq.entity.vo.wallet.UserRedPacketInviteRelVO;
import com.fq.entity.vo.wallet.UserRedPacketVO;
import com.fq.entity.vo.wallet.UserWithdrawAppVO;
import com.fq.service.wallet.UserWalletService;
import com.fq.task.Task;

/**
 * 提现申请审核类
 * @author zhen.cheng
 *
 */
@Service
public class WithdrawCheckTask implements Task<WithdrawCheckTaskData>{

	private final static Logger logger = LoggerFactory.getLogger(WithdrawCheckTask.class) ;
	
	@Autowired
	private UserWalletService userWalletService ;
	
	@Override
	public RetCodeEnum execute(WithdrawCheckTaskData data) throws Exception {
		
//		for( UserWithdrawAppVO app : data.getApps() ){
//			RetCodeEnum retCode = userWalletService.check( app , data );
//			logger.info("提现申请审核 uwaId:{} batchNo:{} , account:{} , orderNo:{} 审核结果：{}" , new Object[]{app.getUwaId() , app.getBatchNo(),app.getAccount(),app.getOrderNo(),retCode.getCode()});
//		}
//		UserWithdrawAppPO po = new UserWithdrawAppPO() ;
//		
//		// 校验红包金额是否与钱包金额一致
//		// 校验用户该用户是否有只有一笔申请
//		
//		po.setUwaId(data.getUwaId());
//		po.setChkState(UserWithdrawAppConstant.CHK_STATE.CHK_SUCCESS);
		
		return RetCodeEnum.SUCCESS ;
		
	}
	
	private final RetCodeEnum check(UserWithdrawAppVO app , WithdrawCheckTaskData data){
		List<UserRedPacketVO> redPackets = data.getRedPackets().get(app) ;
		List<UserRedPacketInviteRelVO> rels = data.getRels().get(app) ;
		
		return RetCodeEnum.SUCCESS ;
		
	}

	@Override
	public RetCodeEnum doExecute(WithdrawCheckTaskData data) throws Exception {
		return null;
	}
	
}
