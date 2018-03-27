package com.phm.community.service;

import java.util.List;

import com.phm.community.entity.Authority;
import com.phm.community.entity.User;

public interface UserService {
	public void saveUser(User user);
	public void saveUserAndAuthorities(User user, List<Authority> authorities);
	public User getUser(String username);
	public boolean checkId(String username);
	public boolean checkEmail(String email);
}
