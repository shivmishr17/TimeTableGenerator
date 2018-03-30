package com.ttg.util;

import java.sql.*;
import java.util.ResourceBundle;

public final class DBConnection {

	public static Connection getDBConnection() {
		Connection con = null;
		try {
			ResourceBundle bundle = ResourceBundle.getBundle("com.ttg.rb.connection");
			Class.forName(bundle.getString("Driver"));
			con = DriverManager.getConnection(bundle.getString("URL"), bundle.getString("User"),
					bundle.getString("pwd"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
