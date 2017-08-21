package com.fq.dao.entity.po;

/**
 * 
 * @ClassName LikingRelPO  
 * @Description 好感度  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-6-24
 */
public class LikingRelPO {
    private Integer likingId ; 
	private String  account1 ;
	private String  account2 ;
	private Integer likingVol ;

	public Integer getLikingId() {
		return likingId;
	}
	public void setLikingId(Integer likingId) {
		this.likingId = likingId;
	}
	public String getAccount1() {
		return account1;
	}
	public void setAccount1(String account1) {
		this.account1 = account1;
	}
	public String getAccount2() {
		return account2;
	}
	public void setAccount2(String account2) {
		this.account2 = account2;
	}
	public Integer getLikingVol() {
		return likingVol;
	}
	public void setLikingVol(Integer likingVol) {
		this.likingVol = likingVol;
	}
	
}
