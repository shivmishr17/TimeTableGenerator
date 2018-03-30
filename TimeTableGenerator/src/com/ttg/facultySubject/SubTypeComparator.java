package com.ttg.facultySubject;

import java.util.Comparator;

public class SubTypeComparator implements Comparator<FacultyRelations> {

	@Override
	public int compare(FacultyRelations relation1, FacultyRelations relation2) {
		return relation1.getSubjectType().compareTo(relation2.getSubjectType());
	}

}
