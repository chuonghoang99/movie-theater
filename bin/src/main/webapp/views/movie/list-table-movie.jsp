<%@page contentType="text/html" pageEncoding="UTF-8" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
					<hr>
                            <h5 class="row justify-content-center text-info" ${totalPage==0?'':'hidden'}>List empty!</h5>
                            <div class="row card-body">
                                <table class="table table-bordered table-striped">
                                    <thead>
                                        <tr>
                                            <th scope="col">#</th>
                                            <th scope="col">ID</th>
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
                                    		<tr>
	                                            <td class="number">${loop.index+1}</td>
	                                            <td>${movie.movieId}</td>
	                                            <td>${movie.movieNameEnglish}</td>
	                                            <td>${movie.movieNameVn}</td>
	                                            <td><fmt:formatDate value="${movie.fromDate}" pattern="dd/MM/yyyy" /></td>
	                                            <td>${movie.movieProductCompany}</td>
	                                            <td>${movie.duration}</td>
	                                            <td>${movie.version}</td>
	                                            <td> <a href="#" id="editMovie" value="${movie.movieId}"><i class="fas fa-edit"></i></a></td>
	                                            <td><a href="#" id="deleteMovie" value="${movie.movieId}"><i class="fas fa-trash-alt"></i></a></td>
                                        	</tr>
                                    	</c:forEach>
                                        
                                    </tbody>
                                </table>
                            </div>

                            <div class="row" ${totalPage==0?'hidden':''}>
                                <div class="col-lg-12 right">
                                    <div aria-label="Page navigation example">
	                                        <ul class="pagination">
	            								<li class="page-item ${currentPage == 1?'disabled':''}"><a class="page-link " value="${currentPage-1}" href="#" id="pre">Previous</a></li>
	            									<c:forEach begin="1" end="${numOfPages}" var="page">
	                									<li class="page-item ${currentPage == page?'active':''}"><a class="page-link" href="#" id="page" value="${page}">${page}</a></li>
	            									</c:forEach>
	            								<li class="page-item  ${currentPage == numOfPages?'disabled':''}"><a class="page-link " value="${currentPage+1}" id="next" href="#">Next</a></li>
	        								</ul>
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
