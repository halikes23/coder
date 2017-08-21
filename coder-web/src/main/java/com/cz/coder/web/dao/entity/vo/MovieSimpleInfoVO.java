package com.fq.dao.entity.vo;

/**
 * 
 * @ClassName MovieSimpleInfoVO  
 * @Description 视频信息VO  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-1-30
 */
public class MovieSimpleInfoVO {
	private Integer piId ; // 项目id
    private Integer mId ;  // 影片id 
	private String  state  ; // 影片进度
	private Integer capitalCurrent  ; // 当前加血量
    private Integer projectCapitalTotal ; // 每集加血上限
    private String  projectBigPapaAccount ; // 金主（大爸爸）账号
    private String  projectFirstBloodAccount ; // 金主（大爸爸）账号
    private String goldMasterAccount ;
    private Integer goldMasterAmount ;
    
	public Integer getPiId() {
		return piId;
	}
	public void setPiId(Integer piId) {
		this.piId = piId;
	}
	public Integer getmId() {
		return mId;
	}
	public void setmId(Integer mId) {
		this.mId = mId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getCapitalCurrent() {
		return capitalCurrent;
	}
	public void setCapitalCurrent(Integer capitalCurrent) {
		this.capitalCurrent = capitalCurrent;
	}
	public Integer getProjectCapitalTotal() {
		return projectCapitalTotal;
	}
	public void setProjectCapitalTotal(Integer projectCapitalTotal) {
		this.projectCapitalTotal = projectCapitalTotal;
	}
	public String getProjectBigPapaAccount() {
		return projectBigPapaAccount;
	}
	public void setProjectBigPapaAccount(String projectBigPapaAccount) {
		this.projectBigPapaAccount = projectBigPapaAccount;
	}
	public String getProjectFirstBloodAccount() {
		return projectFirstBloodAccount;
	}
	public void setProjectFirstBloodAccount(String projectFirstBloodAccount) {
		this.projectFirstBloodAccount = projectFirstBloodAccount;
	}
	public String getGoldMasterAccount() {
		return goldMasterAccount;
	}
	public void setGoldMasterAccount(String goldMasterAccount) {
		this.goldMasterAccount = goldMasterAccount;
	}
	public Integer getGoldMasterAmount() {
		return goldMasterAmount;
	}
	public void setGoldMasterAmount(Integer goldMasterAmount) {
		this.goldMasterAmount = goldMasterAmount;
	}
	
	
}
