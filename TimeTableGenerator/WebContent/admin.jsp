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
<link rel="stylesheet" href="css/admin.css">

<!-- js file for this -->
<script src="js/admin.js"></script>

<title>Welcome Admin</title>
</head>
<body>
	<div id="side-menu" style="position: fixed">
		<div class="row" style="margin-top: 2em;">
			<div class="col-sm-1"></div>
			<div class="col-sm-3">
				<img alt="logo" src="logo.png" style="height: 3em;">
			</div>
			<div class="col-sm-5">
				<label
					style="text-align: center; color: #fff; font-size: 1.5em; padding-top: 3px;">TTG</label>
			</div>
			<div class="col-sm-1"></div>
		</div>
		<hr>
		<div class="row lblParents" id="classHover">
			<label class="side-lbls">Manage Classes</label>
		</div>
		<div class="row lblParents" id="facultyHover">
			<label class="side-lbls">Manage Faculties</label>
		</div>
		<div class="row lblParents" id="subjectHover">
			<label class="side-lbls">Manage Subjects</label>
		</div>
		<div class="row lblParents" id="roomHover">
			<label class="side-lbls">Manage Labs And Rooms</label>
		</div>
		<br> <br> <br> <br>
		<div class="row" style="text-align: center">
			<form action="logout" method="post">
				<input style="border-radius: 0; height: 100%; width: 10em"
					type="submit" class="btn btn-info" value="Logout">
			</form>
		</div>
	</div>
	<div id="header">
		<div class="row row-hidden" id="classRow" style="display: none">
			<div class="col-sm-4"></div>
			<div class="col-sm-3">
				<label class="top-lbl">Add Class</label>
			</div>
			<div class="col-sm-2"></div>
			<div class="col-sm-3">
				<label class="top-lbl">Remove Class</label>
			</div>
		</div>

		<div class="row row-hidden" id="facultyRow" style="display: none">
			<div class="col-sm-4"></div>
			<div class="col-sm-3">
				<label class="top-lbl">Add Faculty</label>
			</div>
			<div class="col-sm-2"></div>
			<div class="col-sm-3">
				<label class="top-lbl">Remove Faculty</label>
			</div>
		</div>

		<div class="row row-hidden" id="subjectRow" style="display: none">
			<div class="col-sm-4"></div>
			<div class="col-sm-3">
				<label class="top-lbl">Add Subject</label>
			</div>
			<div class="col-sm-2"></div>
			<div class="col-sm-3">
				<label class="top-lbl">Remove Subject</label>
			</div>
		</div>

		<div class="row row-hidden" id="labRow" style="display: none">
			<div class="col-sm-4"></div>
			<div class="col-sm-3">
				<label class="top-lbl">Lab Rooms</label>
			</div>
			<div class="col-sm-2"></div>
			<div class="col-sm-3">
				<label class="top-lbl">Class Rooms</label>
			</div>
		</div>
	</div>
	<!-- <div id="main">
		
	</div> -->
</body>
</html>