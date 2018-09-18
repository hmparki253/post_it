package com.phm.community.dao;

import com.phm.community.entity.TestTable;

public interface TestTableDAO {
	public void saveTestTable(TestTable testTable);
	public TestTable getTestTable(int idx);
	public long getLastInsertId();
}
