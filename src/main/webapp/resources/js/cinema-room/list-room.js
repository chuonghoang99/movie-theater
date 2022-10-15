$(document).ready(function() {

    $("body").on("change keydown", "#searchInput", function() {
        console.log("pressed key");
        var searchField = $(this).val();
        $.ajax({
            type: "GET",
            url: "/room/list-room",
            data: {
                searchField: searchField,
            },
            dataType: "text",
            success: function(response) {
                $(".container-fluid").html(response);

                // set mouse input pointer to the end of text
                var searchInput = $('#searchInput');
                var strLength = searchInput.val().length * 2;
                searchInput.focus();
                searchInput[0].setSelectionRange(strLength, strLength);
            },
            error: function(responseData) {

            }
        })
    });

    // Click in a page with number
    $("body").on("click", ".page-link.pageWithNum", function(e) {
        e.preventDefault();
        var pageIndex = $(this).attr("id");
        var searchField = $("#searchData").val();
        $.get({
            url: "/room/list-room",
            data: {
                pageIndex: pageIndex,
                searchField: searchField,
            },
            success: function(responseData) {
                $(".container-fluid").html(responseData);
            },
            error: function(responseError) {}
        });

    });
    // Click in Previous or Next button
    $("body").on("click", ".page-link.pageWithoutNum", function(e) {
        e.preventDefault();
        var pageIndex;
        if ($(this).attr("value") == "Previous") {
            pageIndex = parseInt($(".currentPage").attr("id")) - 1;
        }
        if ($(this).attr("value") == "Next") {
            pageIndex = parseInt($(".currentPage").attr("id")) + 1;
        }
        var searchField = $("#searchData").val();
        $.get({
            url: "/room/list-room",
            data: {
                pageIndex: pageIndex,
                searchField: searchField,
            },
            success: function(responseData) {
                $(".container-fluid").html(responseData);
            },
            error: function(responseError) {

            }
        });

    });

    $("body").on("mouseenter", ".room-image", function() {
        var roomId = $(this).attr("value");
        $.get({
            url: "/room/room-image",
            data: {
                roomId: roomId,
            },
            success: function(responseData) {
                var roomNameImage = $(".room-image");
                roomNameImage.attr("data-original-title", `<img class="imgToolTip" src='` + responseData + "' />");
                console.log(responseData);
            },
            error: function(responseError) {

            }
        });
    });

    $(function() {
        $('[data-toggle="tooltip"]').tooltip()
    })

    // function for Seat detail link clicked
    $("body").on("click", ".btnUpdateRoom", function(e) {
        e.preventDefault();
        var roomId = $(this).attr("value");
        $.get({
            url: "/room/seat-detail",
            data: {
                roomId: roomId,
            },
            success: function(responseData) {
                $(".container-fluid").html(responseData);
            },
            error: function(responseData) {}
        })
    });

    // function for Add new button clicked
    $("body").on("click", ".btnAddRoom", function(e) {
        e.preventDefault();

        $.get({
            url: "/room/add-room",
            success: function(responseData) {
                $(".container-fluid").html(responseData);
            },
            error: function(responseData) {

            }
        })
    });

});