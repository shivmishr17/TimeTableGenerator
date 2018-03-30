package com.ttg.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.ttg.util.DBConnection;

public class LoginDAO {

	protected boolean checkUserCredentials(LoginBean bean) throws Exception {
		Connection con = DBConnection.getDBConnection();

		boolean isCorrect = false;
		String givenPwd = bean.getPwd();

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT pwd FROM register WHERE username = '" + bean.getUsername() + "'");
		while (rs.next()) {
			String pwd = rs.getString(1);
			if (givenPwd.equals(pwd)) {
				isCorrect = true;
				break;
			}
			isCorrect = false;
		}
		return isCorrect;
	}

	protected boolean checkAdminCredentials(LoginBean bean) throws Exception {
		Connection con = DBConnection.getDBConnection();

		boolean isCorrect = false;
		String givenPwd = bean.getPwd();

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT pwd FROM register WHERE username = '" + bean.getUsername() + "'");
		while (rs.next()) {
			String pwd = rs.getString(1);

			if (givenPwd.equals(pwd)) {
				isCorrect = true;
				break;
			}
		}
		return isCorrect;
	}
}
