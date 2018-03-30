package com.ttg.facultySubject;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import com.ttg.util.DBConnection;

public class RelationDAO {

	// containers to import data from DB
	ArrayList<Batch> batchList = new ArrayList<Batch>();
	ArrayList<Lab> labList = new ArrayList<Lab>();
	ArrayList<Faculty> facList = new ArrayList<Faculty>();
	ArrayList<FacultyRelations> tmp = new ArrayList<FacultyRelations>();
	Iterator<FacultyRelations> itr;

	Batch batch = new Batch();
	Faculty fac = new Faculty();

	FacultyRelations relationList = new FacultyRelations();
	Lab lab = null;
	String cmp;
	int day, timeSlot;

	ResourceBundle bundle = ResourceBundle.getBundle("com.ttg.rb.connection");
	// To DO: // Find a way either removing the inputs or using counter for each
	// subject so that they can be filled more than once in a TT.

	public String createTT(ArrayList<FacultyRelations> relations) throws Exception {
		Connection con = DBConnection.getDBConnection();

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT CONCAT(Batch_name, section) AS BName FROM batches;");
		while (rs.next()) {
			Batch batch = new Batch();
			batch.setBatch_Name(rs.getString(1));
			batchList.add(batch);
		}

		// add counter to the relationList for no. of classes

		relations = counterAdd(relations);

		rs = stmt.executeQuery(
				"SELECT lab.lab_no ,lab_name, sub_code FROM lab, lab_subjects WHERE lab.`Lab_no` = lab_subjects.`Lab_No`;");
		while (rs.next()) {
			Lab lab = new Lab();
			lab.setLab_No(rs.getInt(1));
			lab.setLab_Name(rs.getString(2));
			lab.setSubCode(rs.getString(3));
			labList.add(lab);

		}
		rs = stmt.executeQuery("SELECT fac_code FROM faculty;");
		while (rs.next()) {
			Faculty fac = new Faculty();
			fac.setFacultyCode(rs.getString(1));
			facList.add(fac);
		}

		boolean isDone = false;

		try {
			do {
				itr = relations.iterator();
				while (itr.hasNext()) {
					relationList = itr.next();
					System.out.println("JSJ");

					// for Lab
					System.out.println(relationList.getSubjectType());
					String compare = relationList.getSubjectType();
					if (!compare.equals("Theory")) {
						for (day = 0; day < 5; day++) // monday to friday
						{
							String sc = relationList.getSubjectCode();
							System.out.println(sc + "   " + day);
							boolean ls = Lab_Slot(sc);
							if (!ls) {
								System.out.println("Error in allocation of lab");
							} else {
								String day = "none";
								if (this.day == 0) {
									day = "Mon";
								} else if (this.day == 1) {
									day = "Tue";
								} else if (this.day == 2) {
									day = "Wed";
								} else if (this.day == 3) {
									day = "Thu";
								} else if (this.day == 4) {
									day = "Fri";
								}

								PreparedStatement st = con.prepareStatement("call " + day + "_IP(?,?,?,?,?);");

								st.setString(1, relationList.getClassName().substring(0, 1));
								int x = Integer.parseInt(relationList.getClassName().substring(1, 2));
								st.setInt(2, x);
								st.setString(3, relationList.getFacultyCode());
								st.setString(4, relationList.getSubjectCode());

								int labTimeSlot = timeSlot;
								if (timeSlot == 0)
									labTimeSlot = 7;
								if (timeSlot == 2)
									labTimeSlot = 8;
								if (timeSlot == 4)
									labTimeSlot = 9;
								st.setInt(5, labTimeSlot);
								st.executeQuery();
								st.close();
								break;
							}
						}
					} else {
						// For theory
						for (day = 0; day < 5; day++) // monday to friday
						{
							if (relationList.getSubjectType() == "Practical") {
								break;
							}
							String sc = relationList.getSubjectCode(); // current
																		// subject
							boolean ts = Theory_Slot(sc);
							if (!ts)
								System.out.println("Failure");
							else {
								String day = "none";
								if (this.day == 0) {
									day = "Mon";
								} else if (this.day == 1) {
									day = "Tue";
								} else if (this.day == 2) {
									day = "Wed";
								} else if (this.day == 3) {
									day = "Thu";
								} else if (this.day == 4) {
									day = "Fri";
								}

								PreparedStatement st = con.prepareStatement("call " + day + "_IP(?,?,?,?,?);");

								st.setString(1, batch.getBatch_Name().substring(0, 1));
								String t = batch.getBatch_Name().substring(1, 2);
								System.out.println(t);

								int x = Integer.parseInt(batch.getBatch_Name().substring(1, 2));
								st.setInt(2, x);
								st.setString(3, relationList.getFacultyCode());
								st.setString(4, relationList.getSubjectCode());
								st.setInt(5, timeSlot + 1);
								st.executeQuery();
								st.close();
								break;
							}
						}

					}

				}

				itr = relations.iterator();
			} while (itr.hasNext());
			isDone = true;
		} catch (Exception e) {
			e.printStackTrace();
			con.close();
			isDone = false;
		}

		con.close();
		if (isDone == false)
			return "Some error occurred!!";
		else
			return "Time Table Created Successfully.";

	}

