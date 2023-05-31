package com.sz.reminiscene.security;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("uDAO")
public class CustomUserDetailsDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public CustomUserDetails getUserById(String username) {
		CustomUserDetails user = sqlSession.selectOne("securityMapper.selectUserById", username);
		return user;
	}

}
