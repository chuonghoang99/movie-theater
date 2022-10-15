<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h3 class="row justify-content-center" id="titlePage"></h3>
<img id="imgMovie" src="${movie.largeImage}">
<div>
	<hr>
	<form action="#" method="post" name="formMovie" id="formMovie" enctype="multipart/form-data">
		<input type="hidden" value="${movie.movieId}" id="movieId" name="movieId">
		<p style="color: red" id="message"></p>
		<div class="form-group">
			<label for="movieNameEnglish" class="font-weight-bold">Movie Name(ENG) <span class="text-danger">(*)</span></label>
			<input
					type="text" class="form-control" id="movieNameEnglish" name="movieNameEnglish"
					placeholder="Movie Name(ENG)" value="${movie.movieNameEnglish}"
			>
			<!-- <label class="text-danger"><c:out value="${errorList['movieNameEnglish']}"/></label> -->
			<p class="error" id="movieNameEnglishErr" hidden="true"></p>
		</div>

		<div class="form-group">
			<label for="movieNameVn" class="font-weight-bold">Movie Name(VN) <span
					class="text-danger"
			>(*)</span></label>
			<input
					type="text" class="form-control" id="movieNameVn" name="movieNameVn" placeholder="Movie Name(VN)"
					value="${movie.movieNameVn}"
			>
			<!-- <label class="text-danger"><c:out value="${errorList['movieNameVn']}"/></label> -->
			<p class="error" id="movieNameVnErr" hidden="true">
				<c:out value="${errorList['movieNameVn']}"/>
			</p>
		</div>
		<div class="form-group">
			<label for="fromDate" class="font-weight-bold">From Date <span class="text-danger">(*)</span></label>
			<input
					type="date" class="form-control" id="fromDate" name="fromDate"
					value="<fmt:formatDate value='${movie.fromDate}' pattern='yyyy-MM-dd' />"
			>
			<!-- <label class="text-danger"><c:out value="${errorList['fromDate']}"/></label> -->
			<p class="error" id="fromDate" hidden="true">
				<c:out value="${errorList['fromDate']}"/>
			</p>
		</div>

		<div class="form-group">
			<label for="toDate" class="font-weight-bold">To Date <span class="text-danger">(*)</span></label>
			<input
					type="date" class="form-control" id="toDate" name="toDate"
					value="<fmt:formatDate value='${movie.toDate}' pattern='yyyy-MM-dd' />"
			>
			<!-- <label class="text-danger"><c:out value="${errorList['toDate']}"/></label> -->
			<p class="error" id="toDateErr" hidden="true">
				<c:out value="${errorList['toDate']}"/>
			</p>
		</div>

		<div class="form-group">
			<label for="actor" class="font-weight-bold">Actor <span class="text-danger">(*)</span></label>
			<input type="text" class="form-control" id="actor" name="actor" placeholder="Actor" value="${movie.actor}">
			<!-- <label class="text-danger"><c:out value="${errorList['actor']}"/></label> -->
			<p class="error" id="actorErr" hidden="true">
				<c:out value="${errorList['actor']}"/>
			</p>
		</div>
		<div class="form-group">
			<label for="movieProductCompany" class="font-weight-bold">Production Company <span
					class="text-danger"
			>(*)</span></label>
			<input
					type="text" class="form-control" id="movieProductCompany" name="movieProductCompany"
					placeholder="Production Company" value="${movie.movieProductCompany}"
			>
			<!-- <label class="text-danger"><c:out value="${errorList['movieProductCompany']}"/></label> -->
			<p class="error" id="movieProductCompanyErr" hidden="true">
				<c:out value="${errorList['movieProductCompany']}"/>
			</p>
		</div>
		<div class="form-group">
			<label for="director" class="font-weight-bold">Director<span class="text-danger">(*)</span></label>
			<input
					type="text" class="form-control" id="director" name="director" placeholder="Director"
					value="${movie.director}"
			>
			<!-- <label class="text-danger"><c:out value="${errorList['director']}"/></label> -->
			<p class="error" id="directorErr" hidden="true">
				<c:out value="${errorList['director']}"/>
			</p>
		</div>
		<div class="form-group">
			<label for="duration" class="font-weight-bold">Duration(Minutes)<span class="text-danger">(*)</span></label>
			<input
					type="text" class="form-control" id="duration" name="duration" placeholder="Duration"
					value="${movie.duration}"
			>
			<!-- <label class="text-danger"><c:out value="${errorList['duration']}"/></label> -->
			<p class="error" id="durationErr" hidden="true">
				<c:out value="${errorList['duration']}"/>
			</p>
		</div>
		<div class="form-group">
			<label for="version" class="font-weight-bold">Version<span class="text-danger">(*)</span></label>
			<input
					type="text" class="form-control" id="version" name="version" placeholder="Version"
					value="${movie.version}"
			>
			<!-- <label class="text-danger"><c:out value="${errorList['version']}"/></label> -->
			<p class="error" id="versionErr" hidden="true">
				<c:out value="${errorList['version']}"/>
			</p>
		</div>
		<div class="form-group">
			<label for="exampleInputType" class="font-weight-bold">Type <span class="text-danger">(*)</span></label>
			<div class="custom-control custom-checkbox">
				<div class="row">
					<c:forEach items="${types}" var="type">
						<div class="col-sm-4">
							<div>
								<input
										type="checkbox" class="custom-control-input" name="types" id="${type.typeName}"
										value="${type.typeId}" ${typeIdss.contains(type.typeId) ? 'checked': ''}> <label
									class="custom-control-label" for="${type.typeName}"
							>${type.typeName}</label>
							</div>
						</div>
					</c:forEach>

				</div>
			</div>

			<!-- <label class="text-danger"><c:out value="${errorList['types']}"/></label> -->
			<p class="error" id="typesErr" hidden="true">
				<c:out value="${errorList['types']}"/>
			</p>
		</div>
		<div class="form-group">
			<label for="cinemaRoom" class="font-weight-bold">Cinema Room<span class="text-danger">(*)</span></label>
			<select id="cinemaRoom" name="cinemaRoom" class="form-control">
				<c:forEach items="${cinemaRooms}" var="cinemaRoom">
					<option value="${cinemaRoom.cinemaRoomId}" ${cinemaRoom.cinemaRoomId == movie.cinemaRoom.cinemaRoomId ? 'selected':''}>
							${cinemaRoom.cinemaRoomName }
					</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="exampleInputSchedule" class="font-weight-bold">Schedule <span
					class="text-danger"
			>(*)</span></label>
			<div class="custom-control custom-checkbox">
				<div class="row">
					<c:forEach items="${schedules}" var="schedule">
						<div class="col-sm-4">
							<div>
								<input
										type="checkbox" class="custom-control-input" name="schedules"
										id="${schedule.scheduleId}"
										value="${schedule.scheduleId}" ${scheduleIdss.contains(schedule.scheduleId) ? 'checked': ''}>
								<label
										class="custom-control-label"
										for="${schedule.scheduleId}"
								>${schedule.scheduleTime}</label>
							</div>
						</div>
					</c:forEach>
					<!-- <label class="text-danger"><c:out value="${errorList['schedules']}"/></label> -->
					<p class="error" id="schedulesErr" hidden="true">
						<c:out value="${errorList['schedules']}"/>
					</p>
				</div>
			</div>

		</div>
		<div class="form-group">
			<label for="content" class="font-weight-bold">Content<span class="text-danger">(*)</span></label>
			<textarea class="form-control" id="content" name="content" rows="2">${movie.content}</textarea>
			<!-- <label class="text-danger"><c:out value="${errorList['content']}"/></label> -->
			<p class="error" id="contentErr" hidden="true">
				<c:out value="${errorList['content']}"/>
			</p>
		</div>

		<div class="form-group">
			<label for="movieImage">Image</label>
			<input
					type="file" class="form-control" id="movieImage" name="movieImage" accept="image/*"
					onchange="readURL(this);"
			>
		</div>

		<button id="btnSaveMovie" type="button" class="btn btnCustom">
			<i class="fas fa-check"></i> Save
		</button>

		<button id="btnBackMovie" type="button" class="btn btnCustom">
			<i class="fas fa-times"></i> Back
		</button>

	</form>
	<script>
        function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('#imgMovie').attr('src', e.target.result).width(150).height(200);
                };

                reader.readAsDataURL(input.files[0]);
            }
        }
	</script>
</div>