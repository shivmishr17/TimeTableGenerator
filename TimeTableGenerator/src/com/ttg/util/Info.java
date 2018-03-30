package com.ttg.util;

import java.sql.*;
import java.util.*;

public class Info {

	public ArrayList<String> getClassAndSectionList() throws Exception {
		Connection con = DBConnection.getDBConnection();

		ArrayList<String> classSectionList = new ArrayList<String>();
		Statement stmt = con.createStatement();
		ResultSet rset = stmt.executeQuery("SELECT CONCAT(Batch_name, section) FROM batches");
		while (rset.next()) {
			String className = rset.getString(1);
			classSectionList.add(className);
		}
		con.close();
		return classSectionList;
	}

	public HashMap<String, String> getFacultyList() throws Exception {
		Connection con = DBConnection.getDBConnection();

		HashMap<String, String> facultyList = new HashMap<String, String>();
		Statement stmt = con.createStatement();
		ResultSet rset = stmt.executeQuery("SELECT fac_code, fac_name FROM faculty");
		while (rset.next()) {
			String facultyCode = rset.getString(1);
			String facultyName = rset.getString(2);
			facultyList.put(facultyCode, facultyName);
		}
		con.close();
		return facultyList;
	}

	public HashMap<String, String> getSubjectsList(int semester) throws Exception {
		Connection con = DBConnection.getDBConnection();

		HashMap<String, String> subjectsList = new HashMap<String, String>();
		Statement stmt = con.createStatement();
		ResultSet rset = stmt.executeQuery("SELECT sub_code, sub_name FROM subjects WHERE semester = "+semester);
		while (rset.next()) {
			String subCode = rset.getString(1);
			String subName = rset.getString(2);
			subjectsList.put(subCode, subName);
		}
		con.close();
		return subjectsList;
	}
}
