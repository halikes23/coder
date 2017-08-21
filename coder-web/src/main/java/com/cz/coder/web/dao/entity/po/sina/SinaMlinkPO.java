package com.fq.dao.entity.po.sina;

public class SinaMlinkPO {
	private String product_key ;//此内容所属app在魔窗中 的所属产品key
	private String short_uri ;//该内容对应的魔窗mLink 短链【因为每个内容都对应app 内的一个内容页，为了实 现一键唤醒，需要在内容 中指明该内容对应的一键 唤醒短链，并且再创建短 链的同时，选择内容分发 平台的渠道，比如新浪， 参照下图。 该锻炼需要拼接上表明该 内容的内容id，比如http: //a.mlinks.cc/Azdj?cont ent_id=123】
	private String click_behavior ;// 再内容分发平台曝光时， 用户点击后的跳转策略【c，表明跳转的地址是con tent_uri，表明客户希望 先让用户看到内容本身， 然后在内容的h5页面再做 一键唤醒。s, 代表short_uri, 表明直接用魔窗的短链做 一键唤醒】
	
	public String getProduct_key() {
		return product_key;
	}
	public void setProduct_key(String product_key) {
		this.product_key = product_key;
	}
	public String getShort_uri() {
		return short_uri;
	}
	public void setShort_uri(String short_uri) {
		this.short_uri = short_uri;
	}
	public String getClick_behavior() {
		return click_behavior;
	}
	public void setClick_behavior(String click_behavior) {
		this.click_behavior = click_behavior;
	}

	
}
