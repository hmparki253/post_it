package com.phm.community.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_table")
public class TestTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private int idx;
	private String letters;
	
	public TestTable() { }

	public TestTable(String letters) {
		this.letters = letters;
	}
	
	public int getIdx() {
		return idx;
	}
	
	public String getLetters() {
		return letters;
	}
	
	public void setLetters(String letters) {
		this.letters = letters;
	}
}
