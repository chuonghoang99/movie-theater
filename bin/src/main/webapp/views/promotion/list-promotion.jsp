<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <h3 class="row justify-content-center">Promotion List</h3>
            <div class="mt-2 mr-4">

                <div class="row mt-5">
                    <div class="form-input ml-3">
                        <button type="button" class="btn btn-primary"><i class="fa fa-plus" aria-hidden="true"></i><span
                                class="ml-2">Add new</span> </button>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-8"></div>
                    
                   
                    
					<div class="col-lg-1">
					
						<div>
						<span class="ml-1">Show</span>
							<select id="selectPageSizePromotion"class="form-control">
								<option value=3>3</option>
								<option value=5 selected>5</option>
								<option value=7>7</option>
								<option value=10>10</option>
								<option value=20>20</option>
							</select>
						</div>
					</div>
					
                    <div class="col-lg-3">
                        <div class="row">
                        	<span class="ml-1">Search</span>
                            <div class="input-group rounded mr-3">
                                <input id="searchInputPromotion" type="search" class="form-control rounded" placeholder="Search"
                                    aria-label="Search" aria-describedby="search-addon" value="${searchData}" />
                            </div>
                        </div>
                    </div>
                </div>

                <div class="card mt-3" id="table-promotion">
                    <hr>
                    <h5 class="row justify-content-center" style="color: red" ${numOfPages==0?'':'hidden'}>No data
                        matching</h5>
                    <div class="row card-body">
                        <table class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">ID</th>
                                    <th scope="col">Title</th>
                                    <th scope="col">Start time</th>
                                    <th scope="col">End time</th>
                                    <th scope="col">Discount level</th>
                                    <th scope="col">Detail</th>
                                    <th scope="col">Edit</th>
                                    <th scope="col">Delete</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listOfPromotions}" var="promotion" varStatus="loop">
                                    <tr>
                                        <td class="number">${loop.index+1}</td>
                                        <td>${promotion.promotionId}</td>
                                        <td>${promotion.title}</td>
                                        <td>
                                            <fmt:formatDate value="${promotion.startTime}" pattern="dd/MM/yyyy" />
                                        </td>
                                        <td>
                                            <fmt:formatDate value="${promotion.endTime}" pattern="dd/MM/yyyy" />
                                        </td>
                                        <td>${promotion.discountLevel}</td>
                                        <td>${promotion.detail}</td>
                                        <td> <a href="#" id="editPromotion" value="${promotion.promotionId}"><i
                                                    class="fas fa-edit"></i></a></td>
                                        <td><a href="#" id="deletePromotion" value="${promotion.promotionId}"><i
                                                    class="fas fa-trash-alt"></i></a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

                    <div class="row" ${numOfPages==0?'hidden':''}>
                        <div class="col-lg-12 right">
                            <div aria-label="Page navigation example">
                                <ul class="pagination" pageIndex="${currentPage}" numOfPages="${numOfPages}" id="paginationPromotion">
                                    <li class="page-item ${currentPage == 1?'disabled':''}"><a id="prePromotion" 
                                    		class="page-link" href="#">Previous</a></li>
                                    <c:forEach begin="1" end="${numOfPages}" var="page">
                                        <li class="page-item ${currentPage == page?'active':''}"><a class="page-link"
                                                href="#" id="pagePromotion" value="${page}">${page}</a></li>
                                    </c:forEach>
                                    <li class="page-item ${currentPage == numOfPages?'disabled':''}"><a id="nextPromotion"
                                            class="page-link" href="#">Next</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>


            