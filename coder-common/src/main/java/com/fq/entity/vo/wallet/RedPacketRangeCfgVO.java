package com.fq.entity.vo.wallet;

/**
 * 红包范围码对象 
 * @author chen.zhao 
 *
 */
public class RedPacketRangeCfgVO {
	
	private Integer rprId ; // 主键ID
	
	private Integer usedCnt ; // 当前已用次数
	
	private Integer totalCnt ; // 总次数
	
	private Integer bkRprId ; // 用光之后备选id
	
	private String 	creatorAccount ; // 创建者
	
	private String  createDt ; // 创建时间 
	
	private String  isDeleted ; // 伪删除标记为Y:已被删除；N:未被删除
	
	private String  rangeType ; // 范围类型：1：默认组；2：红脸组；3：黑脸组；4：被邀请组
	
	private String percent ;
	
	private String bkRprIdDes ;
	

	public Integer getRprId() {
		return rprId;
	}
	
	public void setRprId(Integer rprId) {
		this.rprId = rprId;
	}

	public Integer getUsedCnt() {
		return usedCnt;
	}

	public void setUsedCnt(Integer usedCnt) {
		this.usedCnt = usedCnt;
	}

	public Integer getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(Integer totalCnt) {
		this.totalCnt = totalCnt;
	}

	public Integer getBkRprId() {
		return bkRprId;
	}

	public void setBkRprId(Integer bkRprId) {
		this.bkRprId = bkRprId;
	}


	public String getCreatorAccount() {
		return creatorAccount;
	}

	public void setCreatorAccount(String creatorAccount) {
		this.creatorAccount = creatorAccount;
	}

	public String getCreateDt() {
		return createDt;
	}

	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	
	public String getIsDeleted() {
		return isDeleted;
	}
	
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getRangeType() {
		return rangeType;
	}

	public void setRangeType(String rangeType) {
		this.rangeType = rangeType;
	}

	public String getPercent() {
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}

	public String getBkRprIdDes() {
		return bkRprIdDes;
	}

	public void setBkRprIdDes(String bkRprIdDes) {
		this.bkRprIdDes = bkRprIdDes;
	}

	
	
}
