package com.fq.dao.entity.vo;
/**
 * 选书活动,书本对象
 * @author chen.zhao 
 *
 */
public class OscarActiveBookVO {
	private Integer oabId ; 
	private Integer oaId ;
	private String  bookAuthor ;
	private String  bookName ;
	private String  bookWords ;
	private String  bookDetail ;
	private String  bookCoverUrl ;
	private Integer voteTotalNum ;
	private String  bookType ; 
	private String  bookTags ; 
	private Integer orderIndex ;
	private String  qiniuUrl ;
	private Integer voteCnt ;
	public Integer getOabId() {
		return oabId;
	}
	public void setOabId(Integer oabId) {
		this.oabId = oabId;
	}
	public Integer getOaId() {
		return oaId;
	}
	public void setOaId(Integer oaId) {
		this.oaId = oaId;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookWords() {
		return bookWords;
	}
	public void setBookWords(String bookWords) {
		this.bookWords = bookWords;
	}
	public String getBookDetail() {
		return bookDetail;
	}
	public void setBookDetail(String bookDetail) {
		this.bookDetail = bookDetail;
	}
	public String getBookCoverUrl() {
		return bookCoverUrl;
	}
	public void setBookCoverUrl(String bookCoverUrl) {
		this.bookCoverUrl = bookCoverUrl;
	}
	public Integer getVoteTotalNum() {
		return voteTotalNum;
	}
	public void setVoteTotalNum(Integer voteTotalNum) {
		this.voteTotalNum = voteTotalNum;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public String getBookTags() {
		return bookTags;
	}
	public void setBookTags(String bookTags) {
		this.bookTags = bookTags;
	}
	public Integer getOrderIndex() {
		return orderIndex;
	}
	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}
	public String getQiniuUrl() {
		return qiniuUrl;
	}
	public void setQiniuUrl(String qiniuUrl) {
		this.qiniuUrl = qiniuUrl;
	}
	public Integer getVoteCnt() {
		return voteCnt;
	}
	public void setVoteCnt(Integer voteCnt) {
		this.voteCnt = voteCnt;
	}
	
}
