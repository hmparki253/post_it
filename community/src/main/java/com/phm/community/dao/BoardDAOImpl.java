package com.phm.community.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phm.community.entity.Board;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Board> getBoards() {
		// 하이버네이트 세션 객체 생성 
		Session currentSession = sessionFactory.getCurrentSession();
		
		// 쿼리 생성
		Query<Board> theQuery = 
				currentSession.createQuery("from Board order by idx desc",
											Board.class);
		
		// 쿼리 실행 및 결과값 얻어내기 
		return theQuery.getResultList();
	}

	@Override
	public void saveBoard(Board board) {
		// TODO Auto-generated method stub

	}

	@Override
	public Board getBoard(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomer(int idx) {
		// TODO Auto-generated method stub

	}

}
