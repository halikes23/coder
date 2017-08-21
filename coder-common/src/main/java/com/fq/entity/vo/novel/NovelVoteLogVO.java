package com.fq.entity.vo.novel;
/**
 * 小说获取选票日志对象VO
 * @author chen.zhao 
 *
 */
public class NovelVoteLogVO {
	
	private Integer nvlId ; //主键ID
	private Integer niId ; // 小说ID 
	private String  account ; // 用户账号
	private Integer oavId ; //选票ID 
	private Integer voteWeight ; // 选票权重
	private String  createDt ; //创建日期
	private String  createTm ; //创建时间
	
	public Integer getNvlId() {
		return nvlId;
	}
	public void setNvlId(Integer nvlId) {
		this.nvlId = nvlId;
	}
	public Integer getNiId() {
		return niId;
	}
	public void setNiId(Integer niId) {
		this.niId = niId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Integer getOavId() {
		return oavId;
	}
	public void setOavId(Integer oavId) {
		this.oavId = oavId;
	}
	public Integer getVoteWeight() {
		return voteWeight;
	}
	public void setVoteWeight(Integer voteWeight) {
		this.voteWeight = voteWeight;
	}
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	public String getCreateTm() {
		return createTm;
	}
	public void setCreateTm(String createTm) {
		this.createTm = createTm;
	}
	
	
}
