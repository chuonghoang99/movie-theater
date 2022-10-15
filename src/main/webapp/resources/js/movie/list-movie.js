$(document).ready(function() {
    $("body").on("click", "#addMovie", function(e) {
        e.preventDefault();
        $.get({
            url: `/admin/movie/add-movie/`,
            async: false,
            success: function(response) {
                $("#content-page").html(response);
                $('#titlePage').text('Add Movie');
            },
        })

    });
    $("body").on("click", "a#pageIndex", function() {
        var pageIndex = $(this).attr("value");
        var searchData = $("#searchInputMovie").val();
        $.get({
            url: "/admin/movie/search",
            data: {
                pageIndex: pageIndex,
                searchData: searchData,
            },
            success: function(response) {
                $("div#table-movie").html(response);
            },
            error: function(responseError) {
                alert(JSON.stringify(responseError));
            }
        });

    });
    $("body").on("click", "a#pre", function() {
        var pageIndex = $(this).attr("value");
        var searchData = $("#searchInputMovie").val();
        $.get({
            url: "/admin/movie/search",
            data: {
                pageIndex: pageIndex,
                searchData: searchData,
            },
            success: function(response) {
                $("div#table-movie").html(response);
            },
            error: function(responseError) {
                alert(JSON.stringify(responseError));
            }
        });

    });
    $("body").on("click", "a#next", function() {
        var pageIndex = $(this).attr("value");
        var searchData = $("#searchInputMovie").val();
        $.get({
            url: "/admin/movie/search",
            data: {
                pageIndex: pageIndex,
                searchData: searchData,
            },
            success: function(response) {
                $("div#table-movie").html(response);
            },
            error: function(responseError) {
                alert(JSON.stringify(responseError));
            }
        });

    });
    $("body").on("input", "input#searchInputMovie", function() {
        var searchData = $("#searchInputMovie").val();
        $.get({
            url: "/admin/movie/search",
            data: {
                searchData: searchData,
            },
            success: function(response) {
                $("div#table-movie").html(response);
            },
            error: function(responseError) {
                alert(JSON.stringify(responseError));
            }
        });
    });
    $("body").on("click", "a#editMovie", function(e) {
        e.preventDefault();
        let movieId = $(this).attr("value");
        $.get({
            url: `/admin/movie/add-movie/`,
            data: {
                movieId: movieId,
            },
            async: false,
            success: function(response) {
                $("#content-page").html(response);
                $('#titlePage').text('Edit Movie')
            },
        })

    });
    $("body").on("click", "a#deleteMovie", function(e) {
        let cfDelete = $('#cfDeleteMovie');
        let modalDelete = $('#modalDeleteMovie');
        modalDelete.modal('hide');
        let movieId = $(this).attr('value');
        cfDelete.data('movieId', movieId);
        let columnDelete = $(this).parents().children('td');
        let movieName = columnDelete.eq(2).text();
        $('#bindMovieName').text(movieName);
        modalDelete.modal('show');
        console.log(movieId);
    });

    $("body").on("click", "#cfDeleteMovie", function(e) {
        let modalDelete = $('#modalDeleteMovie');
        let cfDelete = $('#cfDeleteMovie');
        let movieId = cfDelete.data('movieId');
        $.ajax({
            type: "delete",
            url: `/admin/movie/delete/${movieId}`,
            async: false,
            success: function(response) {
                alert(response);
            },
            error: function(data) {
                alert(data);
            },
            complete: function() {
                let rowCount = $('#tableMovieList tr').length - 1
                let pageIndex = $('ul.pagination').attr('pageIndex');
                var searchData = $("#searchInputMovie").val();
                if (rowCount === 1) {
					if(pageIndex>1){
					pageIndex--;
					}  
                }
                $.get({
                    url: `/admin/movie/search`,
                    data: {
                        pageIndex: pageIndex,
                        searchData: searchData,
                    },
                    success: function(response) {
                        $("#table-movie").html(response);
                        let pagination = $('ul.pagination');
                        let pageIndex = pagination.attr('pageIndex');
                        let numOfPages = pagination.attr('numOfPages');
                    },

                });

            }

        })
        modalDelete.modal('hide');
        $('body').removeClass('modal-open');
        $('.modal-backdrop').remove();
    });

});