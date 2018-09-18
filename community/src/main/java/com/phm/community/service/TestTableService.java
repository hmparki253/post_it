package com.phm.community.service;

import java.util.List;

import com.phm.community.entity.Board;
import com.phm.community.entity.TestTable;

public interface TestTableService {
	public void saveTestTable(TestTable testTable);
	public TestTable getTestTable(int idx);
	public long getLastInsertId();
	public List<Board> getBoardByPagination(int curPage, int pageSize);
	// 전체 게시글 count 가져오기
	public long getBoardsCount();
}
