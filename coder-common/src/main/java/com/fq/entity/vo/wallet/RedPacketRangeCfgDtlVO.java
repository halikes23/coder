package com.fq.entity.vo.wallet;

import com.fq.common.util.IRandomBean;

/**
 * 红包范围配置明细 对象
 * @author chen.zhao 
 *
 */
public class RedPacketRangeCfgDtlVO implements IRandomBean {
	
	private Integer rprdId ; // 主键ID
	
	private Integer rprId ;  // 外键ID(红包配置总表)
	
	private String  rangeCode ; // 范围类型：1：一级范围；2：二级范围；3：三级范围
	
	private Integer minAmt ; // 范围金额最小值
	
	private Integer maxAmt ; // 范围金额最大值
	
	private Integer usedCnt ; // 当前已用次数
	
	private Integer totalCnt ; // 总次数
	
	private Integer percent ; // 人数百分比xx%
	
	private String  isDeleted ; // 伪删除标记位：Y：已删除；N:未删除
	
	private String  creatorAccount ; // 创建者帐号
	
	private String  createDt ; // 创建时间yyyy-MM-dd hh:mm:ss
	
	private String  deletorAccount ; // 删除者帐号（管理员）
	
	private String  deleteDt ; // 删除时间
	
	
	
	public Integer getRprdId() {
		return rprdId;
	}
	
	public void setRprdId(Integer rprdId) {
		this.rprdId = rprdId;
	}

	public Integer getRprId() {
		return rprId;
	}

	public void setRprId(Integer rprId) {
		this.rprId = rprId;
	}

	public String getRangeCode() {
		return rangeCode;
	}

	public void setRangeCode(String rangeCode) {
		this.rangeCode = rangeCode;
	}

	public Integer getMinAmt() {
		return minAmt;
	}

	public void setMinAmt(Integer minAmt) {
		this.minAmt = minAmt;
	}

	public Integer getMaxAmt() {
		return maxAmt;
	}

	public void setMaxAmt(Integer maxAmt) {
		this.maxAmt = maxAmt;
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

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
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

	public String getDeletorAccount() {
		return deletorAccount;
	}

	public void setDeletorAccount(String deletorAccount) {
		this.deletorAccount = deletorAccount;
	}

	public String getDeleteDt() {
		return deleteDt;
	}

	public void setDeleteDt(String deleteDt) {
		this.deleteDt = deleteDt;
	}

	public Integer getPercent() {
		return percent;
	}

	public void setPercent(Integer percent) {
		this.percent = percent;
	}

	public Integer getCount() {
		return totalCnt - usedCnt ;
	}

	

}
