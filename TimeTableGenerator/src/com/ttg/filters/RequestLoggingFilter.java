package com.ttg.filters;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class RequestLoggingFilter
 */
@WebFilter("/RequestLoggingFilter")
public class RequestLoggingFilter implements Filter {

	private ServletContext context;

	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("Request Logging Filter Inititialized");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		this.context.log("Was doing request logging filter");
		chain.doFilter(request, response);
	}

	public void destroy() {
		this.context.log("Request Logging Filter Destroyed");
	}

}
