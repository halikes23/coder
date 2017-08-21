package com.fq.third.pingpp.transfer.wxpub;

import java.util.HashMap;
import java.util.Map;

import com.fq.entity.vo.wallet.UserWithdrawAppVO;
import com.fq.exception.JnwtvException;
import com.fq.third.pingpp.transfer.TransferFactory;

public class WxPubTransferFactory implements TransferFactory<UserWithdrawAppVO>{

	private final static String KEY_CHANNEL = "channel";
	
	private final static String KEY_ORDER_NO = "order_no" ;
	
	private final static String KEY_AMMOUNT = "amount" ;
	
	private final static String KEY_TYPE = "type" ;
	
	private final static String KEY_CURRENCY = "currency" ;
	
	private final static String KEY_RECIPIENT = "recipient" ;
	
	private final static String KEY_DESCRIPTION = "description" ;
	
	private final static String KEY_ID = "id" ;
	
	private final static String KEY_APP = "app" ;
	
	private final static String CHANNEL = "wx_pub" ;
	
	private final static String TYPE = "b2c" ;
	
	private final static String CURRENCY = "cny" ;
	
	private final static String ID = "app_X5KSyHubbXbDCuPW" ; // appId
	
	
	@Override
	public Map<String,Object> build(UserWithdrawAppVO app) throws JnwtvException {
		
//		transferMap.put("channel", "wx_pub");// 目前支持 wx(新渠道)、 wx_pub
//        transferMap.put("order_no", orderNo);// 企业转账使用的商户内部订单号。wx(新渠道)、wx_pub 规定为 1 ~ 50 位不能重复的数字字母组合
//        transferMap.put("amount", "200");// 订单总金额, 人民币单位：分（如订单总金额为 1 元，此处请填 100,企业付款最小发送金额为 1 元）
//        transferMap.put("type", "b2c");// 付款类型，当前仅支持 b2c 企业付款
//        transferMap.put("currency", "cny");
//        transferMap.put("recipient", openid);// 接收者 id， 为用户在 wx(新渠道)、wx_pub 下的 open_id
//        transferMap.put("description", "your description");
		
		Map<String,Object> transferMap = new HashMap<String,Object>() ;
		
		transferMap.put(KEY_CHANNEL, CHANNEL) ;
		transferMap.put(KEY_ORDER_NO, app.getOrderNo()) ;
		transferMap.put(KEY_AMMOUNT, app.getWithdrawAmt()) ;
		transferMap.put(KEY_TYPE, TYPE) ;
		transferMap.put(KEY_CURRENCY, CURRENCY) ;
		transferMap.put(KEY_RECIPIENT, app.getChannelAccount()) ;
		transferMap.put(KEY_DESCRIPTION, "钱包提现") ;
		
		Map<String, String> appMap = new HashMap<String, String>();
		appMap.put(KEY_ID, ID);
		
		transferMap.put(KEY_APP, appMap) ;
		
		return transferMap ;
		
	}

}
