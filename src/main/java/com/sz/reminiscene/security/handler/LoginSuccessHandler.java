package com.sz.reminiscene.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.sz.reminiscene.security.CustomUserDetails;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		CustomUserDetails user = (CustomUserDetails)authentication.getPrincipal();
		
		if(user.getAuthority().equals("A")) {
			response.sendRedirect(request.getContextPath()+"/admin");
		} else {
			response.sendRedirect(request.getContextPath()+"/");
		}
	}
}