<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <link rel="stylesheet" href="/resources/css/ticket-selling/selecting-seat.css">
    <div class="row mb-5">
        <p class="mr-4 mt-1 font-weight-bold">Select seat quantity</p>
        <select class="custom-select col-1" id="seatQuantity">
            <option value="1" selected>1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
        </select>
    </div>
    <span class="messageInfor mb-2" style="color:red"></span>
    <div class="row justify-content-center" id="rowListSeat">
        <table class="table" id="tableSeat">
            <tbody>
                <c:set var="col" value="1" />
                <c:forEach items="${cinemaRoom.seats}" var="seat">
                    <c:choose>
                        <c:when test="${col == 1}">
                            <tr>
                                <td>
                                    <button type="button"
                                        class="pushable ${(seat.status==1?'pushable-sold':(seat.seatType==1?'pushable-vip':''))}"
                                        data-type="${(seat.seatType==1?'vip':'')}" data-seat-id="${(seat.seatId)}">
                                        <span class="front-button">${seat.seatRow}${seat.seatColumn}</span>
                                    </button>
                                </td>
                        </c:when>
                        <c:when test="${col == 4}">
                            <td class="px-4"></td>
                            <td>
                                <button type="button"
                                    class="pushable ${(seat.status==1?'pushable-sold':(seat.seatType==1?'pushable-vip':''))}"
                                    data-type="${(seat.seatType==1?'vip':'')}" data-seat-id="${(seat.seatId)}">
                                    <span class="front-button">${seat.seatRow}${seat.seatColumn}</span>
                                </button>
                            </td>
                        </c:when>
                        <c:otherwise>
                            <td>
                                <button type="button"
                                    class="pushable ${(seat.status==1?'pushable-sold':(seat.seatType==1?'pushable-vip':''))}"
                                    data-type="${(seat.seatType==1?'vip':'')}" data-seat-id="${(seat.seatId)}">
                                    <span class="front-button">${seat.seatRow}${seat.seatColumn}</span>
                                </button>
                            </td>
                        </c:otherwise>
                    </c:choose>
                    <c:if test="${col == 6}">
                        </tr>
                        <c:set var="col" value="0" />
                    </c:if>
                    <c:set var="col" value="${col+1}" />
                </c:forEach>
            </tbody>
            </tbody>
        </table>
    </div>
    <div class="row justify-content-center">
        <div class="creen pt-3 pb-2 text-center font-weight-bold">
            Screen
        </div>
    </div>
    <div class="row justify-content-center mt-3">
        <div class="note col-7 text-center">
            <div class="row">
                <div class="col-3">
                    <button class="btn-note-item btn btn-success"></button>
                    Seat is selecting
                </div>
                <div class="col-3">
                    <button class="btn-note-item btn " style="background-color: red;"></button>
                    Seat is sold
                </div>
                <div class="col-3">
                    <button class="btn-note-item btn btn-secondary"></button>
                    Seat can chose
                </div>
                <div class="col-3">
                    <button class="btn-note-item btn btn-primary"></button>
                    Seat VIP
                </div>
            </div>
        </div>
    </div>

    <div class="row my-5 pr-3 justify-content-end">
        <button class="btn btn-primary mr-3 btnControl" id="btn_Back_To_Showtime"> <i
                class="fas fa-long-arrow-alt-left"></i> Back</button>
        <button class="btn btn-primary btnControl" id="btnContinue"> Continue <i
                class="fas fa-long-arrow-alt-right"></i></button>
    </div>
