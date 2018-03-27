package com.phm.community.test.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.phm.community.entity.Authority;
import com.phm.community.entity.Board;
import com.phm.community.entity.User;

public class HIbernateTest {

	public static void main(String[] args) {

		// 세션 팩토리 생성
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(Authority.class)
				.buildSessionFactory();

		//  세션 생성
		Session session = factory.getCurrentSession();

		try {
			// User 오브젝트 생성 
			session.beginTransaction();


			User user = new User("hodongsang", "qhfk00", "호우", "cristiano@gmail.com", 1);
			
			Authority authority = new Authority("ROLE_USER");
			Authority authority2 = new Authority("ROLE_ADMIN");
			
			user.add(authority);
			user.add(authority2);
			session.save(user);
			session.save(authority);
			session.save(authority2);
//			Board tempBoard = session.get(Board.class, idx);
//
//			System.out.println("찾았다 board Object 1번 : " + tempBoard);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("성공!!");

		} catch (Exception exc) {
			exc.printStackTrace();
			System.out.println("실패다 ㅡㅡ ");
		} finally {
			factory.close();
		}

	}

}
