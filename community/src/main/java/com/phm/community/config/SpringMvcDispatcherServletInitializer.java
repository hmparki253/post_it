package com.phm.community.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	// -> web.xml의 servlet 부분을 담당하는 메서드
	// ex) servlet-name, servlet-class, init-param, load-on-startup...
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	// -> web.xml의 servlet-mapping 부분을 담당하는 메서드
	// ex) servlet-name, url-pattern 
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
