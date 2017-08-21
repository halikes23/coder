package com.fq.task.withdraw;

import java.util.ArrayList;
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
import com.fq.entity.vo.wallet.UserWalletVO;
import com.fq.entity.vo.wallet.UserWithdrawAppVO;
import com.fq.service.wallet.UserWalletService;
import com.fq.task.Task;
import com.fq.util.StringUtils;

@Service
public class WxPubWithdrawTask implements Task<List<UserWithdrawAppVO>>{

	@Autowired
	private UserWalletService userWalletService;
	
	@Autowired
	private UserWalletDAO  userWalletDAO;
	
	private final static Logger logger = LoggerFactory.getLogger(WxPubWithdrawTask.class) ;
	
	public RetCodeEnum execute(List<UserWithdrawAppVO> apps) throws Exception{
		
		for( UserWithdrawAppVO app : apps ){
			try{
				// 微信支付
				userWalletService.withdrawByPubWx(app) ;
				Thread.sleep(100L);
			}catch(Exception e){
				logger.error("提现异常，",e) ;
				userWalletService.doWithdrawFail(app , String.format("提现申请【订单号:%s】处理异常，错误原因请查看后台日志", app.getOrderNo()) );
				
			}
		}
		
		
		return RetCodeEnum.SUCCESS ;
		
	}
	
	@Override
	public RetCodeEnum doExecute(List<UserWithdrawAppVO> apps) throws Exception {
		
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
