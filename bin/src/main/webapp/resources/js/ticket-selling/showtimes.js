$(document).ready(function() {
	var dateSelecting;
	$("body").on("click", ".content__time--label", function() {
		dateSelecting = $(this).attr("value");
		$.get({
			url: "/admin/showtimes",
			data: {
				dateSelecting: dateSelecting
			},
			success: function(response) {
				$(".container-fluid").html(response);
			},
			error: function(error) {
				alert("Falied!" + error);
			}
		});
	});
	$("body").on("click", "a.showtimes", function() {
		var pageIndex = $(this).attr("value");
		$.get({
			url: "/admin/showtimes",
			data: {
				pageIndex: pageIndex,
				dateSelecting: dateSelecting
			},
			success: function(response) {
				$(".container-fluid").html(response);
			},
			error: function(error) {
				alert("Falied!" + error);
			}
		});
	});
});
