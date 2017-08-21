package com.fq.dao.entity.po;

/**
 * 项目影片关系表
 * @author zhen.cheng
 *
 */
public class ProjectMovieRelationPO {

	private Integer pmrId ;
	private Integer piId ;
	private Integer mId ;
	private Integer episodeNo ;
	private String isLast ;
	public Integer getPmrId() {
		return pmrId;
	}
	public void setPmrId(Integer pmrId) {
		this.pmrId = pmrId;
	}
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
	public String getIsLast() {
		return isLast;
	}
	public void setIsLast(String isLast) {
		this.isLast = isLast;
	}
	public Integer getEpisodeNo() {
		return episodeNo;
	}
	public void setEpisodeNo(Integer episodeNo) {
		this.episodeNo = episodeNo;
	}
	
	
	
}
