package com.phm.community.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phm.community.dao.BoardDAO;
import com.phm.community.entity.Board;

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

	@Override
	public void deleteCustomer(int idx) {
		// TODO Auto-generated method stub

	}

}
