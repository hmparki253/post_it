package com.phm.community.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phm.community.entity.Board;
import com.phm.community.entity.Reply;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Board> getBoards() {
		// 하이버네이트 세션 객체 생성
		Session currentSession = sessionFactory.getCurrentSession();

		// 쿼리 생성
		Query<Board> theQuery = currentSession.createQuery("from Board order by idx desc", Board.class);
		// 쿼리 실행 및 결과값 얻어내기
		return theQuery.getResultList();
	}

	@Override
	public void saveBoard(Board board) {
		// 하이버네이트 세션 객체 생성
		Session currentSession = sessionFactory.getCurrentSession();
		// 세션에 board 객체 저장 및 업데이트
		currentSession.saveOrUpdate(board);
	}

	@Override
	public Board getBoard(int idx) {
		Session currentSession = sessionFactory.getCurrentSession();
		Board board = currentSession.get(Board.class, idx);
		return board;
	}

	@Override
	public void deleteBoard(int idx) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Board where " + "idx=:idx");
		theQuery.setParameter("idx", idx);
		theQuery.executeUpdate();
		// theQuery.executeUpdate는 int 값을 return 하는데 affected된 row 수를 리턴하게 된다.
		// 만약 문제가 있거나 (-1), affected된 row의 수가 0이라면 이는 문제가 될 수 있다는 증거이므로
		// 이 경우의 처리를 하는 구문이 반드시 있어야한다.
	}

	// reply 관련해서 replyDao 생성 후 옮기기 필요 ----------------------
	@Override
	public List<Reply> getRepliesByIdx(int idx) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from Reply where board_idx=:idx order by family, depth");
		theQuery.setParameter("idx", idx);
		return theQuery.getResultList();
	}

	@Override
	public void saveOrUpdateReply(Reply reply) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(reply);
	}

	@Override
	public long getLastInsertId() {
		Session currentSession = sessionFactory.getCurrentSession();
		long idx = ((BigInteger) currentSession.createNativeQuery("SELECT LAST_INSERT_ID()").uniqueResult()).longValue();
		return idx;
	}

	// pagination
	@Override
	public List<Board> getBoardByPagination(int curPage, int pageSize) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from Board order by idx desc", Board.class);
		theQuery.setFirstResult((curPage - 1) * pageSize);
		theQuery.setMaxResults(pageSize);
		return theQuery.getResultList();
	}

	@Override
	public long getBoardsCount() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("select count(board.idx) from Board board");
		return (long) theQuery.uniqueResult();
	}
}
