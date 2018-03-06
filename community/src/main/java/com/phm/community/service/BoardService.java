package com.phm.community.service;

import java.util.List;

import com.phm.community.entity.Board;

public interface BoardService {
	public List<Board> getBoards();
	public void saveBoard(Board board);
	public Board getBoard(int idx);
	public void deleteCustomer(int idx);
	// 추후 검색 관련 메서드 추가 필요 
}
