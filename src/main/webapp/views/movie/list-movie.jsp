<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h3 class="row justify-content-center font-weight-bold">Movie List</h3>
<div class="mt-2 mr-4">
	<hr>
	<div class="row mt-1">
		<div class="form-input ml-3">
			<button type="button" class="btn btnCustom" id="addMovie"><i class="fa fa-plus" aria-hidden="true"></i>
				<span class="ml-2">Add new</span></button>
		</div>
	</div>

	<div class="row mt-5">
		<div class="col-lg-9">
		</div>

		<div class="col-lg-3">
			<div class="row">
				<div class="input-group rounded mr-3">
					<input
							id="searchInputMovie" type="search" class="form-control rounded" placeholder="Search"
							aria-label="Search" aria-describedby="search-addon" value="${searchData}"
					/>

				</div>
			</div>
		</div>
	</div>

	<div class="card mt-3" id="table-movie">
		<div class="row card-body">
			<table class="table table-bordered table-striped" id="tableMovieList">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Movie(ENG)</th>
						<th scope="col">Movie(VN)</th>
						<th scope="col">Release Date</th>
						<th scope="col">Movie Production Company</th>
						<th scope="col">Duration</th>
						<th scope="col">Version</th>
						<th scope="col">Detail</th>
						<th scope="col">Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${movies}" var="movie" varStatus="loop">
						<tr id="movie${movie.movieId}">
							<td class="number">${loop.index+1}</td>
							<td>
								<c:out value="${movie.movieNameEnglish}"/>
							</td>
							<td>
								<c:out value="${movie.movieNameVn}"/>
							</td>
							<td>
								<fmt:formatDate value="${movie.releaseDate}" pattern="dd/MM/yyyy"/>
							</td>
							<td>
								<c:out value="${movie.movieProductCompany}"/>
							</td>
							<td>
								<c:out value="${movie.duration}"/>
							</td>
							<td>
								<c:out value="${movie.version}"/>
							</td>
							<td><a href="#" id="editMovie" value="${movie.movieId}"><i
									class="fas fa-edit textBlack"
							></i></a></td>
							<td><a href="#" id="deleteMovie" value="${movie.movieId}"><i
									class="fas fa-trash-alt textBlack"
							></i></a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>

		<div class="row" ${totalPage==0? 'hidden': ''}>
			<div class="col-lg-12 right">
				<div aria-label="Page navigation example">
					<ul class="pagination" pageIndex="${currentPage}" numOfPages="${numOfPages}">
						<li class="page-item ${currentPage == 1?'disabled':''}"><a
								class="page-link" value="${currentPage-1}" href="#" id="pre"
						>Previous</a></li>
						<c:forEach begin="1" end="${numOfPages}" var="pageIndex">
							<li class="page-item ${currentPage == pageIndex?'active':''}"><a
									class="page-link" href="#" id="pageIndex" value="${pageIndex}"
							>${pageIndex}</a></li>
						</c:forEach>
						<li class="page-item  ${currentPage == numOfPages?'disabled':''}"><a
								class="page-link" value="${currentPage+1}" id="next" href="#"
						>Next</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal -->
	<div
			class="modal fade" id="modalDeleteMovie" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true"
	>
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title text-danger" id="exampleModalLongTitle">Delete movie</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<h5>Are you sure you want to delete movie: <span id="bindMovieName" class="text-danger"></span>
					</h5>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btnCustom" data-dismiss="modal">Cancle</button>
					<button
							type="button" class="btn btnCustom" id="cfDeleteMovie" data-columnDelete=""
							data-movieId=""
					>Delete
					</button>
				</div>
			</div>
		</div>
	</div>
</div>