package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import filter.AuthServletFilter;

@Configuration
public class FilterBeans {
	
	public static final String AUTH_SERVLET_FILTER = "AuthServletFilter"; 
	
	@Bean(name=AUTH_SERVLET_FILTER)
	public AuthServletFilter getAuthServletFilter() {
		return new AuthServletFilter();
	}
	
	
}
