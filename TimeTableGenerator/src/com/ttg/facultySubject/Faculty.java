package com.ttg.facultySubject;

public class Faculty {

	private String facultyCode;
	private boolean[][] Time_Slot = new boolean[5][6];
	
	public String getFacultyCode() {
		return facultyCode;
	}
	public void setFacultyCode(String facultyCode) {
		this.facultyCode = facultyCode;
	}

	public boolean[][] getTime_Slot() {
		return Time_Slot;
	}
	public void setTime_Slot(boolean[][] time_Slot) {
		Time_Slot = time_Slot;
	}
	
	
}
