package com.phm.community.test.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.phm.community.entity.Board;

public class HIbernateTest {

	public static void main(String[] args) {

		// 세션 팩토리 생성
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Board.class)
				.buildSessionFactory();

		//  세션 생성
		Session session = factory.getCurrentSession();

		try {
			// create the objects
			session.beginTransaction();

			int idx = 1;

			Board tempBoard = session.get(Board.class, idx);

			System.out.println("찾았다 board Object 1번 : " + tempBoard);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("성공!!");

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
