package com.phm.community.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phm.community.entity.Authority;

@Repository
public class AuthorityDAOImpl implements AuthorityDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveAuthority(Authority authority) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(authority);
	}

	@Override
	public void saveAuthorities(List<Authority> authorities) {
		for(Authority tempAuth : authorities) {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.saveOrUpdate(tempAuth);
		}
	}

}
