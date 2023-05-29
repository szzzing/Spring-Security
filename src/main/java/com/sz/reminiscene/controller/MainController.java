package com.sz.reminiscene.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sz.reminiscene.service.MainService;

@Controller
public class MainController {
	
	@Autowired
	private MainService mService;
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
}
