package com.sz.reminiscene.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sz.reminiscene.dto.Member;
import com.sz.reminiscene.repository.MainDAO;

@Service("mService")
public class MainServiceImpl implements MainService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MainDAO mDAO;
	
	@Override
	public int insertMember(Member m) {
		System.out.println("service : "+m.getNickname());
		m.setPw(passwordEncoder.encode(m.getPw()));
		return mDAO.insertMember(m);
	}
}
