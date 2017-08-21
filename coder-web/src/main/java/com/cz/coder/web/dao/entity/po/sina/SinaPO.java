package com.fq.dao.entity.po.sina;

import java.util.List;

public class SinaPO {
	
	private List<SinaAppCatePO> app_cate ;// 应用标签列表
	private List<SinaContentCatePO> content_cate ; //内容标签列表 
	
	public List<SinaAppCatePO> getApp_cate() {
		return app_cate;
	}
	public void setApp_cate(List<SinaAppCatePO> app_cate) {
		this.app_cate = app_cate;
	}
	public List<SinaContentCatePO> getContent_cate() {
		return content_cate;
	}
	public void setContent_cate(List<SinaContentCatePO> content_cate) {
		this.content_cate = content_cate;
	}

	
}
