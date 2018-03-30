package com.ttg.filters;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

	private ServletContext context;

	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("Authentication Filter Inititialized");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		res.setHeader("Pragma", "no-cache");
		res.setDateHeader("Expires", 0);

		String uri = req.getRequestURI();
		System.err.println("Requested URI: " + uri);

		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		System.err.println("Username: " + username);

		// Never send a user to index page without logout
		if (username != null && uri.endsWith("index.jsp")) {
			res.sendRedirect("user.jsp");
		}

		if ((username == null || username.equals(null))
				&& !(uri.endsWith("login") || uri.endsWith("logout")|| uri.endsWith("user2.jsp") || uri.endsWith("html") || uri.endsWith("css")
						|| uri.endsWith("ttf") || uri.endsWith("woff") || uri.endsWith("webm") || uri.endsWith("ogg")
						|| uri.endsWith("mp4") || uri.endsWith("mp3") || uri.endsWith("js") || uri.endsWith("jpg")
						|| uri.endsWith("gif") || uri.endsWith("png") || uri.endsWith("index.jsp"))) {
			System.err.println("Unauthorised Access Request. Redirecting to main page.");
			res.sendRedirect("index.jsp");
		} else {
			chain.doFilter(request, response);
		}

	}

	public void destroy() {
		this.context.log("Authentication Filter Destroyed");
	}

}
