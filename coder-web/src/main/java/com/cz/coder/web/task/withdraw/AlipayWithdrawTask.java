package com.fq.task.withdraw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fq.common.constant.RetCodeEnum;
import com.fq.common.constant.wallet.UserWithdrawAppConstant;
import com.fq.dao.dao.user.UserWalletDAO;
import com.fq.entity.vo.wallet.IoBatchTransferRecipientVO;
import com.fq.entity.vo.wallet.UserWithdrawAppVO;
import com.fq.service.wallet.UserWalletService;
import com.fq.task.Task;

@Service
public class AlipayWithdrawTask implements Task<List<IoBatchTransferRecipientVO>>{

	@Autowired
	private UserWalletService userWalletService;
	
	@Autowired
	private UserWalletDAO  userWalletDAO;
	
	private final static Logger logger = LoggerFactory.getLogger(AlipayWithdrawTask.class) ;
	
	public RetCodeEnum execute(List<IoBatchTransferRecipientVO> apps) throws Exception{
//		List<UserWithdrawAppVO> aliApps = new ArrayList<UserWithdrawAppVO>() ;
		
//		for( UserWithdrawAppVO app : apps ){
//			try{
//				if(StringUtils.equals(app.getChannelType(),UserWithdrawAppConstant.CHANNEL_TYPE.PUB_WX)){
//					// 微信支付
//					userWalletService.withdrawByPubWx(app) ;
//				}else if(StringUtils.equals(app.getChannelType(),UserWithdrawAppConstant.CHANNEL_TYPE.ALIPAY_BATCH)){
//					aliApps.add(app) ;
//				}else{
//					logger.error("不支持的支付渠道 uwaId:" + app.getUwaId() + " channelType:" + app.getChannelType());
//				}
//				
//			}catch(Exception e){
//				logger.error("体现异常，",e) ;
//				app.setTradeState(UserWithdrawAppConstant.TRADE_STATE.WIDTHDRAW_FAIL);
//				app.setTradeFailMsg( String.format("提现申请【订单号:%s】处理异常，错误原因请查看后台日志", app.getOrderNo()) );
//				this.userWalletDAO.updateWithdrawAppTradeState(app);
//			}
//		}
		// 支付宝批量支付
		try{
				userWalletService.withdrawByAliPayBatch(apps);
			
		}catch(Exception e){
			// 异常处理 TODO 
			logger.error("提现异常，",e) ;
			
			UserWithdrawAppVO param = new UserWithdrawAppVO() ;
			param.setSendState(UserWithdrawAppConstant.SEND_STATE.SEND_FAILED);
			param.setTradeState(UserWithdrawAppConstant.TRADE_STATE.WIDTHDRAW_FAIL);
			
			for( IoBatchTransferRecipientVO app : apps ){
				app.setBatchNo(app.getBatchNo());
				param.setBatchNo(app.getBatchNo());
				param.setChannelAccount(app.getAccount());
				param.setChannelName(app.getName());
				param.setTradeFailMsg( String.format("提现申请【渠道帐号:%s，渠道帐号姓名:%s】处理异常，错误原因请查看后台日志", app.getAccount() , app.getName()) );
				this.userWalletDAO.updateTradeStateByChannelInfo(param);
			}
			
		}
		
		
		return RetCodeEnum.SUCCESS ;
		
	}
	
	@Override
	public RetCodeEnum doExecute(List<IoBatchTransferRecipientVO> apps) throws Exception {
		
		// do nothing
		
		return null;
		
	}
	
	private Map<String,Object> buildAliRecipient(UserWithdrawAppVO app){
		Map<String,Object> recipient = new HashMap<String,Object>() ;
		recipient.put("account", app.getChannelAccount());
	    recipient.put("amount", app.getWithdrawAmt());
	    recipient.put("name", app.getChannelName());
	    return recipient ;
	}
	
}
