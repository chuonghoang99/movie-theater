$(document).ready(function () {
    $("#ticket_selling").click(function () {
        $.get({
            url: "/admin/showtimes",
            success: function (response) {
                $(".container-fluid").html(response);
            },
            error: function (error) {
                alert("Failed!" + error);
            }
        });
    });


    $("#promotion").click(function () {
        $.get({
            url: "/admin/promotion/list",
            success: function (response) {
                $(".container-fluid").html(response);
            },
            error: function (error) {
                alert("Failed!" + error);
            }
        });
    });

    $("#movie").click(function () {
        $.get({
            url: "/admin/movie/list",
            success: function (response) {
                $(".container-fluid").html(response);
            },
            error: function (error) {
                alert("Failed!" + error);
            }
        });
    });


    $("#cinema_room").click(function () {
        $.get({
            url: "/room/list-room",
            success: function (response) {
                $(".container-fluid").html(response);
            },
            error: function (error) {
                alert("Failed!" + error);
            }
        });
    });


    $("body").on("click", "#employee, #btnBackEmployee", function (e) {
        e.preventDefault();
        document.title = "Employee Management";
        $.get({
            url: "/admin/employee/list-employee",
            success: function (response) {
                $("#content-page").html(response);
                let pagination = $('ul.pagination');
                let pageIndex = pagination.attr('pageIndex');
                let numOfPages = pagination.attr('numOfPages');
                $('li.page-item').eq(pageIndex).addClass("active");
                if (Number(pageIndex) === 1) {
                    $("a#previous").css("opacity", "0.6").prop("disabled", true);
                }
                if (pageIndex === numOfPages) {
                    $("a#next").css("opacity", "0.6").prop("disabled", true);
                }
            },

        });
    });


});

