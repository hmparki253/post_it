package com.phm.community.dao;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phm.community.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(user);
	}

	@Override
	public User getUser(String username) {
		Session currentSession = sessionFactory.getCurrentSession();
		User user = currentSession.get(User.class, username);
		return user;
	}

	@Override
	public User getUserByEmail(String email) {
		User user = null;
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> theQuery = currentSession.createQuery(
				"from User where " + "email=:email", 
				User.class);
		theQuery.setParameter("email", email);
		
		try {
			user = theQuery.getSingleResult();
		} catch(NoResultException nre) {
			user = null;
		}
		return user;
	}

}
