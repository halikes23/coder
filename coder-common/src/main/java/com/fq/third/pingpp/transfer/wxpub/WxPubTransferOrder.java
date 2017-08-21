package com.fq.third.pingpp.transfer.wxpub;

import com.fq.third.pingpp.transfer.BaseOrder;

public class WxPubTransferOrder extends BaseOrder{
	
	private final static String CHANNEL_WX_PUB = "wx_pub" ;
	
	private WxPubTransferOrder(){ }
	
	/**
	 * 
	 * @param orderNo 企业转账使用的商户内部订单号。wx(新渠道)、wx_pub 规定为 1 ~ 50 位不能重复的数字字母组合
	 * @param amount 订单总金额, 人民币单位：分（如订单总金额为 1 元，此处请填 100,企业付款最小发送金额为 1 元）
	 * @param recipient 接收者 id， 为用户在 wx(新渠道)、wx_pub 下的 open_id
	 * @param description 描述
	 * @return
	 */
	public final static WxPubTransferOrder build(
			String orderNo , 
			Integer amount ,
			String recipient ,
			String description
			){
		WxPubTransferOrder order = new WxPubTransferOrder() ;
		order.setOrderNo(orderNo);
		order.setAmount(amount);
		order.setRecipient(recipient);
		order.setDescription(description);
		return order ;
		
	}
	
	private String orderNo ;
	private Integer amount ;
	private String recipient ;
	private String description ;
	private String channel = CHANNEL_WX_PUB ;
	
	public String getOrderNo() {
		return orderNo;
	}
	
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	public Integer getAmount() {
		return amount;
	}
	
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public String getRecipient() {
		return recipient;
	}
	
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	
	}
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}
	
}
