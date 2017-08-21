package com.fq.third.pingpp.transfer.alipaybatch;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fq.entity.vo.wallet.IoBatchTransferRecipientVO;
import com.fq.third.pingpp.transfer.TransferFactory;
import com.fq.util.pingpp.Main;

public class AlipayBatchTransferFactory implements TransferFactory<List<IoBatchTransferRecipientVO>> {

	private final static String KEY_CHANNEL = "channel";

	public final static String KEY_BATCH_NO = "batch_no";

	private final static String KEY_AMOUNT = "amount";

	private final static String KEY_TYPE = "type";

	private final static String KEY_CURRENCY = "currency";

	private final static String KEY_ACCOUNT = "account";

	private final static String KEY_NAME = "name";

	private final static String KEY_RECIPIENTS = "recipients";

	private final static String KEY_DESCRIPTION = "description";

	private final static String KEY_APP = "app";

	private final static String CHANNEL = "alipay";

	private final static String TYPE = "b2c";

	private final static String CURRENCY = "cny";

	private final static String DESCRIPTION = "钱包提现";

	private final static String APP_ID = "app_X5KSyHubbXbDCuPW"; // appId

	@Override
	public Map<String, Object> build(List<IoBatchTransferRecipientVO> apps) {
		
		Map<String, Object> transferMap = new HashMap<String, Object>();
		List<Map<String, Object>> recipients = new ArrayList<Map<String, Object>>();
		Integer amount = 0 ;
		
		for(IoBatchTransferRecipientVO  app : apps){
			Map<String, Object> recipient = new HashMap<String, Object>();
			recipient.put(KEY_ACCOUNT, app.getAccount());
			recipient.put(KEY_AMOUNT, app.getAmount());
			recipient.put(KEY_NAME, app.getName());
			amount += app.getAmount() ;
			recipients.add(recipient);
		}
		
		String orderNo = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()) + Main.randomString(7);
		transferMap.put(KEY_APP, APP_ID);
		transferMap.put(KEY_CHANNEL, CHANNEL); // 目前支持 wx(新渠道)、 wx_pub
		transferMap.put(KEY_BATCH_NO, orderNo); // 企业转账使用的商户内部订单号。wx(新渠道)、wx_pub 规定为 1 ~ 50 位不能重复的数字字母组合
		transferMap.put(KEY_AMOUNT, amount); // 订单总金额, 人民币单位：分（如订单总金额为 1 元，此处请填  100,企业付款最小发送金额为 1 元）
		transferMap.put(KEY_TYPE, TYPE); // 付款类型，当前仅支持 b2c 企业付款
		transferMap.put(KEY_CURRENCY, CURRENCY);
		transferMap.put(KEY_DESCRIPTION, DESCRIPTION);
		
		transferMap.put(KEY_RECIPIENTS, recipients) ;

		return transferMap;
	}

}
