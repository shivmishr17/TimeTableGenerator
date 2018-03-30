package com.ttg.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class GetInfo
 */
@WebServlet("/info")
public class GetInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json");
		String what = request.getParameter("what");
		Info info = new Info();
		
		if (what.equals("classList")) {
			try {
				ArrayList<String> classSectionList = info.getClassAndSectionList();
				String listToJson = new Gson().toJson(classSectionList);
				response.getWriter().write(listToJson);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(what.equals("facultyList")) {
			try {
				HashMap<String, String> facultyList = info.getFacultyList();
				String listToJson = new Gson().toJson(facultyList);
				response.getWriter().write(listToJson);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(what.equals("subjectsList")) {
			try {
				int sem = Integer.parseInt(request.getParameter("sem"));
				HashMap<String, String> subjectsList = info.getSubjectsList(sem);
				String listToJson = new Gson().toJson(subjectsList);
				response.getWriter().write(listToJson);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
