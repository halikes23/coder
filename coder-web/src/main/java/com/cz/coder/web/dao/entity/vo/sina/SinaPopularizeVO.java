package com.fq.dao.entity.vo.sina;

public class SinaPopularizeVO {
	private Integer spId ; // 主键id
	private String id ;// 内容id
	private String title ;//内容标题 超过15个字符，新浪展示 的时候会做截取
	private String content ;// 详细内容  具体内容
	private String summary ;//内容摘要 反应内容摘要的图片URI[用于在新浪等流量分发方的banner位显示， 超过35个字符，新浪展示 的时候会做截取]
	private String imageUri ;// 在分发平台曝光的内容图 片的URI [ 比如再新浪广告位展示的 内容图片URI，建议160x 120，大小不要超过20K]
	private String contentImageUri ;//在内容预览页里显示的图 片的uri【在内容预览页里显示的图 片的uri，魔窗这边会做一 下自适应 】
	private String contentUri ;//该内容对应的h5的URI【有些app，比如电商类ap p，已经有对应的h5的内 容展示页面了，如果有则 在这里传递】
	private String contentFormat ;//内容格式 【比如是纯文本还是h5， “p”是纯文本，“h”是H5， 默认是"p"】
	private String productKey ;//此内容所属app在魔窗中 的所属产品key
	private String shortUri ;//该内容对应的魔窗mLink 短链【因为每个内容都对应app 内的一个内容页，为了实 现一键唤醒，需要在内容 中指明该内容对应的一键 唤醒短链，并且再创建短 链的同时，选择内容分发 平台的渠道，比如新浪， 参照下图。 该锻炼需要拼接上表明该 内容的内容id，比如http: //a.mlinks.cc/Azdj?cont ent_id=123】
	private String clickBehavior ;// 再内容分发平台曝光时， 用户点击后的跳转策略【c，表明跳转的地址是con tent_uri，表明客户希望 先让用户看到内容本身， 然后在内容的h5页面再做 一键唤醒。s, 代表short_uri, 表明直接用魔窗的短链做 一键唤醒】
	private Integer test ;//是否是测试数据【如果是测试数据，不会发 送给内容分发平台, 0代表不是测试数据，1代 表是】
	private Long lastModifiedDate ;//该内容的最后修改时间 【长整型，北京时间 ，距1970年的时间戳，单 位：毫秒】
	private Integer count ;//该批次总共的内容数量
	
	public Integer getSpId() {
		return spId;
	}
	public void setSpId(Integer spId) {
		this.spId = spId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getImageUri() {
		return imageUri;
	}
	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}
	public String getContentImageUri() {
		return contentImageUri;
	}
	public void setContentImageUri(String contentImageUri) {
		this.contentImageUri = contentImageUri;
	}
	public String getContentUri() {
		return contentUri;
	}
	public void setContentUri(String contentUri) {
		this.contentUri = contentUri;
	}
	public String getContentFormat() {
		return contentFormat;
	}
	public void setContentFormat(String contentFormat) {
		this.contentFormat = contentFormat;
	}
	public String getProductKey() {
		return productKey;
	}
	public void setProductKey(String productKey) {
		this.productKey = productKey;
	}
	public String getShortUri() {
		return shortUri;
	}
	public void setShortUri(String shortUri) {
		this.shortUri = shortUri;
	}
	public String getClickBehavior() {
		return clickBehavior;
	}
	public void setClickBehavior(String clickBehavior) {
		this.clickBehavior = clickBehavior;
	}
	public Integer getTest() {
		return test;
	}
	public void setTest(Integer test) {
		this.test = test;
	}
	public Long getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Long lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}
