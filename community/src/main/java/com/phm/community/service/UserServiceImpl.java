package com.phm.community.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phm.community.dao.AuthorityDAO;
import com.phm.community.dao.UserDAO;
import com.phm.community.entity.Authority;
import com.phm.community.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private AuthorityDAO authorityDAO;
	
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userDAO.saveUser(user);
	}

	@Transactional
	@Override
	public User getUser(String username) {
		return userDAO.getUser(username);
	}

	@Transactional
	@Override
	public boolean checkId(String username) {
		// 해당하는 id값으로 객체를 찾을 수 없다면
		if(getUser(username) == null) { // false를 
			return false;
		} else { // 찾을 수 있다면
			return true;	 // true
		}
	}

	@Transactional
	@Override
	public void saveUserAndAuthorities(User user, List<Authority> authorities) {
		for(Authority tempAuth : authorities) {
			user.add(tempAuth);
		}
		userDAO.saveUser(user);
		authorityDAO.saveAuthorities(authorities);
	}

	@Transactional
	@Override
	public boolean checkEmail(String email) {
		// 해당하는 email값으로 object를 찾을 수 없다면 
		if(userDAO.getUserByEmail(email) == null) {
			return false;
		} else { // 찾을 수 있다면 
			return true; // true
		}
	}

}
