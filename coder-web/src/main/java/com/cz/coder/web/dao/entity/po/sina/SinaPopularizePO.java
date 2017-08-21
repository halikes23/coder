package com.fq.dao.entity.po.sina;


public class SinaPopularizePO {

	private String id ;// 内容id
	private String title ;//内容标题 超过15个字符，新浪展示 的时候会做截取
	private String content ;// 详细内容  具体内容
	private Integer test ;//是否是测试数据【如果是测试数据，不会发 送给内容分发平台, 0代表不是测试数据，1代 表是】
	private long last_modified_date ;//该内容的最后修改时间 【长整型，北京时间 ，距1970年的时间戳，单 位：毫秒】
	private SinaMetaPO meta ;
	private SinaMlinkPO mlink ;
	private SinaTagsPO tags ;
	
	
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
	public Integer getTest() {
		return test;
	}
	public void setTest(Integer test) {
		this.test = test;
	}
	public long getLast_modified_date() {
		return last_modified_date;
	}
	public void setLast_modified_date(long last_modified_date) {
		this.last_modified_date = last_modified_date;
	}
	public SinaMetaPO getMeta() {
		return meta;
	}
	public void setMeta(SinaMetaPO meta) {
		this.meta = meta;
	}
	public SinaMlinkPO getMlink() {
		return mlink;
	}
	public void setMlink(SinaMlinkPO mlink) {
		this.mlink = mlink;
	}
	public SinaTagsPO getTags() {
		return tags;
	}
	public void setTags(SinaTagsPO tags) {
		this.tags = tags;
	}
	
}
