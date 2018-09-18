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
	
	// 페이지네이션으로 끊어서 가져오기 
	public List<Board> getBoardByPagination(int curPage, int pageSize);
	// 전체 게시글 count 가져오기
	public long getBoardsCount();
}
