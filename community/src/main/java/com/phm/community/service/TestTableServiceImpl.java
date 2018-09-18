package com.phm.community.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phm.community.dao.BoardDAO;
import com.phm.community.dao.TestTableDAO;
import com.phm.community.entity.Board;
import com.phm.community.entity.TestTable;

@Service
public class TestTableServiceImpl implements TestTableService {

	@Autowired
	private TestTableDAO testTableDAO;
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Transactional
	@Override
	public void saveTestTable(TestTable testTable) {
		testTableDAO.saveTestTable(testTable);
	}

	@Transactional
	@Override
	public TestTable getTestTable(int idx) {
		return testTableDAO.getTestTable(idx);
	}

	@Transactional
	@Override
	public long getLastInsertId() {
		return testTableDAO.getLastInsertId();
	}

	@Transactional
	@Override
	public List<Board> getBoardByPagination(int curPage, int pageSize) {
		return boardDAO.getBoardByPagination(curPage, pageSize);
	}

	@Transactional
	@Override
	public long getBoardsCount() {
		return boardDAO.getBoardsCount();
	}

}
