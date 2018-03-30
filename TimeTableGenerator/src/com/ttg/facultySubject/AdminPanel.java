package com.ttg.facultySubject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.ttg.util.DBConnection;

public class AdminPanel {

	Connection con = DBConnection.getDBConnection();

	public void addBatch(String bName, int bSec) throws Exception {
		PreparedStatement pst = con.prepareStatement("insert into batches values('" + bName + "' , '" + bSec + "')");
		pst.executeUpdate();
	}

	public void addFaculty(String fCode, String fName, String dept) throws Exception {
		PreparedStatement pst = con
				.prepareStatement("insert into faculty values('" + fCode + "' , '" + fName + "' , '" + dept + "' )");
		pst.executeUpdate();
	}

	public void addLab(String lName, int lNo) throws Exception {
		PreparedStatement pst = con.prepareStatement("insert into lab values('" + lNo + "' , '" + lName + "')");
		pst.executeUpdate();
	}

	public void addLabSubject(String lNo, int Sub_code) throws Exception {
		PreparedStatement pst = con
				.prepareStatement("insert into lab_subjects values('" + lNo + "' , '" + Sub_code + "')");
		pst.executeUpdate();
	}

	public void delBatch(String bName, int bSec) throws Exception {
		PreparedStatement pst = con
				.prepareStatement("DELETE FROM batches WHERE Batch_name = '" + bName + "' AND section =" + bSec + " ");
		pst.executeUpdate();
	}

	public void delFaculty(String fCode, String fName, String dept) throws Exception {
		PreparedStatement pst = con.prepareStatement("delete from faculty where fac_code = '" + fCode + "'");
		pst.executeUpdate();
	}

	public void delLab(String lName, int lNo) throws Exception {
		PreparedStatement pst = con.prepareStatement("delete from lab where lab_no = '" + lNo + "'");
		pst.executeUpdate();
	}

	public void delLabSubject(String lNo, int Sub_code) throws Exception {
		PreparedStatement pst = con.prepareStatement("delete from lab_subjects where Sub_code = '" + Sub_code + "'");
		pst.executeUpdate();
	}

	public void updFaculty(String fCode, String fName, String dept) throws Exception {
		PreparedStatement pst = con.prepareStatement(
				"UPDATE `ttgenerator`.`faculty` SET `fac_name`='" + fName + "' WHERE `fac_code`='" + fCode + "'");
		pst.executeUpdate();
	}
}
