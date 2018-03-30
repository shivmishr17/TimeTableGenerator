/**
 * @author: Surya Deep Mishra
 */

$(document).ready(function() {
	$("#createTT").click(function() {
		if($(".select-container").hasClass('menu')) {
			$(".menu").hide(0, function() {
				$("#mainTT").stop().css({
					'filter' : 'blur(0px)',
					'-webkit-filter' : 'blur(0px)',
					'-moz-filter' : 'blur(0px)'
				});
			});
		} else {
			hide(function() {
				$("#mainTT").stop().css({
					'display' : 'block'
				});
				
				var scale = 0;
				while(scale < 0.9) {
					scale += 0.1;
					$("#mainTT").stop().css('transform' , 'scale('+scale+')');
					$("#mainTT").css('transform');
				}
			});
		}
	});
	
	$("#viewTT").click(function() {
		hide();
	});
	
	$("#menu").click(function() {
		$("#mainTT").css({
			'filter' : 'blur(7px)',
			'-webkit-filter' : 'blur(7px)',
			'-moz-filter' : 'blur(7px)'
		});
		$(".menu").show();
	});
	
	$("#close").click(function() {
		$(".menu").hide(0, function(){
			$("#mainTT").stop().css({
				'filter' : 'blur(0px)',
				'-webkit-filter' : 'blur(0px)',
				'-moz-filter' : 'blur(0px)'
			});
		});
	});
	
	$(document).keyup(function(e) {
	     if (e.keyCode == 27) {
	    	 $("#close").click();
	    }
	});
	
	$("#submit").click(function(e) {
		e.preventDefault();
		var form = $("#facultySubjectsForm");
		var i = $("#prototype-row select:eq(0)").attr('name').substr(7);
		console.log(i);
		i = parseInt(i);
		console.log(i);
		$.ajax({
            type: $(form).attr('method'),
            url: $(form).attr('action'),
            data: '&i='+i+"&"+$(form).serialize(),
            success: function(response) {
                alert(response);
            },
            error: function() {
            	alert("Some Error Occured");
            }
        });
	});
	
	var i=0;
	$("#addBtn").on('click', function() {
		var row = $("#prototype-row").html();
		$("#prototype-row").removeAttr("id");
		$("#selectEntries").append("<div class='row' style='margin-top: 5px;' id='prototype-row'>"+row+"</div>");
		do{
			i++;
			$("#prototype-row select:eq(0)").attr('name', 'faculty'+i);
			$("#prototype-row select:eq(1)").attr('name', 'subject'+i);
			$("#prototype-row select:eq(2)").attr('name', 'subType'+i);
			$("#prototype-row select:eq(3)").attr('name', 'class'+i);
			$("#prototype-row select:eq(4)").attr('name', 'fac2'+i);
			break;
		}while(i<15);
	});
	
	$("#deleteBtn").on('click', function() {
		var prevDiv = $("#prototype-row").prev();
		if($("#prototype-row").prev().length != 0) {
			$("#prototype-row").remove();
			$(prevDiv).attr('id', 'prototype-row');
		}
	});
	
	// Get class and section list
	$.ajax({
        type: 'post',
        url: 'info',
        data: {
        	'what' : 'classList'
        },
        success: function(response) {
        	console.log(response);
        	$.each(response, function(index, item) {
                $("<option value='"+item+"'>").text(item).appendTo($(".classes"));
            });
        },
        error: function() {
        	alert("Some Error Occured");
        }
    });
	
	// Get faculty list
	$.ajax({
		type: 'post',
		url: 'info',
		data: {
			'what' : 'facultyList'
		},
		success: function(response) {
			console.log(response);
			$.each(response, function(index, item) {
				$("<option value='"+index+"'>").text(item).appendTo($(".faculties"));
				$("<option value='" + index + "'>").text(item).appendTo($(".fac2"));
			});
		},
		error: function() {
			alert("Some Error Occured");
		}
	});
	
	// Get subjects list
	$("#semester").change(function() {
		$(".subjects").html("");
		$.ajax({
			type: 'post',
			url: 'info',
			data: {
				'what' : 'subjectsList',
				'sem' : $("#semester").val()
			},
			success: function(response) {
				console.log(response);
				$.each(response, function(index, item) {
									$("<option value='" + index + "'>").text(
											item).appendTo($(".subjects"));
				});
			},
			error: function() {
				alert("Some Error Occured");
			}
		});
	});
	
	// Get subjects list
	$(document.body).on('change', '.subType', function() {
		if($(this).val() == 'Practical') {
			console.log("Practical");
			var fac2Element = $(this).parent().next().next().find('select.fac2');
			$(fac2Element).removeAttr('disabled');
			$(fac2Element).css('background' , 'white');
		} else {
			console.log("Theory");
			var fac2Element = $(this).parent().next().next().find('select.fac2');
			$(fac2Element).attr('disabled', 'disabled');
			$(fac2Element).css('background' , 'rgb(210, 210, 210)');
		}
	});
	
	function hide(callback) {
		$(".select").stop().css('border-radius', '0');
		$(".select").stop().fadeOut(300, function() {
			$(".select-container").addClass('menu');
			$(".select").addClass('menu-circle');
			callback();
		});
	}
});