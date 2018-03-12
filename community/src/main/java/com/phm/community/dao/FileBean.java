package com.phm.community.dao;

import org.springframework.web.multipart.MultipartFile;

public class FileBean {
	private String attachPath;
	private MultipartFile upload;
	private String filename;
	private String CKEditorFuncNum; // 저장할 대상을 기억하기 위한 값을 저장하는 변수
	
	public String getAttachPath() {
		return attachPath;
	}
	public void setAttachPath(String attachPath) {
		this.attachPath = attachPath;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getCKEditorFuncNum() {
		return CKEditorFuncNum;
	}
	public void setCKEditorFuncNum(String cKEditorFuncNum) {
		CKEditorFuncNum = cKEditorFuncNum;
	}
}
