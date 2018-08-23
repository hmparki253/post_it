package com.phm.community.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reply")
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private int idx;
	
	@Column(name = "board_idx")
	private int boardIdx;
	
	@Column(name = "family")
	private int family;
	
	@Column(name = "parent")
	private int parent;
	
	@Column(name = "depth")
	private int depth;
	
	@Column(name = "indent")
	private int indent;
	
	@Column(name = "writer")
	private String writer;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "reg_dt")
	private Date regDt;
	
	@Column(name = "enabled")
	private int enabled;
	
	public Reply() { }

	public Reply(int boardIdx, int family, int parent, int depth, int indent, String writer, String content,
			Date regDt, int enabled) {
		this.boardIdx = boardIdx;
		this.family = family;
		this.parent = parent;
		this.depth = depth;
		this.indent = indent;
		this.writer = writer;
		this.content = content;
		this.regDt = regDt;
		this.enabled = enabled;
	}
	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getBoardIdx() {
		return boardIdx;
	}

	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
	}

	public int getFamily() {
		return family;
	}

	public void setFamily(int family) {
		this.family = family;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getIndent() {
		return indent;
	}

	public void setIndent(int indent) {
		this.indent = indent;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
		return "Reply [idx=" + idx + ", boardIdx=" + boardIdx + ", family=" + family + ", parent=" + parent + ", depth="
				+ depth + ", indent=" + indent + ", writer=" + writer + ", content=" + content + ", regDt=" + regDt
				+ "]";
	}
}
