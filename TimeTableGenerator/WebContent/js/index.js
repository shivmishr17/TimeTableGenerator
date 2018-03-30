$(document).ready(function() {
	//On admin click
	$("#admin-btn").click(function(e) {
		$(this).removeClass("btn").addClass("btn-field");
		$(this).val("").attr('type', 'password');
		$(this).attr('placeholder', 'Password');
		$(this).attr('name', 'adminPwd');
		
		$("#user-btn").removeClass("btn-field").addClass("btn");
		$("#user-btn").val("User").attr('type', 'button');
		$("#user-btn").removeAttr('placeholder');
		$("#user-btn").attr('id', 'user-btn');
	});
	
	//On User click
	$("#user-btn").click(function(e) {
		$(this).removeClass("btn").addClass("btn-field");
		$(this).val("").attr('type', 'password');
		$(this).attr('placeholder', 'Password');
		$(this).attr('name', 'adminPwd');
		
		$("#admin-btn").removeClass("btn-field").addClass("btn");
		$("#admin-btn").val("Admin").attr('type', 'button');
		$("#admin-btn").removeAttr('placeholder');
		$("#admin-btn").attr('id', 'admin-btn');
	});
	
	//Login User
	$('#user-btn').keypress(function (e) {
		var key = e.which;
		var form = $("#userForm");
		if(key == 13) {
			e.preventDefault();
			$.ajax({
	            type: $(form).attr('method'),
	            url: $(form).attr('action'),
	            data: {
					'username' : 'user',
					'pwd' : $('#user-btn').val()
				},
	            success: function(response) {
	            	console.log(response);
	            	if(response == 'Go'){
	            		location.href = "user.jsp"
	            	} else {
	            		swal("Error", "Invalid username or password", "error");
	            	}
	            },
	            error: function() {
	            	swal("Error", "Something went wrong! Contact the administrator", "error");
	            }
	        });
		}
	});
	
	//Login Admin
	$('#admin-btn').keypress(function (e) {
		var key = e.which;
		var form = $("#adminForm");
		if(key == 13) {
			e.preventDefault();
			$.ajax({
				type: $(form).attr('method'),
	            url: $(form).attr('action'),
	            data: {
					'username' : 'admin',
					'pwd' : $('#admin-btn').val()
				},
	            success: function(response) {
	            	console.log(response);
	            	if(response == 'Go'){
	            		location.href = "admin.jsp";
	            	} else {
	            		swal("Error", "Invalid username or password", "error");
	            	}
	            },
	            error: function() {
	            	swal("Error", "Something went wrong! Contact the administrator", "error");
	            }
	        });
		}
	}); 
});