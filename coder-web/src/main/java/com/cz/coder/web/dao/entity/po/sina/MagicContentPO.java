package com.fq.dao.entity.po.sina;

import java.util.List;

/**
 * 
 * @ClassName MagicContentPO  
 * @Description 魔窗内容分发PO  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-12-1
 */
public class MagicContentPO {

	private String content_id ;// 项目id
	private String content ; // 漫画介绍
	private String rendering_type ; // comic_series（漫画剧）
	private String content_image_uri ;// 漫画总封面
	private String image_uri ; // 每个漫画在列表页上的长banner图用image_uri来传
	private String title ; // 漫画标题
	private String shorten_uri ; // 
	private String long_title ;
	private List<String> ref_content_ids ; // 漫画剧集的id列表
	private String summary ;
	private List<String> tags ;// 每个漫画的标签请用tags字段中的m:tag来传，即m:言情，m:总裁，m:傲娇。
	private Object authorized_to ; //是否授权：{"mw":true}：授权投放;{"mw":true}：测试数据，未授权
	private MagicContentBook book ;
	
	public String getContent_id() {
		return content_id;
	}
	public void setContent_id(String content_id) {
		this.content_id = content_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRendering_type() {
		return rendering_type;
	}
	public void setRendering_type(String rendering_type) {
		this.rendering_type = rendering_type;
	}
	public String getContent_image_uri() {
		return content_image_uri;
	}
	public void setContent_image_uri(String content_image_uri) {
		this.content_image_uri = content_image_uri;
	}
	public String getImage_uri() {
		return image_uri;
	}
	public void setImage_uri(String image_uri) {
		this.image_uri = image_uri;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getShorten_uri() {
		return shorten_uri;
	}
	public void setShorten_uri(String shorten_uri) {
		this.shorten_uri = shorten_uri;
	}
	public String getLong_title() {
		return long_title;
	}
	public void setLong_title(String long_title) {
		this.long_title = long_title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Object getAuthorized_to() {
		return authorized_to;
	}
	public void setAuthorized_to(Object authorized_to) {
		this.authorized_to = authorized_to;
	}
	public List<String> getRef_content_ids() {
		return ref_content_ids;
	}
	public void setRef_content_ids(List<String> ref_content_ids) {
		this.ref_content_ids = ref_content_ids;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public MagicContentBook getBook() {
		return book;
	}
	public void setBook(MagicContentBook book) {
		this.book = book;
	}
	
	
}
