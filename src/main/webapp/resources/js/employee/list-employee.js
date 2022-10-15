$(document).ready(function () {

    const body = $('body');
   // const baseURL = 'http://localhost:8080';

    // Click add new  - employee management
    body.on("click", "#addEmployee", function (e) {
        e.preventDefault();
        $.get({
            url: "/admin/employee/detail-employee",
            async: false,
            success: function (response) {
                $("#content-page").html(response);
                $('#titlePage').text('Add Employee')
            },
        })
    });

    // Click edit icon  - employee management
    body.on("click", "#editEmployee", function (e) {
        let employeeId = $(this).attr('value');
        console.log(employeeId);
        $("#content-page").load("../views/employee/detail-employee.jsp", function () {
            $('#titlePage').text('Edit Employee')
            $('input[type=password]').css("opacity", "0.7").prop("readonly", true)
            $('input#email').css("opacity", "0.7").prop("readonly", true)
            $.get({
                url: `/admin/employee/${employeeId}`,
                success: function (response) {
                    JSON.parse(JSON.stringify(response))
                    if (response.status === 'FIND-OK') {
                        let account = response.data.account;
                        $('input[name=employeeId]').val(response.data.employeeId);
                        $('input[name=accountId]').val(account.accountId);
                        $('input[name=userName]').val(account.userName);
                        $('input[name=password]').val('**').hide();
                        $('label[for=password]').hide();
                        $('label[for=cfPassword]').hide();
                        $('input[name=cfPassword]').val('**').hide();
                        $('input[name=fullName]').val(account.fullName);

                        // remove default check gender = M
                        let $radiosGender = $('input:radio[name=gender]');
                        $radiosGender.filter('[value=M]').prop('checked', false);

                        if (account.gender === 'F') {
                            $radiosGender.filter('[value=F]').prop('checked', true);
                        } else {
                            $radiosGender.filter('[value=M]').prop('checked', true);
                        }
                        // 09-12-1999
                        $('input[name=dateOfBirth]').val(account.dateOfBirth);
                        $('input[name=identityCard]').val(account.identityCard);
                        $('input[name=email]').val(account.email);
                        $('input[name=address]').val(account.address);
                        $('input[name=phoneNumber]').val(account.phoneNumber);

                        $('label[for=file]').addClass('d-block').text('Image (click for change)');
                        let fileImage = $('#file');

                        fileImage.hide();
                        let srcImage = `/resources/img/employee/${account.image}`;

                        fileImage.after(`
                            <embed src=${srcImage} class="rounded-circle" width="70" height="70">`
                        );
                        let reader = new FileReader();
                    }
                },
                error: function (response) {
                    JSON.parse(JSON.stringify(response))
                },
            });
        });

    });

    body.on('click', 'embed', function (e) {
        $('#file').click();
    });

    // Click delete icon  - employee management
    body.on("click", "a#deleteEmployee", function (e) {
        let cfDelete = $('#cfDeleteEmployee');
        let modalDelete = $('#modalDeleteEmployee');
        modalDelete.modal('hide');
        let employeeId = $(this).attr('value');
        cfDelete.data('employeeId', employeeId);
        let columnDelete = $(this).parents().children('td');
        let userName = columnDelete.eq(1).text();
        //alert($('span#accountLogin').text());
        if (userName === $('span#accountLogin').text()) {
            alert('Bạn không thể xóa tài khoản khi đang đăng nhập !!!')
            return false;
        }
        $('#bindEmpName').text(userName);
        modalDelete.modal('show');
    });

    body.on('click', '#cfDeleteEmployee', function (e) {
        let modalDelete = $('#modalDeleteEmployee');
        let cfDelete = $('#cfDeleteEmployee');
        let employeeId = cfDelete.data('employeeId')
        // console.log(employeeId);
        // let columnDelete = cfDelete.data('columnDelete');
        // columnDelete.remove();
        let deleteUrl = `/admin/employee/${employeeId}`;
        $.ajax({
            type: "DELETE",
            url: `/admin/employee/${employeeId}`,
            success: function (data) {
                modalDelete.modal('hide');
            },
            error: function (data) {
                modalDelete.modal('hide');
                alert('Account is currently in use. Delete fail');
            },
            complete: function () {
                let rowCount = $('#tableEmployeeList tr').length - 1
                let pageSize = $("#selectPageSize").val();
                let pageIndex = $('ul.pagination').attr('pageIndex');
                if (rowCount === 1) {
                    pageIndex--;
                }
                $.get({
                    url: `/admin/employee/list-employee/filter`,
                    data: {
                        pageIndex: pageIndex,
                        pageSize: pageSize,
                        dataSearch: '',
                    },
                    success: function (response) {
                        $("#content-table").html(response);
                        //$("#inputSearch").val(dataSearch);
                        $("#selectPageSize").val(pageSize);
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
            }
        });
        modalDelete.modal('hide');
        $('body').removeClass('modal-open');
        $('.modal-backdrop').remove();
    });

    // Click change select
    body.on('change', '#selectPageSize', function (e) {
        let dataSearch = $("#inputSearch").val();
        let pageSize = $("#selectPageSize").val();
        let pageIndex = 1;
        $.get({
            url: "/admin/employee/list-employee/filter",
            async: false,
            data: {
                pageIndex: pageIndex,
                pageSize: pageSize,
                dataSearch: dataSearch,
            },
            success: function (response) {
                $("#content-table").html(response);
                $("#inputSearch").val(dataSearch);
                $("#selectPageSize").val(pageSize);
                pageIndex = $('ul.pagination').attr('pageIndex');
                let numOfPages = $('ul.pagination').attr('numOfPages');
                $('li.page-item').eq(pageIndex).addClass("active");
                if (Number(pageIndex) === 1) {
                    $("a#previous").css("opacity", "0.6").prop("disabled", true);
                }
                if (pageIndex === numOfPages) {
                    $("a#next").css("opacity", "0.6").prop("disabled", true);

                }
            },
        })
    });

    // search
    body.on("input", '#inputSearch', function (e) {
        e.preventDefault();
        let dataSearch = $("#inputSearch").val();
        let pageIndex = 1;
        let pageSize = $("#selectPageSize").val();
        $.ajax({
            url: "/admin/employee/list-employee/filter",
            data: {
                pageIndex: pageIndex,
                pageSize: pageSize,
                dataSearch: dataSearch
            },
            success: function (response) {
                $("#content-table").html(response);
                $("#inputSearch").val(dataSearch);
                $("#selectPageSize").val(pageSize);

                pageIndex = $('ul.pagination').attr('pageIndex');
                let numOfPages = $('ul.pagination').attr('numOfPages');
                $('li.page-item').eq(pageIndex).addClass("active");
                if (Number(pageIndex) === 1) {
                    $("a#previous").css("opacity", "0.6").prop("disabled", true);
                }
                if (pageIndex === numOfPages) {
                    $("a#next").css("opacity", "0.6").prop("disabled", true);

                }
            },
            error: function (response) {
            }
        });
    });

    // Click previous button
    body.on("click", "a#previous", function (e) {
        e.preventDefault();
        let pageIndex = $('ul.pagination').attr('pageIndex');
        pageIndex = (pageIndex === 1) ? 1 : pageIndex - 1;
        let dataSearch = $("#inputSearch").val();
        let pageSize = $("#selectPageSize").val();

        $.get({
            url: "/admin/employee/list-employee/filter",
            async: false,
            data: {
                dataSearch: dataSearch,
                pageIndex: pageIndex,
                pageSize: pageSize,
            },
            success: function (response) {
                $("#content-table").html(response);
                $("#inputSearch").val(dataSearch);
                $("#selectPageSize").val(pageSize);

                let pageIndex = $('ul.pagination').attr('pageIndex');
                let numOfPages = $('ul.pagination').attr('numOfPages');
                $('li.page-item').eq(pageIndex).addClass("active");
                if (Number(pageIndex) === 1) {
                    $("a#previous").css("opacity", "0.6");
                    $("a#previous").prop("disabled", true);
                }
                if (pageIndex === numOfPages) {
                    $("a#next").css("opacity", "0.6");
                    $("a#next").prop("disabled", true);
                }

            },
        })

    });

    // Click page index
    body.on("click", "a#pageIndex", function (e) {
        e.preventDefault();
        let dataSearch = $("#inputSearch").val();
        let pageIndex = $(this).attr("value");
        let pageSize = $("#selectPageSize").val();
        $.get({
            url: "/admin/employee/list-employee/filter",
            async: false,
            data: {
                dataSearch: dataSearch,
                pageIndex: pageIndex,
                pageSize: pageSize,
            },
            success: function (response) {
                $("#content-table").html(response);
                $("#inputSearch").val(dataSearch);
                $("#selectPageSize").val(pageSize);

                pageIndex = $('ul.pagination').attr('pageIndex');
                let numOfPages = $('ul.pagination').attr('numOfPages');
                $('li.page-item').eq(pageIndex).addClass("active");
                if (Number(pageIndex) === 1) {
                    $("a#previous").css("opacity", "0.6").prop("disabled", true);

                }
                if (pageIndex === numOfPages) {
                    $("a#next").css("opacity", "0.6").prop("disabled", true);

                }
            },

        })

    });

    // Click next button
    body.on("click", "a#next", function (e) {
        e.preventDefault();
        let pageIndex = $('ul.pagination').attr('pageIndex');
        pageIndex = pageIndex - (-1);
        let dataSearch = $("#inputSearch").val();
        let pageSize = $("#selectPageSize").val();

        $.get({
            url: "/admin/employee/list-employee/filter",
            async: false,
            data: {
                dataSearch: dataSearch,
                pageIndex: pageIndex,
                pageSize: pageSize,
            },
            success: function (response) {
                $("#content-table").html(response);
                $("#inputSearch").val(dataSearch);
                $("#selectPageSize").val(pageSize);

                pageIndex = $('ul.pagination').attr('pageIndex');
                let numOfPages = $('ul.pagination').attr('numOfPages');
                $('li.page-item').eq(pageIndex).addClass("active");
                if (Number(pageIndex) === 1) {
                    $("a#previous").css("opacity", "0.6").prop("disabled", true);

                }
                if (pageIndex === numOfPages) {
                    $("a#next").css("opacity", "0.6").prop("disabled", true);

                }
            },
        })

    });
});