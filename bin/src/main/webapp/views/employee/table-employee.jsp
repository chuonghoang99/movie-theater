
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

<script
	src="${pageContext.servletContext.contextPath}/resources/js/list-employee.js"></script>