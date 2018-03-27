package com.phm.community.dao;

import com.phm.community.entity.User;

public interface UserDAO {
	public void saveUser(User user);
	public User getUser(String username);
	public User getUserByEmail(String email);
}
