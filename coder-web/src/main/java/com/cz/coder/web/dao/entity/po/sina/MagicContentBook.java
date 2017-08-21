package com.fq.dao.entity.po.sina;

/**
 * 
 * @ClassName MagicContentBook  
 * @Description book  
 * @author jingkun.chen cjk_jing@163.com  
 * @date 2016-12-1
 */
public class MagicContentBook {

	private String name ;// 名字
	private String author ;// 作者
	private String genre ;// 书籍风格分类：常见如科幻/武侠等
	private String modified_date ; // 更新时间
	private boolean locked ; // 是否需要解锁
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	public String getModified_date() {
		return modified_date;
	}
	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}
	
}
