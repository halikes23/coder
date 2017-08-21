package com.fq.form.movie;

/**
 * 
 * @ClassName QueryMoviePartBulletScreenListsForm  
 * @Description 查询影片片段弹幕信息列表  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-4-8
 */
public class QueryMoviePartBulletScreenListsForm {
	private Integer mpId ;
    private Integer mId ;
    private String account ;
    private String userNick ; 
    private String contents ;
	
	public Integer getMId() {
		return mId;
	}
	public void setMId(Integer mId) {
		this.mId = mId;
	}
	public Integer getMpId() {
		return mpId;
	}
	public void setMpId(Integer mpId) {
		this.mpId = mpId;
	}
	public Integer getmId() {
		return mId;
	}
	public void setmId(Integer mId) {
		this.mId = mId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
}
