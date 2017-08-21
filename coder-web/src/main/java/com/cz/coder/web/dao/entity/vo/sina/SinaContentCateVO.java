package com.fq.dao.entity.vo.sina;

public class SinaContentCateVO {

	private Integer sccId ; 
	private Integer spId ; // c_sina_popularize 外键
	private Integer contentCateId ; // 内容标签id
	private String  contentCateName ;// 内容标签名
	
	public Integer getSccId() {
		return sccId;
	}
	public void setSccId(Integer sccId) {
		this.sccId = sccId;
	}
	public Integer getSpId() {
		return spId;
	}
	public void setSpId(Integer spid) {
		this.spId = spid;
	}
	public Integer getContentCateId() {
		return contentCateId;
	}
	public void setContentCateId(Integer contentCateId) {
		this.contentCateId = contentCateId;
	}
	public String getContentCateName() {
		return contentCateName;
	}
	public void setContentCateName(String contentCateName) {
		this.contentCateName = contentCateName;
	} 
	
}
