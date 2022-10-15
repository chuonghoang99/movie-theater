<%@ page
		language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"
%>
<style>
    .imgToolTip {
        max-width: 100%;
    }
</style>
<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Page Wrapper -->
<div id="wrapper">
	<!-- Content Wrapper -->
	<div id="content-wrapper" class="d-flex flex-column">

		<!-- Main Content -->
		<div id="content">
			<!-- Begin Page Content -->
			<div class="container-fluid">
				<h3 class="row justify-content-center">Cinema room List</h3>
				<div class="mt-2 mr-4">
					<hr>
					<c:if test="${roomRecords == 0}">
						<h5 class="row justify-content-center text-info">No cinema room record exists!</h5>
					</c:if>

					<div class="row mt-1">
						<div class="form-input ml-3">
							<a href="" class="btnAddRoom">
								<button type="button" class="btn btnCustom">
									<i class="fa fa-plus" aria-hidden="true"></i><span class="ml-2">Add new</span>
								</button>
							</a>
						</div>
					</div>

					<div class="row mt-1">
						<div class="col-lg-9"></div>
						<div class="col-lg-3">
							<div class="row">
								<div class="input-group rounded mr-3">
									<input
											id="searchInput" type="text" class="form-control rounded"
											placeholder="Search" aria-label="Search" aria-describedby="search-addon"
											value="${roomName}"
									/>
								</div>
							</div>
						</div>
					</div>
					<div class="card mt-3">
						<div class="card-header font-weight-bold">View Content List</div>
						<div class="row card-body">
							<table class="table table-bordered table-striped">
								<thead>
									<tr>
										<th scope="col">#</th>
										<th style="col">Cinema room name</th>
										<th scope="col">Seat quantity</th>
										<th scope="col">Seat detail</th>
									</tr>
								</thead>
								<tbody>
								<tbody>
									<c:forEach items="${cinemaRooms}" var="room" varStatus="loop">
										<tr>
											<td class="number">
												<c:out value="${loop.index + 1}"/>
											</td>
											<td><a
													value="${room.cinemaRoomId}" data-toggle="tooltip"
													data-placement="top"
													data-html="true" class="room-image" style="text-decoration:none;"
													title=""
											>
												<c:out value="${room.cinemaRoomName}"/>
											</a>
											</td>
											<td>${room.seatQuantity}</td>
											<td>
												<a href="" class="btnUpdateRoom" value="${room.cinemaRoomId}"><i
														class="fa fa-info-circle" aria-hidden="true"
												></i> Seat
													detail</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<c:if test="${roomRecords > 0}">
							<div class="row">
								<div class="col-lg-12 right">
									<div aria-label="Page navigation example">
										<ul class="pagination">
											<li class="page-item ${currentPage == 1?'disabled':''}"><a
													class="page-link pageWithoutNum" value="Previous"
													href="#"
											>Previous</a></li>
											<c:forEach begin="1" end="${numOfPages}" var="page">
												<li class="page-item ${currentPage == page?'disabled':''}"><a
														class="page-link pageWithNum ${currentPage == page?'currentPage':''}"
														href="#" id="${page}"
												>${page}</a></li>
											</c:forEach>
											<li class="page-item ${currentPage == numOfPages?'disabled':''}"><a
													class="page-link pageWithoutNum" value="Next" href="#"
											>Next</a></li>
										</ul>
									</div>
								</div>
							</div>
						</c:if>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>
<!-- End of Main Content -->
<script>
    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    })
</script>