package com.sz.reminiscene.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sz.reminiscene.dto.Member;

@Repository
public class MainDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int insertMember(Member m) {
		return sqlSession.insert("memberMapper.insertMember", m);
	}
}
