
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h3 class="row justify-content-center">Employee List</h3>
<div class="mt-2 mr-4">
	<hr>
	<h5 class="row justify-content-center text-info" ${numOfPages==0?'':'hidden'}>List employee empty!</h5>
	<div class="row mt-1">
		<div class="form-input ml-3">
			<button type="button" class="btn btn-primary" id="addEmployee">
				<i class="fa fa-plus" aria-hidden="true"></i><span class="ml-2">Add
					new</span>
			</button>
		</div>

	</div>
	<div class="row">
		<div class="col-lg-8"></div>
		<div class="col-lg-1">
			<div>
				<span class="ml-1">Show</span> <select id="selectPageSize"
					class="form-control">
					<option value=3>3</option>
					<option value=5 selected>5</option>
					<option value=10>10</option>
					<option value=20>20</option>
					<option value=30>30</option>
				</select>
			</div>

		</div>
		<div class="col-lg-3">
			<div class="row">
				<spam class="hidden-md">Search</spam>
				<div class="input-group rounded mr-3">
					<input id="inputSearch" type="search" class="form-control rounded"
						placeholder="Search" />
				</div>
			</div>
		</div>

	</div>
	<div class="card mt-3" id="content-table">
		<div class="card-header font-weight-bold">View Content List</div>
		<div class="row card-body"">
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Username</th>
						<th style="">Full name</th>
						<th scope="col">Date of birth</th>
						<th scope="col" style="text-align: center">Gender</th>
						<th scope="col">Email</th>
						<th scope="col">Identity card</th>
						<th scope="col">Phone number</th>
						<th scope="col">Address</th>
						<th scope="col">Register date</th>
						<th scope="col">Edit</th>
						<th scope="col">Delete</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${employeeVos}" var="employee" varStatus="loop">
						<tr>
							<td class="number">${loop.index+1}</td>
							<td>${employee.userName }</td>
							<td>${employee.fullName }</td>
							<td>${employee.dateOfBirth }</td>
							<td style="text-align: center">${employee.gender }</td>
							<td>${employee.email }</td>
							<td>${employee.identityCard }</td>
							<td>${employee.phoneNumber }</td>
							<td>${employee.address }</td>
							<td>${employee.registerDate }</td>
							<td><a href="#" value="${employee.employeeId}" type="button"><i
									class="far fa-edit ml-2"></i> </a></td>
							<td><a href="#" value="${employee.employeeId} type="button"><i
									class="far fa-trash-alt ml-3"></i> </a></td>
						</tr>

					</c:forEach>

				</tbody>

			</table>
		</div>

		<div class="row">
			<div class="col-lg-12 right">
				<div aria-label="Page navigation example">
					<ul class="pagination" pageIndex="${pageIndex}"
						numOfPages="${numOfPages}">
						<li class="page-item"><a class="page-link" id="previous">Previous</a></li>
						<c:forEach begin="1" end="${numOfPages}" var="pageIndex">
							<li class="page-item"><a class="page-link" id="pageIndex"
								value="${pageIndex}">${pageIndex}</a></li>
						</c:forEach>
						<li class="page-item"><a class="page-link" id="next">Next</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

</div>

<script>
	// chuonghv99: JS - listEmployee // 

	// Click add new button 
	$("body").on("click", "#addEmployee", function(e) {
		e.preventDefault();
		$.get({
			url : "/admin/employee/add-employee",
			async : false,
			success : function(response) {
				$("#content-page").html(response);
			},
		})

	});

	// Click change select	
	$("body").on('change', '#selectPageSize', function(e) {
		var dataSearch = $("#inputSearch").val();
		var pageSize = $("#selectPageSize").val();
		var pageIndex = 1;
		$.get({
			url : "/admin/employee/list-employee/filter",
			async : false,
			data : {
				pageIndex : pageIndex,
				pageSize : pageSize,
				dataSearch : dataSearch,
			},
			success : function(response) {
				$("#content-table").html(response);
				$("#inputSearch").val(dataSearch);
				$("#selectPageSize").val(pageSize);

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
		})
	});

	// search
	$('body').on("input", '#inputSearch', function(e) {
		e.preventDefault();
		var dataSearch = $("#inputSearch").val();
		var pageIndex = 1;
		var pageSize = $("#selectPageSize").val();
		$.ajax({
			url : "/admin/employee/list-employee/filter",
			data : {
				pageIndex : pageIndex,
				pageSize : pageSize,
				dataSearch : dataSearch
			},
			success : function(response) {
				$("#content-table").html(response);
				$("#inputSearch").val(dataSearch);
				$("#selectPageSize").val(pageSize);

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
			error : function(response) {

			}
		});
	});

	// Click previous button 
	$("body").on("click", "a#previous", function(e) {
		e.preventDefault();
		var pageIndex = $('ul.pagination').attr('pageIndex');
		var dataSearch = $("#inputSearch").val();
		pageIndex = (pageIndex == 1) ? 1 : pageIndex - 1;
		var dataSearch = $("#inputSearch").val();
		var pageSize = $("#selectPageSize").val();

		$.get({
			url : "/admin/employee/list-employee/filter",
			async : false,
			data : {
				dataSearch : dataSearch,
				pageIndex : pageIndex,
				pageSize : pageSize,
			},
			success : function(response) {
				$("#content-table").html(response);
				$("#inputSearch").val(dataSearch);
				$("#selectPageSize").val(pageSize);

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
		})

	});

	// Click page index 
	$("body").on("click", "a#pageIndex", function(e) {
		e.preventDefault();
		var dataSearch = $("#inputSearch").val();
		var pageIndex = $(this).attr("value");

		var pageSize = $("#selectPageSize").val();
		$.get({
			url : "/admin/employee/list-employee/filter",
			async : false,
			data : {
				dataSearch : dataSearch,
				pageIndex : pageIndex,
				pageSize : pageSize,
			},
			success : function(response) {
				$("#content-table").html(response);
				$("#inputSearch").val(dataSearch);
				$("#selectPageSize").val(pageSize);

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

		})

	});

	// Click next button 
	$("body").on("click", "a#next", function(e) {
		e.preventDefault();
		var pageIndex = $('ul.pagination').attr('pageIndex');
		var numOfPages = $('ul.pagination').attr('numOfPages');
		pageIndex = (pageIndex == numOfPages) ? pageIndex : pageIndex - (-1);
		var dataSearch = $("#inputSearch").val();
		var pageSize = $("#selectPageSize").val();
		$.get({
			url : "/admin/employee/list-employee/filter",
			async : false,
			data : {
				dataSearch : dataSearch,
				pageIndex : pageIndex,
				pageSize : pageSize,
			},
			success : function(response) {
				$("#content-table").html(response);
				$("#inputSearch").val(dataSearch);
				$("#selectPageSize").val(pageSize);

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
		})

	});
</script>