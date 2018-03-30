package com.ttg.facultySubject;

import java.io.Serializable;

public class FacultyRelations implements Serializable {

	private static final long serialVersionUID = 1L;
	private String facultyCode;
	private String subjectCode;
	private String subjectType;
	private String className;
	private int counter;
	private String lab2Fac;
	private boolean[][] Time_Slot = new boolean[5][6];

	public FacultyRelations(String facultyCode, String subjectCode, String subjectType, String className,
			String lab2Fac) {
		this.facultyCode = facultyCode;
		this.subjectCode = subjectCode;
		this.subjectType = subjectType;
		this.className = className;
		this.lab2Fac = lab2Fac;
	}

	public FacultyRelations() {
	}

	public String getFacultyCode() {
		return facultyCode;
	}

	public void setFacultyCode(String facultyCode) {
		this.facultyCode = facultyCode;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public boolean[][] getTime_Slot() {
		return Time_Slot;
	}

	public void setTime_Slot(boolean[][] time_Slot) {
		Time_Slot = time_Slot;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public String getLab2Fac() {
		return lab2Fac;
	}

	public void setLab2Fac(String lab2Fac) {
		this.lab2Fac = lab2Fac;
	}

}
