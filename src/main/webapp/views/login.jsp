<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- CSS -->
    <link rel="stylesheet" href="/resources/dashboard/css/bootstrap-reboot.min.css">
    <link rel="stylesheet" href="/resources/dashboard/css/bootstrap-grid.min.css">
    <link rel="stylesheet" href="/resources/dashboard/css/owl.carousel.min.css">
    <link rel="stylesheet" href="/resources/dashboard/css/jquery.mCustomScrollbar.min.css">
    <link rel="stylesheet" href="/resources/dashboard/css/nouislider.min.css">
    <link rel="stylesheet" href="/resources/dashboard/css/plyr.css">
    <link rel="stylesheet" href="/resources/dashboard/css/photoswipe.css">
    <link rel="stylesheet" href="/resources/dashboard/css/default-skin.css">
    <link rel="stylesheet" href="/resources/dashboard/css/main.css">

    <!-- Favicons -->
    <link rel="icon" type="image/png" href="icon/favicon-32x32.png" sizes="32x32">
    <link rel="apple-touch-icon" href="icon/favicon-32x32.png">

    <meta name="description" content="Online Movies, TV Shows & Cinema HTML Template">
    <meta name="keywords" content="">
    <meta name="author" content="Dmitry Volkov">
    <title>Login</title>


</head>
<body class="body">

<div class="sign section--bg" data-bg="/resources/dashboard/img/section/section.jpg">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="sign__content">

                    <!-- authorization form -->
                    <form class="user sign__form" action="/j_spring_security_check"
                          method='POST'>
                        <a href="" class="sign__logo">
                            <img src="/resources/dashboard/img/logo.svg" alt="">
                        </a>
                        <c:if test="${param.incorrect == true}">
                            <h6 style="color: #FFFFFF; font-size: 13.5px">User / password is invalid.
                                Please try again!</h6>
                        </c:if>

                        <c:if test="${param.locked == true}">
                            <h6 style="color: #FFFFFF; font-size: 13.5px">Account has been locked</h6>
                        </c:if>

                        <div class="sign__group">
                            <input name="username" type="text" class="sign__input" placeholder="Enter user">
                        </div>

                        <div class="sign__group">
                            <input name="password" type="password" class="sign__input" placeholder="Password">
                        </div>

                        <div class="sign__group sign__group--checkbox">
                            <input id="remember" name="remember" type="checkbox" checked="checked">
                            <label for="remember">Remember Me</label>
                        </div>

                        <button class="sign__btn" type="submit">Login</button>

                        <span class="sign__text">Don't have an account? <a href="#">Sign up!</a></span>

                        <span class="sign__text"><a href="#">Forgot password?</a></span>
                    </form>
                    <!-- end authorization form -->
                </div>
            </div>
        </div>
    </div>
</div>

<!-- JS -->
<script src="/resources/dashboard/js/jquery-3.6.0.min.js"></script>
<script src="/resources/dashboard/js/bootstrap.bundle.min.js"></script>
<script src="/resources/dashboard/js/owl.carousel.min.js"></script>
<script src="/resources/dashboard/js/jquery.mousewheel.min.js"></script>
<script src="/resources/dashboard/js/jquery.mCustomScrollbar.min.js"></script>
<script src="/resources/dashboard/js/wNumb.js"></script>
<script src="/resources/dashboard/js/nouislider.min.js"></script>
<script src="/resources/dashboard/js/plyr.min.js"></script>
<script src="/resources/dashboard/js/jquery.morelines.min.js"></script>
<script src="/resources/dashboard/js/photoswipe.min.js"></script>
<script src="/resources/dashboard/js/photoswipe-ui-default.min.js"></script>
<script src="/resources/dashboard/js/main.js"></script>
</body>
</html>