package com.phm.community.service;

import java.util.List;

import com.phm.community.entity.Board;
import com.phm.community.entity.Reply;

public interface BoardService {
	public List<Board> getBoards();
	public void saveBoard(Board board);
	public Board getBoard(int idx);
	public void deleteBoard(int idx);
	// 추후 검색 관련 메서드 추가 필요

	// 덧글 관련
	public List<Reply> getRepliesByIdx(int idx);
	public void saveOrUpdateReply(Reply reply);
	// 마지막 insertId 얻기
	public long getLastInsertId();
}
