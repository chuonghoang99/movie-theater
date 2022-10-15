<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="card-header font-weight-bold">View Content List</div>
<div class="row card-body">
	<table class=" table table-bordered table-striped" id="tableEmployeeList">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">User name</th>
				<th scope="col">Full name</th>
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
					<td><c:out value="${employee.userName }"/></td>
					<td><c:out value="${employee.fullName }"/></td>
					<td><fmt:formatDate value="${employee.dateOfBirth}" pattern="dd/MM/yyyy"/></td>
					<td style="text-align: center"><c:out value="${employee.gender }"/></td>
					<td><c:out value="${employee.email }"/></td>
					<td><c:out value="${employee.identityCard }"/></td>
					<td><c:out value="${employee.phoneNumber }"/></td>
					<td><c:out value="${employee.address }"/></td>
					<td><fmt:formatDate value="${employee.registerDate}" pattern="dd/MM/yyyy"/></td>
					<td>
						<a href="#" id="editEmployee" value="${employee.employeeId}">
							<i class="far fa-edit ml-2 textBlack"></i>
						</a>
					</td>
					<td>
						<a href="#" id="deleteEmployee" value="${employee.employeeId}">
							<i class="far fa-trash-alt ml-3 textBlack"></i>
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<div class="row">
	<div class="col-lg-12 right">
		<div aria-label="Page navigation example">
			<ul class="pagination" pageIndex="${pageIndex}" numOfPages="${numOfPages}">
				<li class="page-item"><a
						href="#" class="page-link pe-auto textBlack"
						id="previous"
				>Previous</a></li>
				<c:forEach begin="1" end="${numOfPages}" var="pageIndex">
					<li class="page-item"><a
							href="#" class="page-link" id="pageIndex"
							value="${pageIndex}"
					>${pageIndex}</a></li>
				</c:forEach>
				<li class="page-item"><a href="#" class="page-link textBlack" id="next">Next</a></li>
			</ul>
		</div>
	</div>
</div>

<!-- Modal -->
<div
		class="modal fade"
		id="modalDeleteEmployee"
		tabindex="-1"
		role="dialog"
		aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true"
>
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title text-danger font-weight-bold" id="exampleModalLongTitle">Delete Employee</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<h5>Are you sure you want to delete employee: <span id="bindEmpName" class="text-danger"></span></h5>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancle</button>
				<button
						type="button" class="btn btn-primary" id="cfDeleteEmployee" data-columnDelete=""
						data-employeeId=""
				>Delete
				</button>
			</div>
		</div>
	</div>
</div>
