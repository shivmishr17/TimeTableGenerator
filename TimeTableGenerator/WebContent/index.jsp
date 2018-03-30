<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="shortcut icon" href="logo.png">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="css/bootstrap.min.css">

<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet">

<link href="css/sweetalert.css" rel="stylesheet">

<!-- jQuery library -->
<script
	src="js/jquery-1.11.3.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="js/bootstrap.min.js"></script>

<!-- css file for this -->
<link rel="stylesheet" href="css/index.css">

<!-- js file for this -->
<script src="js/index.js"></script>

<!-- js file for sweetalert -->
<script src="js/sweetalert.min.js"></script>
<title>Time Table Generator</title>
</head>
<body>
	<div class="row">
		<!-- <div class="col-sm-3"></div> -->
		<div class="main-container col-sm-12">
			<div id="main">
				<div class="row">
					<div class="col-sm-12" style="display: table;">
						<h1 align="center" id="welcome-head">Time-Table
							Generator</h1>
					</div>
				</div>
				<div class="row" style="margin-top: 5em;">
					<div class="col-sm-2"></div>
					<div class="col-sm-3 btn-container">
						<form id="adminForm" action="login" method="post">
							<input id="admin-btn" type="button" class="btn" value="Admin">
						</form>
					</div>
					<div class="col-sm-2"></div>
					<div class="col-sm-3 btn-container">
						<form id="userForm" action="login" method="post">
							<input id="user-btn" type="button" class="btn" value="User">
						</form>
					</div>
					<div class="col-sm-2"></div>
				</div>
			</div>
		</div>
		<!-- <div class="col-sm-3"></div> -->
	</div>
</body>
</html>