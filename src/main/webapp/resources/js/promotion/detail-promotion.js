$(document).ready(function () {
    $("body").on("click", "#btnSavePromotion", function () {
        $("#messagePromotion").html("");
        $("#titlePromotionError").html("");
        $("#titlePromotionError").attr("hidden");
        $("#startTimePromotionError").html("");
        $("#startTimePromotionError").attr("hidden");
        $("#endTimePromotionError").html("");
        $("#endTimePromotionError").attr("hidden");
        $("#discountLevelError").html("");
        $("#discountLevelError").attr("hidden");
        $("#detailPromotionError").html("");
        $("#detailPromotionError").attr("hidden");

        var count = 0;
        
		var promotionId = $("#promotionId").val();
        var title = $("#title").val();
        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();
        var discountLevel = $("#discountLevel").val();
        var detail = $("#detail").val();

        console.log(startTime);

        if (title == "") {
            $("#titlePromotionError").removeAttr("hidden");
            $("#titlePromotionError").html("Title is required");
            count++;
        }

        if (startTime == "") {
            $("#startTimePromotionError").removeAttr("hidden");
            $("#startTimePromotionError").html("Start time is required");
            count++;
        }

        if (endTime == "") {
            $("#endTimePromotionError").removeAttr("hidden");
            $("#endTimePromotionError").html("End time is required");
            count++;
        }

        if (startTime != "" && endTime != "") {
            var start = new Date(startTime);
            var end = new Date(endTime);
            if (start > end) {
                $("#startTimePromotionError").removeAttr("hidden");
                $("#startTimePromotionError").html("Start time must before end time");
                $("#endTimePromotionError").removeAttr("hidden");
                $("#endTimePromotionError").html("End time must after start time");
                count++;
            }
        }

        if (discountLevel == "") {
            $("#discountLevelError").removeAttr("hidden");
            $("#discountLevelError").html("Discount level is required");
            count++;
        }

        if (detail == "") {
            $("#detailPromotionError").removeAttr("hidden");
            $("#detailPromotionError").html("Detail is required");
            count++;
        }

        if (count == 0) {

            let formData = new FormData($('#formPromotion')[0]);

            $.post({
                async: false,
                url: "/admin/promotion/save",
                processData: false,
                contentType: false,
                data: formData,
                success: function (responseSuccess) {
                    $("#messagePromotion").html(responseSuccess.messageSuccess);
                },
                error: function (responseError) {
                    JSON.parse(JSON.stringify(responseError));
                    $("#messagePromotion").html(responseError.responseJSON.messageFailed);
                    $("#titlePromotionError").html(responseError.responseJSON.title);
                    $("#titlePromotionError").removeAttr("hidden");
                    $("#startTimePromotionError").html(responseError.responseJSON.startTime);
                    $("#startTimePromotionError").removeAttr("hidden");
                    $("#endTimePromotionError").html(responseError.responseJSON.endTime);
                    $("#endTimePromotionError").removeAttr("hidden");
                    $("#discountLevelError").html(responseError.responseJSON.discountLevel);
                    $("#discountLevelError").removeAttr("hidden");
                    $("#detailPromotionError").html(responseError.responseJSON.detail);
                    $("#detailPromotionError").removeAttr("hidden");
                },
            });
        }
    });

    $("body").on("click", "#btnBackPromotion", function () {
        $.get({
            url: "/admin/promotion/list",
            success: function (response) {
                $(".container-fluid").html(response);
            },
            error: function (error) {
                alert("Falied!" + error);
            },
        });
    });
});
