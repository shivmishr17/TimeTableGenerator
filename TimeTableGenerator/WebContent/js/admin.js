/**
 * @author: Surya Deep Mishra
 */

$(document).ready(function() {

	// On Class Row Hover
	$("#classHover").mouseover(function() {
		if ($("#header").hasClass('header-visible-per')) {
			$(".row-hidden").removeClass('row-show');
		}
		$("#classRow").addClass('row-show');
		$("#header").addClass("header-visible");
	}).mouseout(function() {
		if (!$("#header").hasClass('header-visible-per')) {
			$("#classRow").removeClass('row-show');
		} else if ($(this).hasClass('lblParents-active')) {

		} else {
			$("#classRow").removeClass('row-show');
		}
		$("#header").removeClass("header-visible");
	}).click(function() {
		$(".lblParents").removeClass('lblParents-active');
		$(this).toggleClass('lblParents-active');
		$("#classRow").addClass('row-show');
		$("#header").toggleClass("header-visible-per");
	});

	// On Subject Row Hover
	$("#subjectHover").mouseover(function() {
		if ($("#header").hasClass('header-visible-per')) {
			$(".row-hidden").removeClass('row-show');
		}
		$("#subjectRow").addClass('row-show');
		$("#header").addClass("header-visible");
	}).mouseout(function() {
		if (!$("#header").hasClass('header-visible-per')) {
			$("#subjectRow").removeClass('row-show');
		} else if ($(this).hasClass('lblParents-active')) {

		} else {
			$("#subjectRow").removeClass('row-show');
		}
		$("#header").removeClass("header-visible");
	}).click(function() {
		$(".lblParents").removeClass('lblParents-active');
		$(this).toggleClass('lblParents-active');
		$("#subjectRow").addClass('row-show');
		$("#header").toggleClass("header-visible-per");
	});

	// On Faculties Row Hover
	$("#facultyHover").mouseover(function() {
		if ($("#header").hasClass('header-visible-per')) {
			$(".row-hidden").removeClass('row-show');
		}
		$("#facultyRow").addClass('row-show');
		$("#header").addClass("header-visible");
	}).mouseout(function() {
		if (!$("#header").hasClass('header-visible-per')) {
			$("#facultyRow").removeClass('row-show');
		} else if ($(this).hasClass('lblParents-active')) {

		} else {
			$("#facultyRow").removeClass('row-show');
		}
		$("#header").removeClass("header-visible");
	}).click(function() {
		$(".lblParents").removeClass('lblParents-active');
		$(this).toggleClass('lblParents-active');
		$("#facultyRow").addClass('row-show');
		$("#header").toggleClass("header-visible-per");
	});

	// On Rooms Row Hover
	$("#roomHover").mouseover(function() {
		if ($("#header").hasClass('header-visible-per')) {
			$(".row-hidden").removeClass('row-show');
		}
		$("#labRow").addClass('row-show');
		$("#header").addClass("header-visible");
	}).mouseout(function() {
		if (!$("#header").hasClass('header-visible-per')) {
			$("#labRow").removeClass('row-show');
		} else if ($(this).hasClass('lblParents-active')) {

		} else {
			$("#labRow").removeClass('row-show');
		}
		$("#header").removeClass("header-visible");
	}).click(function() {
		$(".lblParents").removeClass('lblParents-active');
		$(this).toggleClass('lblParents-active');
		$("#labRow").addClass('row-show');
		$("#header").toggleClass("header-visible-per");
	});

});