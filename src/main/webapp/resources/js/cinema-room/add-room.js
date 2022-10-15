// $(document).ready(function() {
//     console.log("begin adding validate function");
//     $("form#cinemaRoomAddForm").validate({
//         rules: {
//             roomName: {
//                 required: true,
//                 maxlength: 30,
//                 minlength: 5,
//             },
//             roomImage: {
//                 extension: "png|jpeg|jpg",
//             },
//         },
//         messages: {
//             roomName: {
//                 required: "Room name must not be blank",
//                 maxlength: "Room name must be less than 30 character",
//                 minlength: "Room name must be greater than 5 character",
//             },
//             roomImage: {
//                 extension: "File must be JPEG or PNG"
//             }
//         },
//         errorPlacement: function(error, element) {
//             error.addClass("invalid-feedback");

//             if (element.prop("type") === "checkbox") {
//                 error.insertAfter(element.next("label"));
//             } else {
//                 error.insertAfter(element);
//             }
//         },
//         highlight: function(element) {
//             $(element).addClass("is-invalid").removeClass("is-valid");
//         },
//         unhighlight: function(element) {
//             $(element).addClass("is-valid").removeClass("is-invalid");
//         },
//         submitHandler: function() {
//             var formData = new FormData(this);
//             $.post({
//                 url: "/room/room-saving",
//                 cache: false,
//                 contentType: false,
//                 processData: false,
//                 data: formData,
//                 success: function(responseData) {
//                     $("#mainMethodMessage").html(responseData.methodMessage);
//                     $("#mainMethodMessage").css("color", "blue");
//                     $("#roomNameMessage").html("");
//                 },
//                 error: function(responseData) {
//                     $("#mainMethodMessage").html(responseData.responseJSON.methodMessage);
//                     $("#roomNameMessage").html(responseData.responseJSON.roomNameMessage);
//                     $("#mainMethodMessage").css("color", "red");
//                 },
//             })
//         },

//     });
// });

$("body").on("submit", "#cinemaRoomAddForm", (function(e) {
    e.preventDefault();
    console.log(formData);
    var formData = new FormData(this);
    $.post({
        url: "/room/room-saving",
        cache: false,
        contentType: false,
        processData: false,
        data: formData,
        success: function(responseData) {
            $("#mainMethodMessage").html(responseData.methodMessage);
            $("#mainMethodMessage").css("color", "blue");
            $("#roomNameMessage").html("");
        },
        error: function(responseData) {
            $("#mainMethodMessage").html(responseData.responseJSON.methodMessage);
            $("#roomNameMessage").html(responseData.responseJSON.roomNameMessage);
            $("#mainMethodMessage").css("color", "red");
        },
    })
}));


$("body").on("click", "#btnBackRoom", (function() {
    $.get({
        url: "/room/list-room",
        success: function(response) {
            $(".container-fluid").html(response);
        },
        error: function(error) {
            alert("Failed!" + error);
        }
    });
}));

$("body").on("change", "#roomImage", (function() {
    const file = this.files[0];
    if (file) {
        let reader = new FileReader();
        reader.onload = function(event) {
            $("#imgPreview").attr("src", event.target.result);
        };
        reader.readAsDataURL(file);
    }
}));