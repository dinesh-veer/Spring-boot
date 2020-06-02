package com.springBoot.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

@Component
public class RequestFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		System.out.println("In init method of RequestFilter");
		Filter.super.init(filterConfig);
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println(request.getLocalAddr());
		System.out.println(request.getServerPort());
		System.out.println("In doFilter method of RequestFilter");
		
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
		System.out.println("In destroy method of RequestFilter");
		Filter.super.destroy();
	}
	

}
