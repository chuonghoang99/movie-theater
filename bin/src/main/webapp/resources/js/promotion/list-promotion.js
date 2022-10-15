$(document).ready(function() {

	$("body").on("change", "#selectPageSizePromotion", function() {
		var searchDataPromotion = $("#searchInputPromotion").val();
		var pageSizePromotion = $("#selectPageSizePromotion").val();
		console.log(pageSizePromotion);
		$.get({
			url: "/admin/promotion/search",
			data: {
				pageSizePromotion: pageSizePromotion,
				searchDataPromotion: searchDataPromotion,
			},
			success: function(response) {
				$("div#table-promotion").html(response);
			},
			error: function(responseError) {
				alert(JSON.stringify(responseError));
			}
		});
	});

	$("body").on("click", "a#pagePromotion", function() {
		var pageIndexPromotion = $(this).attr("value");
		var searchDataPromotion = $("#searchInputPromotion").val();
		var pageSizePromotion = $("#selectPageSizePromotion").val();
		console.log(pageIndexPromotion);
		$.get({
			url: "/admin/promotion/search",
			data: {
				pageIndexPromotion: pageIndexPromotion,
				pageSizePromotion: pageSizePromotion,
				searchDataPromotion: searchDataPromotion,
			},
			success: function(response) {
				$("div#table-promotion").html(response);
			},
			error: function(responseError) {
				alert(JSON.stringify(responseError));
			}
		});
	});

	$("body").on("click", "a#prePromotion", function() {
		var pageIndexPromotion = $("ul#paginationPromotion").attr('pageIndex');
		var searchDataPromotion = $("#searchInputPromotion").val();
		var pageSizePromotion = $("#selectPageSizePromotion").val();
		pageIndexPromotion = Number(pageIndexPromotion) - 1;
		$.get({
			url: "/admin/promotion/search",
			data: {
				pageIndexPromotion: pageIndexPromotion,
				pageSizePromotion: pageSizePromotion,
				searchDataPromotion: searchDataPromotion,
			},
			success: function(response) {
				$("div#table-promotion").html(response);
			},
			error: function(responseError) {
				alert(JSON.stringify(responseError));
			}
		});
	});

	$("body").on("click", "a#nextPromotion", function() {
		var pageIndexPromotion = $("ul#paginationPromotion").attr('pageIndex');
		var searchDataPromotion = $("#searchInputPromotion").val();
		var pageSizePromotion = $("#selectPageSizePromotion").val();
		pageIndexPromotion = Number(pageIndexPromotion) + 1;
		console.log(pageIndexPromotion);
		$.get({
			url: "/admin/promotion/search",
			data: {
				pageIndexPromotion: pageIndexPromotion,
				pageSizePromotion: pageSizePromotion,
				searchDataPromotion: searchDataPromotion,
			},
			success: function(response) {
				$("div#table-promotion").html(response);
			},
			error: function(responseError) {
				alert(JSON.stringify(responseError));
			}
		});
	});

	$("body").on("input", "input#searchInputPromotion", function() {
		var searchDataPromotion = $("#searchInputPromotion").val();
		var pageSizePromotion = $("#selectPageSizePromotion").val();
		$.get({
			url: "/admin/promotion/search",
			data: {
				searchDataPromotion: searchDataPromotion,
				pageSizePromotion: pageSizePromotion,
				pageIndexPromotion: 1,
			},
			success: function(response) {
				$("div#table-promotion").html(response);
			},
			error: function(responseError) {
				alert(JSON.stringify(responseError));
			}
		});
	});

});