package com.sz.reminiscene.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import com.sz.reminiscene.config.SecurityConfig;

// web.xml에 등록하지 않고 시큐리티 필터 사용 가능
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

}
