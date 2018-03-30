<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="shortcut icon" href="logo.png">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet">

<link href="css/sweetalert.css" rel="stylesheet">

<!-- jQuery library -->
<script src="js/jquery-1.11.3.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="js/bootstrap.min.js"></script>

<!-- css file for this -->
<link rel="stylesheet" href="css/user.css">

<!-- js file for this -->
<script src="js/user.js"></script>
<title>Welcome</title>
</head>
<body>
	<!-- Select container starts -->
	<div class="select-container container-fluid" style="height: 100%;">
		<div class="row" style="margin-top: 10%;">
			<div class="col-sm-1"></div>
			<div class="col-sm-4">
				<div class="select" id="createTT">
					<h2 class="heads" align="center">Create Timetable</h2>
				</div>
			</div>
			<div class="col-sm-2"></div>
			<div class="col-sm-4">
				<div class="select" id="viewTT">
					<h2 class="heads" align="center">View Timetable</h2>
				</div>
			</div>
			<div class="col-sm-1"></div>
		</div>
		<div class="row" style="text-align: center">
			<form action="logout" method="post">
				<input style="border-radius: 0; height: 100%; width: 10em"
					type="submit" class="btn btn-info" value="Logout">
			</form>
		</div>
	</div>
	<!-- Select container ends -->

	<!-- Create timetable container starts -->
	<form id="facultySubjectsForm" action="facultySubjects" method="post">
		<div class="container" id="mainTT">
			<div id="menu"></div>
			<h1 align="center">Enter the following details</h1>
			<hr>
			<br> <br>
			<div class="row" style="text-align: center; height: 2.6em">
				<select id="semester" style="height: 100%; width: 30%">
					<option disabled="disabled" selected="selected">--Select
						Semester</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
				</select>
			</div>
			<br> <br>
			<div class="row" style="background: #2d2d2d">
				<div class="col-sm-2">
					<label class="lblTableHead">Faculty Name</label>
				</div>
				<div class="col-sm-3">
					<label class="lblTableHead">Subject Code</label>
				</div>
				<div class="col-sm-2">
					<label class="lblTableHead">Subject Type</label>
				</div>
				<div class="col-sm-3">
					<label class="lblTableHead">Class Name</label>
				</div>
				<div class="col-sm-2">
					<label class="lblTableHead">Practical Faculty</label>
				</div>
			</div>
			<div class="container" id="selectEntries">
				<div class="row" id="prototype-row">
					<div class="col-sm-2 field-container">
						<select name="faculty0" class="faculties">
						</select>
					</div>
					<div class="col-sm-3 field-container">
						<select name="subject0" class="subjects">
						</select>
					</div>
					<div class="col-sm-2 field-container">
						<select name="subType0" class="subType">
							<option value="Theory">Theory</option>
							<option value="Practical">Practical</option>
						</select>
					</div>
					<div class="col-sm-3 field-container">
						<select name="class0" class="classes">
						</select>
					</div>
					<div class="col-sm-2 field-container">
						<select disabled="disabled" style="background: rgb(210, 210, 210)" name="fac20" class="fac2">
						</select>
					</div>
				</div>
			</div>

			<br> <br>
			<div class="row">
				<div class="col-sm-4">
					<input style="border-radius: 0; height: 100%" type="submit"
						value="Create Time Table" id="submit"
						class="btn btn-danger form-control">
				</div>
				<div class="col-sm-4">
					<input style="border-radius: 0; height: 100%" id="deleteBtn"
						type="button" class="btn btn-danger form-control"
						value="Delete Row">
				</div>
				<div class="col-sm-4">
					<input style="border-radius: 0; height: 100%" id="addBtn"
						type="button" class="btn btn-danger form-control" value="Add Row">
				</div>
			</div>
		</div>
	</form>
	<!-- Create timetable container ends -->
</body>
</html>