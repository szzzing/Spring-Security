package com.sz.reminiscene.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sz.reminiscene.security.CustomAuthenticationProvider;
import com.sz.reminiscene.security.handler.LoginFailureHandler;
import com.sz.reminiscene.security.handler.LoginSuccessHandler;

@ComponentScan("com.sz.reminiscene.security")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	CustomAuthenticationProvider customAuthenticationProvider;
	
	@Autowired
	BasicDataSource dataSource;
	
	@Autowired
	LoginSuccessHandler loginSuccessHandler;
	
	@Autowired
	LoginFailureHandler loginFailureHandler;
	
	// Encoder bean 등록
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// AuthenticationProvider 등록
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.authenticationProvider(customAuthenticationProvider);
//			.jdbcAuthentication()
//			.passwordEncoder(passwordEncoder())
//			.dataSource(dataSource)
//			.usersByUsernameQuery("select id, pw, enabled from Member where id=?")
//			.authoritiesByUsernameQuery("select id, authority from Member where id=?");
	}
	
	// http 요청에 대한 설정
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		// 권한 설정
			.antMatchers("/").authenticated()
			.antMatchers("/login").permitAll()
			.antMatchers("/admin**").hasRole("A")
			.and()
		// 로그인폼 설정
		.formLogin()
			.loginProcessingUrl("/login")
			.loginPage("/login")
			.usernameParameter("id")
			.passwordParameter("pw")
			.failureHandler(loginFailureHandler)
			.successHandler(loginSuccessHandler)
			.and()
		// 로그아웃 설정
		.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/")
			.and()
		.headers();	// 브라우저의 페이지 캐싱 방지
		
	}

}
