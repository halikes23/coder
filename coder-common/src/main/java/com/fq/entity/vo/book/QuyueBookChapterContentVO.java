package com.fq.entity.vo.book;

public class QuyueBookChapterContentVO {
	
	private Integer id ; //章节ID
	private String title ; 
	private String content  ; 
	private String is_free ; 
	private String create_time ; 
	private String author_note ; 
	private String b_id ;//书籍ID
	private Integer chapterWords ; //章节字数
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIs_free() {
		return is_free;
	}
	public void setIs_free(String is_free) {
		this.is_free = is_free;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getAuthor_note() {
		return author_note;
	}
	public void setAuthor_note(String author_note) {
		this.author_note = author_note;
	}
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public Integer getChapterWords() {
		return chapterWords;
	}
	public void setChapterWords(Integer chapterWords) {
		this.chapterWords = chapterWords;
	}
	
}
