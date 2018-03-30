package com.ttg.facultySubject;

import java.io.IOException;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/facultySubjects")
public class FacultySubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<FacultyRelations> relationList = new ArrayList<FacultyRelations>();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		int length = Integer.parseInt(request.getParameter("i"));
		for (int i = 0; i <= length; i++) {
			FacultyRelations relations = new FacultyRelations(request.getParameter("faculty" + i),
					request.getParameter("subject" + i), request.getParameter("subType" + i),
					request.getParameter("class" + i), request.getParameter("fac2" + i));
			relationList.add(relations);
		}

		Collections.sort(relationList, new SubTypeComparator());
		Iterator<FacultyRelations> it = relationList.iterator();
		while (it.hasNext()) {
			FacultyRelations fr = it.next();
			System.out.println(fr.getSubjectType() + ">>" + fr.getClassName());
		}
		RelationDAO rd = new RelationDAO();
		String responseMsg = null;
		try {
			responseMsg = rd.createTT(relationList);
			response.getWriter().write(responseMsg);
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("Severe Exception Occured!");
		}
	}
}
