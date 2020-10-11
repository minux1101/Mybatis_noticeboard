package com.gongji.dto;

import java.util.Date;

public class GongjiVO {
	private int id; //공지의 id
	private String title; //공지의 제목
	private Date date; //공지를 쓴 날짜
	private String content; //공지의 내용

	public int getId() { //id의 getter
		return id;
	}

	public void setId(int id) { //id의 setter
		this.id = id;
	}

	public String getTitle() { //제목의 getter
		return title;
	}

	public void setTitle(String title) { //제목의 setter
		this.title = title;
	}

	public Date getDate() { //날짜의 getter
		return date;
	}

	public void setDate(Date date) { //날짜의 setter
		this.date = date;
	}

	public String getContent() { //내용의 getter
		return content;
	}

	public void setContent(String content) { //내용의 setter
		this.content = content;
	}
}
