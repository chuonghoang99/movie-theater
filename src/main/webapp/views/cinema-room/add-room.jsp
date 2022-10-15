<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

                <div>
                    <hr>
                    <div class="holder">
                        <img id="imgPreview" src="" style="max-width: 300px; display: block; margin: 0px auto" />
                    </div>
                    <form id="cinemaRoomAddForm" enctype="multipart/form-data">
                        <p id="mainMethodMessage" style="color: red"></p>
                        <div class="form-group">
                            <label for="roomName">Room name <span class="text-danger">(*)</span></label>
                            <input type="text" class="form-control" id="roomName" name="roomName" placeholder="Input room name">
                            <p id="roomNameMessage" style="color: red"></p>
                        </div>

                        <div class="form-group">
                            <label for="seatQuantity">Seat quantity <span class="text-danger">(*)</span></label>
                            <select name="seatQuantity" id="seatQuantity" style="width: 100%; height: calc(1.5em + .75rem + 2px); border: 1px solid #d1d3e2; border-radius: .35rem; padding: .375rem .75rem;">
				<c:forEach items="${listSeatQuantity}" var="seatQuantity" varStatus="loop">
					<option value="${seatQuantity}">${seatQuantity}</option>
				</c:forEach>
			</select>
                        </div>

                        <div class="form-group">
                            <label for="roomImage">Image</label> <input style="line-height: 100%" type="file" class="form-control" id="roomImage" name="roomImage">
                        </div>

                        <button id="btnSaveRoom" type="submit" class="btn btn-primary">
			<i class="fas fa-plus"></i> Save
		</button>

                        <button id="btnBackRoom" type="button" class="btn btn-primary">
			<i class="fas fa-arrow-left"></i> Back
		</button>

                    </form>
                </div>