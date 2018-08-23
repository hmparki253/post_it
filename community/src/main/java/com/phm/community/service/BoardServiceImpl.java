package com.phm.community.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phm.community.dao.BoardDAO;
import com.phm.community.entity.Board;
import com.phm.community.entity.Reply;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Transactional
	@Override
	public List<Board> getBoards() {
		return boardDAO.getBoards();
	}

	@Transactional
	@Override
	public void saveBoard(Board board) {
		boardDAO.saveBoard(board);
	}

	@Transactional
	@Override
	public Board getBoard(int idx) {
		return boardDAO.getBoard(idx);
	}

	@Transactional
	@Override
	public void deleteBoard(int idx) {
		boardDAO.deleteBoard(idx);
	}

	@Transactional
	@Override
	public List<Reply> getRepliesByIdx(int idx) {
		return boardDAO.getRepliesByIdx(idx);
	}

	@Transactional
	@Override
	public void saveOrUpdateReply(Reply reply) {
		boardDAO.saveOrUpdateReply(reply);
	}

	@Transactional
	@Override
	public long getLastInsertId() {
		return boardDAO.getLastInsertId();
	}
}
