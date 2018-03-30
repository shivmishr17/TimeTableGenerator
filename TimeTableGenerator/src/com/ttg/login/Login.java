package com.ttg.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");

		LoginBean bean = new LoginBean(username, pwd);
		LoginDAO dao = new LoginDAO();

		String msg = null;
		HttpSession session = null;

		try {
			if (username.equals("admin")) {
				boolean isCorrect = dao.checkAdminCredentials(bean);
				if (isCorrect) {
					msg = "Go";
					session = request.getSession();
					session.setMaxInactiveInterval(30 * 60);
					session.setAttribute("username", username);
				} else {
					msg = "Enter valid credentials";
				}
			} else if (username.equals("user")) {
				boolean isCorrect = dao.checkUserCredentials(bean);
				if (isCorrect) {
					msg = "Go";
					session = request.getSession();
					session.setMaxInactiveInterval(30 * 60);
					session.setAttribute("username", username);
				} else {
					msg = "Enter valid credentials";
				}
			} else {
				msg = "Invalid username";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().write(msg);
	}

}
