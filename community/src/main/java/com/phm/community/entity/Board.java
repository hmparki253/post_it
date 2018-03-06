package com.phm.community.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="board")
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private int idx;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "writer")
	private String writer;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "reg_dt")
	private Date regDt;
	
	@Column(name = "enabled")
	private int enabled;
	
	public Board() { }

	public Board(String title, String content, String writer, Date regDt) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regDt = regDt;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegDt() {
		return regDt;
	}

	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Board [idx=" + idx + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regDt="
				+ regDt + ", enabled=" + enabled + "]";
	}

}
