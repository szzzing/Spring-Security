package com.sz.reminiscene.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sz.reminiscene.dto.Member;
import com.sz.reminiscene.exception.ReminiException;
import com.sz.reminiscene.service.MainService;

/*
 * 메인페이지 컨트롤러
 */

@Controller
public class MainController {
	
	@Autowired
	private MainService mService;
	
	@RequestMapping("/")
	public String main() {
		return "common/main";
	}
	
	@RequestMapping("/login")
	public String login(Authentication auth) {
		if(auth==null) {
			return "common/login";
		} else {
			throw new ReminiException("비정상적인 접근입니다.");
		}
	}
	
	@RequestMapping("/join")
	public String join(Authentication auth) {
		if(auth==null) {
			return "common/join";
		} else {
			throw new ReminiException("비정상적인 접근입니다.");
		}
	}
	
	@RequestMapping("/join.do")
	public String insertMember(@ModelAttribute Member m, HttpServletRequest request) {
		System.out.println(request.getCharacterEncoding());
		System.out.println(m.getNickname());
		int result = mService.insertMember(m);
		if(result>0) {
			return "redirect:/";
		} else {
			throw new ReminiException("회원가입에 실패했습니다.");
		}
	}
}
