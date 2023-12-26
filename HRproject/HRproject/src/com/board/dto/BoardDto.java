package com.board.dto;

public class BoardDto {
	//게시글 번호(시퀀스)
	private int num;
	//작성자
	private String name;
	//제목
	private String subject;
	//내용
	private String content;
	//조회수
	private int view_cnt;
	//작성일
	private String reg_date;
	//비밀번호
	private String pw;
	
	public BoardDto() {}
	
	public BoardDto(int num, String name, String subject, String content, int view_cnt, String reg_date, String pw) {
		super();
		this.num = num;
		this.name = name;
		this.subject = subject;
		this.content = content;
		this.view_cnt = view_cnt;
		this.reg_date = reg_date;
		this.pw = pw;
	}

	public BoardDto(int num, String name, String subject, int view_cnt, String reg_date) {
		super();
		this.num = num;
		this.name = name;
		this.subject = subject;
		this.view_cnt = view_cnt;
		this.reg_date = reg_date;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getView_cnt() {
		return view_cnt;
	}
	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
}