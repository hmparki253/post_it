package com.phm.community.dao;

import java.util.List;

import com.phm.community.entity.Authority;

public interface AuthorityDAO {
	public void saveAuthority(Authority authority);
	public void saveAuthorities(List<Authority> authorities);
}
