$(document).ready(function () {
    $("body").on("click", "#editPromotion", function () {
        let promotionId = $(this).attr("value");
        $.get({
            url: `/admin/promotion/showPromotionForm`,
            data: {
                promotionId: $(this).attr("value"),
            },
            success: function (response) {
                $(".container-fluid").html(response);
            },
            error: function (responseError) {
                alert(JSON.stringify(responseError));
            },
        });
    });

    $("body").on("click", "#btnAddPromotion", function () {
        $.get({
            url: "/admin/promotion/showPromotionForm",
            success: function (response) {
                $(".container-fluid").html(response);
            },
            error: function (responseError) {
                alert(JSON.stringify(responseError));
            },
        });
    });

    $("body").on("change", "#selectPageSizePromotion", function () {
        var searchDataPromotion = $("#searchInputPromotion").val();
        var pageSizePromotion = $("#selectPageSizePromotion").val();
        console.log(pageSizePromotion);
        $.get({
            url: "/admin/promotion/search",
            data: {
                pageSizePromotion: pageSizePromotion,
                searchDataPromotion: searchDataPromotion,
            },
            success: function (response) {
                $("div#table-promotion").html(response);
            },
            error: function (responseError) {
                alert(JSON.stringify(responseError));
            },
        });
    });

    $("body").on("click", "a.pagingPromotion", function () {
        let pageIndexPromotion = $(this).attr("value");
        let searchDataPromotion = $("#searchInputPromotion").val();
        let pageSizePromotion = $("#selectPageSizePromotion").val();
        console.log(pageIndexPromotion);
        $.get({
            url: "/admin/promotion/search",
            data: {
                pageIndexPromotion: pageIndexPromotion,
                pageSizePromotion: pageSizePromotion,
                searchDataPromotion: searchDataPromotion,
            },
            success: function (response) {
                $("div#table-promotion").html(response);
            },
            error: function (responseError) {
                alert(JSON.stringify(responseError));
            },
        });
    });

    $("body").on("input", "input#searchInputPromotion", function () {
        var searchDataPromotion = $("#searchInputPromotion").val();
        var pageSizePromotion = $("#selectPageSizePromotion").val();
        $.get({
            url: "/admin/promotion/search",
            data: {
                searchDataPromotion: searchDataPromotion,
                pageSizePromotion: pageSizePromotion,
                pageIndexPromotion: 1,
            },
            success: function (response) {
                $("div#table-promotion").html(response);
            },
            error: function (responseError) {
                alert(JSON.stringify(responseError));
            },
        });
    });

    $("body").on("click", "#deletePromotion", function (e) {
        let id = $(this).attr("value");
        console.log(id);
        e.preventDefault();
        $("#btnAccept").data("delete-id", id);
        $("#modalConfirmDelete").modal("show")
    });

    $("body").on("click", "#btnAccept", function (e) {
        e.preventDefault();
        $("#modalConfirmDelete").modal("hide");
        let promotionId = $(this).data("delete-id");
        console.log(promotionId);
        $.ajax({
            type: "DELETE",
            url: `promotion/delete/${promotionId}`,
            success: function (response) {
                let message = response;
                let searchDataPromotion = $("#searchInputPromotion").val();
                let pageSizePromotion = $("#selectPageSizePromotion").val();
                let pageIndex = $('ul.pagination').attr('pageIndex');
                
                $.get({
                    url: "/admin/promotion/search",
                    data: {
                        searchDataPromotion: searchDataPromotion,
                        pageSizePromotion: pageSizePromotion,
                        pageIndexPromotion: pageIndex,
                    },
                    success: function (response) {
                        $("div#table-promotion").html(response);
                        $("#message").html(message);
                    },
                    error: function (responseError) {
                        alert(JSON.stringify(responseError));
                    },
                });
            },
            error: function (error) {
                $("#message").html(response);
                alert(JSON.stringify(error));
            },
        })
    });
});
