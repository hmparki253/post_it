package com.phm.community.dao;

import java.math.BigInteger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phm.community.entity.TestTable;

@Repository
public class TestTableDAOImpl implements TestTableDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveTestTable(TestTable testTable) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(testTable);
	}

	@Override
	public TestTable getTestTable(int idx) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<TestTable> theQuery = 
				currentSession.createQuery("FROM TestTable WHERE idx=:idx",TestTable.class);
		theQuery.setParameter("idx", idx);
		return theQuery.getSingleResult();
	}

	@Override
	public long getLastInsertId() {
		Session currentSession = sessionFactory.getCurrentSession();
		long idx = ((BigInteger) currentSession.createNativeQuery("SELECT LAST_INSERT_ID()").uniqueResult()).longValue();
		return idx;
	}
}
