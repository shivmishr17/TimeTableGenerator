package com.ttg.facultySubject;

import java.io.Serializable;

public class Batch implements Serializable {

	private static final long serialVersionUID = 1L;
	private String Batch_Name;
	private boolean[][] Time_Slot = new boolean[5][7];
	private int[] labAssigned = new int[5];
	private int labTimeAssigned;

	public String getBatch_Name() {
		return Batch_Name;
	}

	public void setBatch_Name(String batch_Name) {
		Batch_Name = batch_Name;
	}

	public boolean[][] getTime_Slot() {
		return Time_Slot;
	}

	public void setTime_Slot(boolean[][] time_Slot) {
		Time_Slot = time_Slot;
	}

	public int[] getLabAssigned() {
		return labAssigned;
	}

	public void setLabAssigned(int[] labAssigned) {
		this.labAssigned = labAssigned;
	}

	public int getLabTimeAssigned() {
		return labTimeAssigned;
	}

	public void setLabTimeAssigned(int labTimeAssigned) {
		this.labTimeAssigned = labTimeAssigned;
	}

}
