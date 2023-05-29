package com.sz.reminiscene.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sz.reminiscene.repository.MainDAO;

@Service("mService")
public class MainServiceImpl implements MainService {
	
	@Autowired
	private MainDAO mDAO;
}
