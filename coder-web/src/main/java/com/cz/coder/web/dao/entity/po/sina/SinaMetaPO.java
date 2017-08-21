package com.fq.dao.entity.po.sina;

public class SinaMetaPO {
	
	private String summary ;//内容摘要 反应内容摘要的图片URI[用于在新浪等流量分发方的banner位显示， 超过35个字符，新浪展示 的时候会做截取]
	private String image_uri ;// 在分发平台曝光的内容图 片的URI [ 比如再新浪广告位展示的 内容图片URI，建议160x 120，大小不要超过20K]
	private String content_image_uri ;//在内容预览页里显示的图 片的uri【在内容预览页里显示的图 片的uri，魔窗这边会做一 下自适应 】
	private String content_uri ;//该内容对应的h5的URI【有些app，比如电商类ap p，已经有对应的h5的内 容展示页面了，如果有则 在这里传递】
	private String content_format ;//内容格式 【比如是纯文本还是h5， “p”是纯文本，“h”是H5， 默认是"p"】
	
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getImage_uri() {
		return image_uri;
	}
	public void setImage_uri(String image_uri) {
		this.image_uri = image_uri;
	}
	public String getContent_image_uri() {
		return content_image_uri;
	}
	public void setContent_image_uri(String content_image_uri) {
		this.content_image_uri = content_image_uri;
	}
	public String getContent_uri() {
		return content_uri;
	}
	public void setContent_uri(String content_uri) {
		this.content_uri = content_uri;
	}
	public String getContent_format() {
		return content_format;
	}
	public void setContent_format(String content_format) {
		this.content_format = content_format;
	}
}
