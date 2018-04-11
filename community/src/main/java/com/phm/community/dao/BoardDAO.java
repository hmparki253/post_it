package com.phm.community.dao;

import java.util.List;

import com.phm.community.entity.Board;

public interface BoardDAO {
	public List<Board> getBoards();
	public void saveBoard(Board board);
	public Board getBoard(int idx);
	public void deleteBoard(int idx);
	// search 관련 추가 요망 
}