	private ArrayList<FacultyRelations> counterAdd(ArrayList<FacultyRelations> relations) throws Exception {

		Iterator<FacultyRelations> relItr = relations.iterator();
		FacultyRelations temp;
		while (relItr.hasNext()) {
			temp = relItr.next();
			Class.forName(bundle.getString("Driver"));
			Connection con = DriverManager.getConnection(bundle.getString("URL"), bundle.getString("User"),
					bundle.getString("pwd"));
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT classes from sub_type where sub_code = '" + temp.getSubjectCode()
					+ "' and type = '" + temp.getSubjectType() + "';");
			while (rs.next()) {
				temp.setCounter(rs.getInt(1));
			}
			relItr.remove();
			tmp.add(temp);
			System.out.println(temp.getClassName());
		}
		return tmp;

	}

	private boolean Lab_Slot(String sc) throws Exception {
		Connection con = DBConnection.getDBConnection();

		timeSlot = 0;
		boolean flag = false;
		try {

			boolean[][] tb = batch.getTime_Slot();
			boolean[][] tf = fac.getTime_Slot();
			// find l acc to sub code
			boolean start = false; // for fail in lab alloc

			Iterator<Lab> labItr = labList.iterator();
			while (labItr.hasNext()) {
				Lab temp = labItr.next();
				System.out.println(temp.getLab_No());
				if (sc.equals(temp.getSubCode())) {
					lab = temp;
					System.out.println("Assign ho gyi " + lab.getLab_No());
					labItr.remove();
					start = true;
					break;
				}
			}

			if (start) {
				Iterator<Batch> batchItr = batchList.iterator();
				while (batchItr.hasNext()) {
					Batch temp = batchItr.next();
					String compare = relationList.getClassName();
					cmp = temp.getBatch_Name();
					if (compare.equals(cmp)) {
						batch = temp;
						System.out.println(batch.getBatch_Name() + " batch copy hua");
						batchItr.remove();
						break;
					}
				}

				Iterator<Faculty> facItr = facList.iterator();
				while (facItr.hasNext()) {
					String compare = relationList.getFacultyCode();
					Faculty tmp = facItr.next();
					cmp = tmp.getFacultyCode();
					if (compare.equals(cmp)) {
						fac = tmp;
						facItr.remove();
						break;
					}
				}
				do {
					boolean[][] tl = lab.getTime_Slot();
					boolean choice = true;
					System.out.println(relationList.getCounter());
					if (relationList.getCounter() <= 1) {
						choice = false;
					}
					if (choice) {
						int[] checkLab = batch.getLabAssigned();
						if (lab.getLab_No() == checkLab[day]) { // make tl for
																// particular
							// batch
							timeSlot = 7;
							break;
						}
						if (timeSlot == 7)
							break;
						if (tb[day][6] == true) {
							break;
						}

						System.out.println(day + "<<>>" + timeSlot);
						if (tb[day][timeSlot] == false && tf[day][timeSlot] == false && tl[day][timeSlot] == false) {
							tb[day][timeSlot] = true;
							tf[day][timeSlot] = true;
							tl[day][timeSlot] = true;

							tb[day][timeSlot + 1] = true;
							tf[day][timeSlot + 1] = true;
							tl[day][timeSlot + 1] = true;
							checkLab[day] = lab.getLab_No();
							batch.setLabAssigned(checkLab);
							tb[day][6] = true;
							batch.setTime_Slot(tb);
							batch.setLabTimeAssigned(timeSlot);
							fac.setTime_Slot(tf);
							lab.setTime_Slot(tl);
							relationList.setCounter(relationList.getCounter() - 1);

							flag = true;
							timeSlot = 7;
						} else
							timeSlot += 2;
					} else {
						Iterator<Faculty> fac2Itr = facList.iterator();
						while (fac2Itr.hasNext()) {
							String compare = relationList.getLab2Fac();
							Faculty tmp = fac2Itr.next();
							cmp = tmp.getFacultyCode();
							if (compare.equals(cmp)) {
								fac = tmp;
								fac2Itr.remove();
								break;
							}
						}
						boolean[][] tf2 = fac.getTime_Slot();
						System.out.println("This is it");
						if (tb[day][6] != true) {
							System.out.println("break ho gya");
							break;
						}
						int[] checkLab = batch.getLabAssigned();
						if (lab.getLab_No() == checkLab[day]) {
							timeSlot = 7;
							break;
						}

						

						timeSlot = batch.getLabTimeAssigned();
						
						if(tf2[day][timeSlot]||tf2[day][timeSlot+1])
						{
							timeSlot = 7;
							break;
						}
						if (timeSlot == 7) {
							System.out.println("Time slot se break ho gya");
							break;
						}
						tb[day][timeSlot] = true;
						tf2[day][timeSlot] = true;
						tl[day][timeSlot] = true;

						tb[day][timeSlot + 1] = true;
						tf2[day][timeSlot + 1] = true;
						tl[day][timeSlot + 1] = true;

						tb[day][6] = true;

						batch.setLabTimeAssigned(timeSlot);
						fac.setTime_Slot(tf2);
						lab.setTime_Slot(tl);
						relationList.setCounter(relationList.getCounter() - 1);

						flag = true;
						timeSlot = 7;
						itr.remove();
						break;

					}
				} while (timeSlot < 6);
				facList.add(fac);
				batchList.add(batch);

			}
			labList.add(lab);

		} catch (Exception e) {
			e.printStackTrace();
		}

		con.close();
		return flag;
	}

	private boolean Theory_Slot(String sc) throws Exception {
		boolean flag = false;
		timeSlot = 0;
		do {

			boolean[][] tb;
			boolean[][] tf;
			try {
				Iterator<Batch> batchItr = batchList.iterator();
				Iterator<Faculty> facItr = facList.iterator();
				while (batchItr.hasNext()) {
					Batch temp = batchItr.next();
					String compare = relationList.getClassName();
					cmp = temp.getBatch_Name();
					System.out.println(cmp + "    " + compare);
					if (compare.equals(cmp)) {
						batch = temp;
						batchItr.remove();
						break;
					}
				}
				while (facItr.hasNext()) {
					String compare = relationList.getFacultyCode();
					Faculty tmp = facItr.next();
					cmp = tmp.getFacultyCode();
					System.out.println(cmp + "    " + compare);
					if (compare.equals(cmp)) {
						fac = tmp;
						facItr.remove();
						break;
					}
				}
				tb = batch.getTime_Slot();
				tf = fac.getTime_Slot();

				if (tb[day][timeSlot] == false && tf[day][timeSlot] == false) {
					tb[day][timeSlot] = true;
					tf[day][timeSlot] = true;
					batch.setTime_Slot(tb);
					fac.setTime_Slot(tf);
					facList.add(fac);
					batchList.add(batch);

					if (relationList.getCounter() == 1) {
						itr.remove();
					} else {
						relationList.setCounter(relationList.getCounter() - 1);
					}

					flag = true;
					break;
				} else
					timeSlot++;
			} catch (Exception e) {
				System.err.print("HI ");
				e.printStackTrace();
			}
		} while (timeSlot < 6);
		return flag;

	}

}