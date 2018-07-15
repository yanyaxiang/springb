package com.yyx.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
@Component
@ServletComponentScan
@WebFilter(urlPatterns = {"*.do", "/"},filterName = "loginFilter")
public class LoginFilter implements Filter {
	private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList("/login.do", "/toLogin.do")));

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest= (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		
		String um = (String)httpRequest.getSession().getAttribute("um");
		String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length()).replaceAll("[/]+$", "");
		boolean allowedPath = ALLOWED_PATHS.contains(path);
		if(allowedPath) { //login或toLogin 放过
			System.out.println("login or toLogin");
			chain.doFilter(request, response);
		} else if(StringUtils.isEmpty(um)) { //未登录
			httpResponse.sendRedirect("/toLogin.do");
//			out.println("<script>");
//			out.println("window.location.href = '/toLogin\'");
//			out.println("</script>");
//			out.flush();
//			out.close();
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		
	}

}
