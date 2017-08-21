package com.fq.dao.entity.vo.livecartoon;

import java.util.List;

/**
 * 
 * @ClassName LiveCartoonInfoVO  
 * @Description 漫画项目基本信息  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-12-7
 */
public class LiveCartoonInfoVO {

	private String plcId ;// 项目id
	private String cartoonDesc ; // 漫画介绍 content
	private String cartoonCoverUrl ;// 漫画总封面  content_iamge_uri
	private String chapterCoverUrl ; // 每个漫画在列表页上的长banner图用image_uri来传
	private String cartoonTitle ; // 漫画标题title
	private List<String> refContentIds ; // 漫画剧集的id列表 ref_content_ids
	private String summary ; // 每一话的内容简介
	private String projectTags ;// 每个漫画的标签请用tags字段中的m:tag来传，即m:言情，m:总裁，m:傲娇。
	private String projectAuthor ; // 作者
	private String projectDescOriginal ; //原著
	private Integer playTotalCount ; //播放总量
	private Integer unlockTotalCount ; //解锁人数
	private Integer lcId ; 
	
	
	public String getPlcId() {
		return plcId;
	}
	public void setPlcId(String plcId) {
		this.plcId = plcId;
	}
	public String getCartoonDesc() {
		return cartoonDesc;
	}
	public void setCartoonDesc(String cartoonDesc) {
		this.cartoonDesc = cartoonDesc;
	}
	public String getCartoonCoverUrl() {
		return cartoonCoverUrl;
	}
	public void setCartoonCoverUrl(String cartoonCoverUrl) {
		this.cartoonCoverUrl = cartoonCoverUrl;
	}
	public String getChapterCoverUrl() {
		return chapterCoverUrl;
	}
	public void setChapterCoverUrl(String chapterCoverUrl) {
		this.chapterCoverUrl = chapterCoverUrl;
	}
	public String getCartoonTitle() {
		return cartoonTitle;
	}
	public void setCartoonTitle(String cartoonTitle) {
		this.cartoonTitle = cartoonTitle;
	}
	public List<String> getRefContentIds() {
		return refContentIds;
	}
	public void setRefContentIds(List<String> refContentIds) {
		this.refContentIds = refContentIds;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getProjectTags() {
		return projectTags;
	}
	public void setProjectTags(String projectTags) {
		this.projectTags = projectTags;
	}
	public String getProjectAuthor() {
		return projectAuthor;
	}
	public void setProjectAuthor(String projectAuthor) {
		this.projectAuthor = projectAuthor;
	}
	public String getProjectDescOriginal() {
		return projectDescOriginal;
	}
	public void setProjectDescOriginal(String projectDescOriginal) {
		this.projectDescOriginal = projectDescOriginal;
	}
	public Integer getPlayTotalCount() {
		return playTotalCount;
	}
	public void setPlayTotalCount(Integer playTotalCount) {
		this.playTotalCount = playTotalCount;
	}
	public Integer getUnlockTotalCount() {
		return unlockTotalCount;
	}
	public void setUnlockTotalCount(Integer unlockTotalCount) {
		this.unlockTotalCount = unlockTotalCount;
	}
	public Integer getLcId() {
		return lcId;
	}
	public void setLcId(Integer lcId) {
		this.lcId = lcId;
	}
	
}
