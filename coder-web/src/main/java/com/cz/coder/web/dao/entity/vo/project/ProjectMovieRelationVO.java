package com.fq.dao.entity.vo.project;

/**
 * 
 * @ClassName ProjectMovieRelationVO  
 * @Description 项目影片关系信息表VO  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-4-15
 */
public class ProjectMovieRelationVO {

	private Integer piId ;  //项目id 
	private Integer mId ; // 影片id
	private Integer episodeNo ; // 第几集 
 	private String isLast ; // 是否是最后一集Y：是；N:否
 	
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
	public Integer getEpisodeNo() {
		return episodeNo;
	}
	public void setEpisodeNo(Integer episodeNo) {
		this.episodeNo = episodeNo;
	}
	public String getIsLast() {
		return isLast;
	}
	public void setIsLast(String isLast) {
		this.isLast = isLast;
	}
 	
}
