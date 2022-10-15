$(document).ready(function() {
    $("body").on("click", "button#btnSaveMovie", function() {
        $("#message").html("");
        $("#message").attr("hidden");
        $("#movieNameEnglishErr").html("");
        $("#movieNameEnglishErr").attr("hidden");
        $("#movieNameVnErr").html("");
        $("#movieNameVnErr").attr("hidden");
        $("#fromDateErr").html("");
        $("#fromDateErr").attr("hidden");
        $("#toDateErr").html("");
        $("#toDateErr").attr("hidden");
        $("#actorErr").html("");
        $("#actorErr").attr("hidden");
        $("#movieProductCompanyErr").attr("hidden");
        $("#directorErr").html("");
        $("#directorErr").attr("hidden");
        $("#durationErr").html("");
        $("#durationErr").attr("hidden");
        $("#versionErr").html("");
        $("#versionErr").attr("hidden");
        $("#typesErr").html("");
        $("#typesErr").attr("hidden");
        $("#schedulesErr").html("");
        $("#schedulesErr").attr("hidden");
        $("#contentErr").html("");
        $("#contentErr").attr("hidden");
        var count = 0;
        var typeIds = "";
        $("input[name='types']:checked").each(function() {
            if (typeIds == "") {
                typeIds = $(this).val();
            } else {
                typeIds = typeIds + "," + $(this).val();
            }
        });
        var scheduleIds = "";

        $("input[name='schedules']:checked").each(function() {
            if (scheduleIds == "") {
                scheduleIds = $(this).val();
            } else {
                scheduleIds = scheduleIds + "," + $(this).val();
            }
        });
        var movieNameEnglish = $("#movieNameEnglish").val();
        var movieNameVn = $("#movieNameVn").val();
        var fromDate = $("#fromDate").val();
        var toDate = $("#toDate").val();
        var actor = $("#actor").val();
        var movieProductCompany = $("#movieProductCompany").val();
        var director = $("#director").val();
        var duration = $("#duration").val();
        var version = $("#version").val();
        var content = $("#contentMovie").val();
        if (movieNameEnglish == "") {
            $("#movieNameEnglishErr").removeAttr("hidden");
            $("#movieNameEnglishErr").html("Movie Name English is required");
            count++;
        }
        if (movieNameVn == "") {
            $("#movieNameVnErr").removeAttr("hidden");
            $("#movieNameVnErr").html("Movie Name VN is required");
            count++;
        }
        if (fromDate == "") {
            $("#fromDateErr").removeAttr("hidden");
            $("#fromDateErr").html("From Date is required");
            count++;
        }
        if (toDate == "") {
            $("#toDateErr").removeAttr("hidden");
            $("#toDateErr").html("To Date is required");
            count++;
        }
        if (actor == "") {
            $("#actorErr").removeAttr("hidden");
            $("#actorErr").html("Actor is required");
            count++;
        }
        if (movieProductCompany == "") {
            $("#movieProductCompanyErr").removeAttr("hidden");
            $("#movieProductCompanyErr").html("Movie Company is required");
            count++;
        }
        if (director == "") {
            $("#directorErr").removeAttr("hidden");
            $("#directorErr").html("Director is required");
            count++;
        }
        if (duration == "") {
            $("#durationErr").removeAttr("hidden");
            $("#durationErr").html("Duration is required");
            count++;
        }
        if (version == "") {
            $("#versionErr").removeAttr("hidden");
            $("#versionErr").html("Version is required");
            count++;
        }
        if (content == "") {
            $("#contentErr").removeAttr("hidden");
            $("#contentErr").html("Content is required");
            count++;
        }
        if (typeIds == "") {
            $("#typesErr").removeAttr("hidden");
            $("#typesErr").html("You must choose at least one type");
            count++;
        }
        if (scheduleIds == "") {
            $("#schedulesErr").removeAttr("hidden");
            $("#schedulesErr").html("You must choose at least one schedule");
            count++;
        }
        if (fromDate != "" && toDate != "") {
            var from = new Date(fromDate);
            var to = new Date(toDate);
            if (from > to) {
                $("#fromDateErr").removeAttr("hidden");
                $("#fromDateErr").html("From date must be before to date");
                $("#toDateErr").removeAttr("hidden");
                $("#toDateErr").html("From date must after toDate");
                count++;
            }
        }
        var formData = new FormData($('#formMovie')[0]);
        formData.append('typeIds', typeIds);
        formData.append('scheduleIds', scheduleIds);

        if (count == 0) {
            $.post({
                url: "/admin/movie/save-movie",
                contentType: false, // added
                processData: false, // added
                data: formData,
                success: function(responseData) {

                    $("#message").html(responseData.messageSuccess).css('color', 'blue');
                },
                error: function(responseError) {
                    alert(JSON.stringify(responseError));
                    $("#message").html(responseError.responseJSON.messageFail).css('color', 'red');
                    $("#movieNameVnErr").html(responseError.responseJSON.movieNameEnglish);
                    $("#movieNameEnglishErr").html(responseError.responseJSON.movieNameVn);
                    $("#fromDateEr").html(responseError.responseJSON.fromDate);
                    $("#toDateErr").html(responseError.responseJSON.toDate);
                    $("#actorErr").html(responseError.responseJSON.actor);
                    $("#movieProductCompanyErr").html(responseError.responseJSON.movieProductCompany);
                    $("#directorErr").html(responseError.responseJSON.director);
                    $("#durationErr").html(responseError.responseJSON.duration);
                    $("#versionErr").html(responseError.responseJSON.version);

                }
            });
        }

    });
    $("body").on("click", "button#btnBackMovie", function() {
        $.get({
            url: "/admin/movie/list",
            async: false,
            success: function(responseData) {
                $("#content-page").html(responseData);

            },
            error: function(responseError) {
                alert(JSON.stringify(responseError));
            }
        });

    });


});