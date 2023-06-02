package com.sz.reminiscene.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.sz.reminiscene.servlet.AdminContext;
import com.sz.reminiscene.servlet.ServletContext;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class, SecurityConfig.class};
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletContext.class, AdminContext.class};
	}
	
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/", "/admin"};
	}
	
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return new Filter[] { characterEncodingFilter };
	}
}