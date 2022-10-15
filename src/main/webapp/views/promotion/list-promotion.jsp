<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h3 class="row justify-content-center font-weight-bold">Promotion
	List</h3>
<div class="mt-2 mr-4">
	<div class="row mt-5">
		<div class="form-input ml-3">
			<button type="button" class="btn btnCustom" id="btnAddPromotion">
				<i class="fa fa-plus" aria-hidden="true"></i><span class="ml-2">Add new </span>
			</button>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-8"></div>
		<div class="col-lg-1">
			<div>
				<span class="ml-1">Show</span> <select
					id="selectPageSizePromotion"
					class="form-control"
			>
				<option value=5 selected>5</option>
				<option value=10>10</option>
				<option value=20>20</option>
				<option value=100>100</option>
			</select>
			</div>
		</div>

		<div class="col-lg-3">
			<div class="row">
				<span class="ml-1">Search</span>
				<div class="input-group rounded mr-3">
					<input
							id="searchInputPromotion" type="search"
							class="form-control rounded" placeholder="Search"
							aria-label="Search" aria-describedby="search-addon"
							value="${searchData}"
					/>
				</div>
			</div>
		</div>
	</div>

	<div class="card mt-3" id="table-promotion">
		<div
				style="color: red; font-size: 20px;" class="font-weight-bold"
		${messagePromotion==null?'hidden':''}>${messagePromotion}</div>
		<div class="card-header font-weight-bold">View Content List</div>
		<div class="row card-body">
			<table class="table table-bordered table-striped" id="tablePromotion">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Title</th>
						<th scope="col">Start time (DD/MM)</th>
						<th scope="col">End time (DD/MM)</th>
						<th scope="col">Discount level</th>
						<th scope="col">Detail</th>
						<th scope="col">Edit</th>
						<th scope="col">Delete</th>
					</tr>
				</thead>
				<tbody id="tbodypromotion">
					<c:forEach items="${listOfPromotions}" var="promotion" varStatus="loop">
						<tr id="promotion${promotion.promotionId}">
							<td>${loop.index+1}</td>
							<td><c:out value="${promotion.title}"/></td>
							<td><fmt:formatDate
									value="${promotion.startTime}"
									pattern="dd/MM/yyyy HH:mm"
							/></td>
							<td><fmt:formatDate
									value="${promotion.endTime}"
									pattern="dd/MM/yyyy HH:mm"
							/></td>
							<td>${promotion.discountLevel}</td>
							<td><c:out value="${promotion.detail}"/></td>
							<td><a
									href="#" id="editPromotion"
									value="${promotion.promotionId}"
							><i class="fas fa-edit textBlack"></i></a></td>
							<td><a
									href="#" id="deletePromotion"
									value="${promotion.promotionId}"
							><i class="fas fa-trash-alt textBlack"></i></a></td>
						</tr>
					</c:forEach>
					<p class="error" id="message"></p>
				</tbody>
			</table>
		</div>

		<div class="row" ${numOfPages==0?'hidden':''}>
			<div class="col-lg-12 right">
				<div aria-label="Page navigation example">
					<ul
							class="pagination" pageIndex="${currentPage}"
							numOfPages="${numOfPages}" id="paginationPromotion"
					>
						<li class="page-item ${currentPage == 1?'disabled':''}"><a
								id="prePromotion" class="page-link pagingPromotion" href="#"
								value="${currentPage-1}"
						>Previous</a></li>
						<c:forEach begin="1" end="${numOfPages}" var="page">
							<li class="page-item ${currentPage == page?'active':''}"><a
									class="page-link pagingPromotion" href="#" id="pagePromotion"
									value="${page}"
							>${page}</a></li>
						</c:forEach>
						<li class="page-item ${currentPage == numOfPages?'disabled':''}">
							<a
									id="nextPromotion " class="page-link pagingPromotion" href="#"
									value="${currentPage+1}"
							>Next</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<div class="modal" tabindex="-1" role="dialog" id="modalConfirmDelete">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Delete</h5>
					<button
							type="button" class="close" data-dismiss="modal"
							aria-label="Close"
					>
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p>Are you sure you want to delete?</p>
				</div>
				<div class="modal-footer">
					<button
							type="button" class="btn btnCustom" id="btnAccept"
							data-delete-id=""
					>Delete
					</button>
					<button
							type="button" class="btn btnCustom"
							data-dismiss="modal"
					>Close
					</button>
				</div>
			</div>
		</div>
	</div>
</div>