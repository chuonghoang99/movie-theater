$(document).ready(function() {


    // function for seat type changing
    $("body").on("click", ".pushables", function() {
        if ($(this).hasClass("pushable-vip")) {
            $(this).removeClass("pushable-vip");
            $(this).attr("data-type", "");
        } else {
            $(this).addClass("pushable-vip");
            $(this).attr("data-type", "vip");
        }
    });



    // function for Save button clicked
    $("body").on("click", "#btnSaveSeat", function(e) {
        e.preventDefault();
        var listSeat = [];
        var listSeatButton = $(".pushables");
        listSeatButton.each(function() {
            seat = {};
            seat["seatId"] = $(this).attr("data-seat-id");
            if ($(this).attr("data-type") == "vip") {
                seat["seatType"] = 1;
                seat["seatPrice"] = 140000;
            } else {
                seat["seatType"] = 0;
                seat["seatPrice"] = 70000;
            }

            listSeat.push(seat);
        })
        console.log(listSeat);
        $.post({
            url: "/room/save-room-detail",
            data: JSON.stringify(listSeat),
            contentType: "application/json",
            success: function(responseData) {
                console.log(responseData);
                $(".msg").html(responseData);
                $('html, body').animate({ scrollTop: '0px' }, 1500);

            },
            error: function(responseData) {
                console.log(responseData);
                $(".msg").html(responseData);
                $('html, body').animate({ scrollTop: '0px' }, 1500);
            }
        })
    });
});