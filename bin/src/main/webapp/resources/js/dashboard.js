$(document).ready(function() {
	$("#ticket_selling").click(function() {
		$.get({
			url: "/admin/showtimes",
			success: function(response) {
				$(".container-fluid").html(response);
			},
			error: function(error) {
				alert("Falied!" + error);
			}
		});
	});
	
	
	$("#promotion").click(function() {
		$.get({
			url: "/admin/promotion/list",
			success: function(response) {
				$(".container-fluid").html(response);
			},
			error: function(error) {
				alert("Falied!" + error);
			}
		});
	});
	
	
	// chuonghv99
	$("body").on("click", "#employee, #btnBackEmoployee", function(e) {
		e.preventDefault();
		document.title = $(this).text();
		$.ajax({
			url: "/admin/employee/list-employee",
			success: function(response) {
				$("#content-page").html(response);
				pageIndex = $('ul.pagination').attr('pageIndex');
				var numOfPages = $('ul.pagination').attr('numOfPages');
				$('li.page-item').eq(pageIndex).addClass("active");
				if (pageIndex == 1) {
					$("a#previous").css("opacity", "0.4");
					$("a#previous").prop("disabled", true);
				}
				if (pageIndex == numOfPages) {
					$("a#next").css("opacity", "0.4");
					$("a#next").prop("disabled", true);
				}
			},

		});
	});
	//khanhdd7
	$("#movie").click(function() {
		$.get({
			url: "/admin/movie/list",
			success: function(response) {
				$(".container-fluid").html(response);
			},
			error: function(error) {
				alert("Falied!" + error);
			}
		});
	});	
	
	
});

