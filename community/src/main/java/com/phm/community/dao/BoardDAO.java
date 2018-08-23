package com.phm.community.dao;

import java.util.List;

import com.phm.community.entity.Board;
import com.phm.community.entity.Reply;

public interface BoardDAO {
	public List<Board> getBoards();
	public void saveBoard(Board board);
	public Board getBoard(int idx);
	public void deleteBoard(int idx);
	// search 관련 추가 요망
	
	// 덧글 관련 
	public List<Reply> getRepliesByIdx(int idx);
	public void saveOrUpdateReply(Reply reply);
	// 마지막 insertid 가져오는 function
	public long getLastInsertId();
}
