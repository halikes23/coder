package com.fq.entity.vo.book;
/**
 * 阅明小说书籍对象
 * @author chen.zhao 
 *
 */
public class YueMingBookInfoVO {
	private Integer bookid ;//书籍ID
	private String  bookname ; //书籍名称
	private String  authorname ; //作者
	private Integer cname ;//作品类型
	private String  bookpic ; //封面
	private Integer bksize ; //小说字数
	private String writestatus ; //完成状态
	private String  zzjs ; //作者简介
	private String  createtime ; //创建时间
	private Integer gender ; //男女频
	private String  keywords ; //关键字
	private String  coverKey ;//封面图片key
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public Integer getCname() {
		return cname;
	}
	public void setCname(Integer cname) {
		this.cname = cname;
	}
	public String getBookpic() {
		return bookpic;
	}
	public void setBookpic(String bookpic) {
		this.bookpic = bookpic;
	}
	public Integer getBksize() {
		return bksize;
	}
	public void setBksize(Integer bksize) {
		this.bksize = bksize;
	}
	public String getWritestatus() {
		return writestatus;
	}
	public void setWritestatus(String writestatus) {
		this.writestatus = writestatus;
	}
	public String getZzjs() {
		return zzjs;
	}
	public void setZzjs(String zzjs) {
		this.zzjs = zzjs;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getCoverKey() {
		return coverKey;
	}
	public void setCoverKey(String coverKey) {
		this.coverKey = coverKey;
	}
	
}
