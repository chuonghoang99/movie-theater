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
    <link rel="icon" type="image/png" href="../resources/dashboard/icon/favicon-32x32.png" sizes="32x32">
    <link rel="apple-touch-icon" href="../resources/dashboard/icon/favicon-32x32.png">

    <meta name="description" content="Online Movies, TV Shows & Cinema HTML Template">
    <meta name="keywords" content="">
    <meta name="author" content="Dmitry Volkov">
    <title>Cinema</title>

</head>
<body class="body">

<!-- header -->
<header class="header">
    <div class="header__wrap">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="header__content">
                        <!-- header logo -->
                        <a href="/welcome" class="header__logo">
                            <img src="../resources/dashboard/img/logo.svg" alt="">
                        </a>
                        <!-- end header logo -->

                        <!-- header nav -->
                        <ul class="header__nav">
                            <!-- dropdown -->
                            <li class="header__nav-item">
                                <a class="dropdown-toggle header__nav-link" href="#" role="button" id="dropdownMenuHome" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Home <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M17,9.17a1,1,0,0,0-1.41,0L12,12.71,8.46,9.17a1,1,0,0,0-1.41,0,1,1,0,0,0,0,1.42l4.24,4.24a1,1,0,0,0,1.42,0L17,10.59A1,1,0,0,0,17,9.17Z"></svg></a>

                                <ul class="dropdown-menu header__dropdown-menu" aria-labelledby="dropdownMenuHome">
                                    <li><a href="#">Home 1</a></li>
                                    <li><a href="#">Home 2</a></li>
                                </ul>
                            </li>
                            <!-- end dropdown -->

                            <li class="header__nav-item">
                                <a href="#" class="header__nav-link">About</a>
                            </li>

                            <!-- dropdown -->
                            <li class="dropdown header__nav-item">
                                <a class="dropdown-toggle header__nav-link header__nav-link--more" href="#" role="button" id="dropdownMenuMore" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M12,10a2,2,0,1,0,2,2A2,2,0,0,0,12,10ZM5,10a2,2,0,1,0,2,2A2,2,0,0,0,5,10Zm14,0a2,2,0,1,0,2,2A2,2,0,0,0,19,10Z"></svg>
                                </a>

                                <ul class="dropdown-menu header__dropdown-menu" aria-labelledby="dropdownMenuMore">
                                    <li><a href="#">Profile</a></li>
                                    <li><a href="#">Sign Up</a></li>
                                    <li><a href="#">Forgot password</a></li>
                                    <li><a href="#">Privacy Policy</a></li>
                                    <li><a href="#">Contacts</a></li>
                                </ul>
                            </li>
                            <!-- end dropdown -->
                        </ul>
                        <!-- end header nav -->

                        <!-- header auth -->
                        <div class="header__auth">
                            <button class="header__search-btn" aria-label="search btn" type="button">
                                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M21.71,20.29,18,16.61A9,9,0,1,0,16.61,18l3.68,3.68a1,1,0,0,0,1.42,0A1,1,0,0,0,21.71,20.29ZM11,18a7,7,0,1,1,7-7A7,7,0,0,1,11,18Z"></svg>
                            </button>

                            <!-- dropdown -->
                            <div class="dropdown header__lang">
                                <a class="dropdown-toggle header__nav-link" href="#" role="button" id="dropdownMenuLang" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">EN</a>

                                <ul class="dropdown-menu header__dropdown-menu" aria-labelledby="dropdownMenuLang">
                                    <li><a href="#">English</a></li>
                                    <li><a href="#">Vietnameese</a></li>
                                </ul>
                            </div>
                            <!-- end dropdown -->

                            <ul class="header__nav">
                                <!-- dropdown -->
                                <li class="header__nav-item">
                                    <a class="dropdown-toggle header__nav-link" role="button" id="dropdownMenuHome" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M17,9.17a1,1,0,0,0-1.41,0L12,12.71,8.46,9.17a1,1,0,0,0-1.41,0,1,1,0,0,0,0,1.42l4.24,4.24a1,1,0,0,0,1.42,0L17,10.59A1,1,0,0,0,17,9.17Z"></svg>
                                        ${accountLogin.userName }<img style="height: 2rem; width: 2rem; border-radius: 50%; margin-left: 8px" class="img-profile rounded-circle border-radius" src="/resources/img/employee/${accountLogin.image}">
                                    </a>

                                    <ul class="dropdown-menu header__dropdown-menu" aria-labelledby="dropdownMenuHome">
                                        <li><a href="#">Edit Profile</a></li>
                                        <li><a href="/logout">Logout</a></li>

                                    </ul>
                                </li>
                                <!-- end dropdown -->


                                <!-- end dropdown -->
                            </ul>
                        </div>
                        <!-- end header auth -->



                        <!-- header menu btn -->
                        <button class="header__btn" type="button">
                            <span></span>
                            <span></span>
                            <span></span>
                        </button>
                        <!-- end header menu btn -->
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- header search -->
    <form action="#" class="header__search">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="header__search-content">
                        <input type="text" placeholder="I'm looking for...">
                        <button type="button">Search</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <!-- end header search -->
</header>
<!-- end header -->

<!-- home -->
<section class="home">
    <!-- home bg -->
    <div class="owl-carousel home__bg">
        <div class="item home__cover" data-bg="img/home/home__bg.jpg"></div>
        <div class="item home__cover" data-bg="img/home/home__bg2.jpg"></div>
        <div class="item home__cover" data-bg="img/home/home__bg3.jpg"></div>
        <div class="item home__cover" data-bg="img/home/home__bg4.jpg"></div>
    </div>
    <!-- end home bg -->

    <div class="container">
        <div class="row">
            <div class="col-12">
                <h1 class="home__title"><b>NEW ITEMS</b> OF THIS SEASON</h1>

                <button class="home__nav home__nav--prev" aria-label="prev card" type="button">
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M17,11H9.41l3.3-3.29a1,1,0,1,0-1.42-1.42l-5,5a1,1,0,0,0-.21.33,1,1,0,0,0,0,.76,1,1,0,0,0,.21.33l5,5a1,1,0,0,0,1.42,0,1,1,0,0,0,0-1.42L9.41,13H17a1,1,0,0,0,0-2Z"></svg>
                </button>
                <button class="home__nav home__nav--next" aria-label="next card" type="button">
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M17.92,11.62a1,1,0,0,0-.21-.33l-5-5a1,1,0,0,0-1.42,1.42L14.59,11H7a1,1,0,0,0,0,2h7.59l-3.3,3.29a1,1,0,0,0,0,1.42,1,1,0,0,0,1.42,0l5-5a1,1,0,0,0,.21-.33A1,1,0,0,0,17.92,11.62Z"></svg>
                </button>
            </div>

            <div class="col-12">
                <div class="owl-carousel home__carousel">
                    <!-- card -->
                    <div class="card card--big">
                        <a href="details1.html" class="card__cover">
                            <img src="../resources/dashboard/img/covers/cover.jpg" alt="">
                            <span class="card__play">
								<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
							</span>
                        </a>
                        <div class="card__content">
                            <h3 class="card__title"><a href="#">I Dream in Another Language</a></h3>
                            <span class="card__category">
								<a href="#">Action</a>
								<a href="#">Triler</a>
							</span>
                            <span class="card__rate"> 8.4</span>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="card card--big">
                        <a href="details1.html" class="card__cover">
                            <img src="../resources/dashboard/img/covers/cover2.jpg" alt="">
                            <span class="card__play">
								<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
							</span>
                        </a>
                        <div class="card__content">
                            <h3 class="card__title"><a href="#">Benched</a></h3>
                            <span class="card__category">
								<a href="#">Comedy</a>
							</span>
                            <span class="card__rate"> 7.1</span>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="card card--big">
                        <a href="details1.html" class="card__cover">
                            <img src="../resources/dashboard/img/covers/cover3.jpg" alt="">
                            <span class="card__play">
								<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
							</span>
                        </a>
                        <div class="card__content">
                            <h3 class="card__title"><a href="#">Whitney</a></h3>
                            <span class="card__category">
								<a href="#">Romance</a>
								<a href="#">Drama</a>
							</span>
                            <span class="card__rate"> 6.3</span>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="card card--big">
                        <a href="details1.html" class="card__cover">
                            <img src="../resources/dashboard/img/covers/cover4.jpg" alt="">
                            <span class="card__play">
								<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
							</span>
                        </a>
                        <div class="card__content">
                            <h3 class="card__title"><a href="#">Blindspotting</a></h3>
                            <span class="card__category">
								<a href="#">Comedy</a>
								<a href="#">Drama</a>
							</span>
                            <span class="card__rate"> 7.9</span>
                        </div>
                    </div>
                    <!-- end card -->
                    <!-- card -->
                    <div class="card card--big">
                        <a href="details1.html" class="card__cover">
                            <img src="../resources/dashboard/img/covers/cover4.jpg" alt="">
                            <span class="card__play">
								<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
							</span>
                        </a>
                        <div class="card__content">
                            <h3 class="card__title"><a href="#">Blindspotting</a></h3>
                            <span class="card__category">
								<a href="#">Comedy</a>
								<a href="#">Drama</a>
							</span>
                            <span class="card__rate"> 7.9</span>
                        </div>
                    </div>
                    <!-- end card -->
                </div>
            </div>
        </div>
    </div>
</section>
<!-- end home -->

<!-- content -->
<section class="content">
    <div class="content__head">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <!-- content title -->
                    <h2 class="content__title">New items</h2>
                    <!-- end content title -->

                    <!-- content tabs nav -->
                    <ul class="nav nav-tabs content__tabs" id="content__tabs" role="tablist">
                        <li class="nav-item" role="presentation">
                            <a class="nav-link active" data-toggle="tab" href="#tab-1" role="tab" aria-controls="tab-1" aria-selected="true">NEW RELEASES</a>
                        </li>

                        <li class="nav-item" role="presentation">
                            <a class="nav-link" data-toggle="tab" href="#tab-2" role="tab" aria-controls="tab-2" aria-selected="false">MOVIES</a>
                        </li>

                        <li class="nav-item" role="presentation">
                            <a class="nav-link" data-toggle="tab" href="#tab-3" role="tab" aria-controls="tab-3" aria-selected="false">TV SERIES</a>
                        </li>

                        <li class="nav-item" role="presentation">
                            <a class="nav-link" data-toggle="tab" href="#tab-4" role="tab" aria-controls="tab-4" aria-selected="false">CARTOONS</a>
                        </li>
                    </ul>
                    <!-- end content tabs nav -->

                    <!-- content mobile tabs nav -->
                    <div class="content__mobile-tabs" id="content__mobile-tabs">
                        <div class="content__mobile-tabs-btn dropdown-toggle" role="navigation" id="mobile-tabs" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <input type="button" value="New items">
                            <span></span>
                        </div>

                        <div class="content__mobile-tabs-menu dropdown-menu" aria-labelledby="mobile-tabs">
                            <ul class="nav nav-tabs" role="tablist">
                                <li class="nav-item"><a class="nav-link active" id="1-tab" data-toggle="tab" href="#tab-1" role="tab" aria-controls="tab-1" aria-selected="true">NEW RELEASES</a></li>

                                <li class="nav-item"><a class="nav-link" id="2-tab" data-toggle="tab" href="#tab-2" role="tab" aria-controls="tab-2" aria-selected="false">MOVIES</a></li>

                                <li class="nav-item"><a class="nav-link" id="3-tab" data-toggle="tab" href="#tab-3" role="tab" aria-controls="tab-3" aria-selected="false">TV SERIES</a></li>

                                <li class="nav-item"><a class="nav-link" id="4-tab" data-toggle="tab" href="#tab-4" role="tab" aria-controls="tab-4" aria-selected="false">CARTOONS</a></li>
                            </ul>
                        </div>
                    </div>
                    <!-- end content mobile tabs nav -->
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <!-- content tabs -->
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade show active" id="tab-1" role="tabpanel" aria-labelledby="1-tab">
                <div class="row row--grid">
                    <!-- card -->
                    <div class="col-6 col-sm-12 col-lg-6">
                        <div class="card card--list">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>

                            <div class="card__content">
                                <h3 class="card__title"><a href="#">I Dream in Another Language</a></h3>
                                <span class="card__category">
									<a href="#">Action</a>
									<a href="#">Triler</a>
								</span>

                                <div class="card__wrap">
                                    <span class="card__rate"> 8.4</span>

                                    <ul class="card__list">
                                        <li>HD</li>
                                        <li>16+</li>
                                    </ul>
                                </div>

                                <div class="card__description">
                                    <p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-12 col-lg-6">
                        <div class="card card--list">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover2.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>

                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Benched</a></h3>
                                <span class="card__category">
									<a href="#">Comedy</a>
								</span>

                                <div class="card__wrap">
                                    <span class="card__rate"> 7.1</span>

                                    <ul class="card__list">
                                        <li>FHD</li>
                                        <li>18+</li>
                                    </ul>
                                </div>

                                <div class="card__description">
                                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-12 col-lg-6">
                        <div class="card card--list">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover3.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>

                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Whitney</a></h3>
                                <span class="card__category">
									<a href="#">Romance</a>
									<a href="#">Drama</a>
									<a href="#">Music</a>
								</span>

                                <div class="card__wrap">
                                    <span class="card__rate"> 6.3</span>

                                    <ul class="card__list">
                                        <li>HD</li>
                                        <li>12+</li>
                                    </ul>
                                </div>

                                <div class="card__description">
                                    <p>It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-12 col-lg-6">
                        <div class="card card--list">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover4.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>

                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Blindspotting</a></h3>
                                <span class="card__category">
									<a href="#">Comedy</a>
									<a href="#">Drama</a>
								</span>

                                <div class="card__wrap">
                                    <span class="card__rate"> 7.9</span>

                                    <ul class="card__list">
                                        <li>HD</li>
                                        <li>16+</li>
                                    </ul>
                                </div>

                                <div class="card__description">
                                    <p>Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-12 col-lg-6">
                        <div class="card card--list">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover5.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>

                            <div class="card__content">
                                <h3 class="card__title"><a href="#">I Dream in Another Language</a></h3>
                                <span class="card__category">
									<a href="#">Action</a>
									<a href="#">Triler</a>
								</span>

                                <div class="card__wrap">
                                    <span class="card__rate"> 8.4</span>

                                    <ul class="card__list">
                                        <li>HD</li>
                                        <li>12+</li>
                                    </ul>
                                </div>

                                <div class="card__description">
                                    <p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-12 col-lg-6">
                        <div class="card card--list">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover6.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>

                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Benched</a></h3>
                                <span class="card__category">
									<a href="#">Comedy</a>
								</span>

                                <div class="card__wrap">
                                    <span class="card__rate"> 7.1</span>

                                    <ul class="card__list">
                                        <li>HD</li>
                                        <li>16+</li>
                                    </ul>
                                </div>

                                <div class="card__description">
                                    <p>All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->
                </div>
            </div>

            <div class="tab-pane fade" id="tab-2" role="tabpanel" aria-labelledby="2-tab">
                <div class="row row--grid">
                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">I Dream in Another Language</a></h3>
                                <span class="card__category">
									<a href="#">Action</a>
									<a href="#">Triler</a>
								</span>
                                <span class="card__rate">8.4</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover2.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Benched</a></h3>
                                <span class="card__category">
									<a href="#">Comedy</a>
								</span>
                                <span class="card__rate">7.1</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover3.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Whitney</a></h3>
                                <span class="card__category">
									<a href="#">Romance</a>
									<a href="#">Drama</a>
									<a href="#">Music</a>
								</span>
                                <span class="card__rate">6.3</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover4.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Blindspotting</a></h3>
                                <span class="card__category">
									<a href="#">Comedy</a>
									<a href="#">Drama</a>
								</span>
                                <span class="card__rate">7.9</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover5.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">I Dream in Another Language</a></h3>
                                <span class="card__category">
									<a href="#">Action</a>
									<a href="#">Triler</a>
								</span>
                                <span class="card__rate">8.4</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover6.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Benched</a></h3>
                                <span class="card__category">
									<a href="#">Comedy</a>
								</span>
                                <span class="card__rate">7.1</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover6.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Whitney</a></h3>
                                <span class="card__category">
									<a href="#">Romance</a>
									<a href="#">Drama</a>
									<a href="#">Music</a>
								</span>
                                <span class="card__rate">6.3</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover5.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Blindspotting</a></h3>
                                <span class="card__category">
									<a href="#">Comedy</a>
									<a href="#">Drama</a>
								</span>
                                <span class="card__rate">7.9</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover4.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">I Dream in Another Language</a></h3>
                                <span class="card__category">
									<a href="#">Action</a>
									<a href="#">Triler</a>
								</span>
                                <span class="card__rate">8.4</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover3.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Benched</a></h3>
                                <span class="card__category">
									<a href="#">Comedy</a>
								</span>
                                <span class="card__rate">7.1</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover2.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Whitney</a></h3>
                                <span class="card__category">
									<a href="#">Romance</a>
									<a href="#">Drama</a>
									<a href="#">Music</a>
								</span>
                                <span class="card__rate">6.3</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Blindspotting</a></h3>
                                <span class="card__category">
									<a href="#">Comedy</a>
									<a href="#">Drama</a>
								</span>
                                <span class="card__rate">7.9</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->
                </div>
            </div>

            <div class="tab-pane fade" id="tab-3" role="tabpanel" aria-labelledby="3-tab">
                <div class="row row--grid">
                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover2.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Benched</a></h3>
                                <span class="card__category">
									<a href="#">Comedy</a>
								</span>
                                <span class="card__rate">7.1</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover3.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Whitney</a></h3>
                                <span class="card__category">
									<a href="#">Romance</a>
									<a href="#">Drama</a>
									<a href="#">Music</a>
								</span>
                                <span class="card__rate">6.3</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover4.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Blindspotting</a></h3>
                                <span class="card__category">
									<a href="#">Comedy</a>
									<a href="#">Drama</a>
								</span>
                                <span class="card__rate">7.9</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover5.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">I Dream in Another Language</a></h3>
                                <span class="card__category">
									<a href="#">Action</a>
									<a href="#">Triler</a>
								</span>
                                <span class="card__rate">8.4</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover6.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Benched</a></h3>
                                <span class="card__category">
									<a href="#">Comedy</a>
								</span>
                                <span class="card__rate">7.1</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">I Dream in Another Language</a></h3>
                                <span class="card__category">
									<a href="#">Action</a>
									<a href="#">Triler</a>
								</span>
                                <span class="card__rate">8.4</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Blindspotting</a></h3>
                                <span class="card__category">
									<a href="#">Comedy</a>
									<a href="#">Drama</a>
								</span>
                                <span class="card__rate">7.9</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover6.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Whitney</a></h3>
                                <span class="card__category">
									<a href="#">Romance</a>
									<a href="#">Drama</a>
									<a href="#">Music</a>
								</span>
                                <span class="card__rate">6.3</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover5.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Blindspotting</a></h3>
                                <span class="card__category">
									<a href="#">Comedy</a>
									<a href="#">Drama</a>
								</span>
                                <span class="card__rate">7.9</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover4.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">I Dream in Another Language</a></h3>
                                <span class="card__category">
									<a href="#">Action</a>
									<a href="#">Triler</a>
								</span>
                                <span class="card__rate">8.4</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover3.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Benched</a></h3>
                                <span class="card__category">
									<a href="#">Comedy</a>
								</span>
                                <span class="card__rate">7.1</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover2.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Whitney</a></h3>
                                <span class="card__category">
									<a href="#">Romance</a>
									<a href="#">Drama</a>
									<a href="#">Music</a>
								</span>
                                <span class="card__rate">6.3</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->
                </div>
            </div>

            <div class="tab-pane fade" id="tab-4" role="tabpanel" aria-labelledby="4-tab">
                <div class="row row--grid">
                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover3.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Whitney</a></h3>
                                <span class="card__category">
									<a href="#">Romance</a>
									<a href="#">Drama</a>
									<a href="#">Music</a>
								</span>
                                <span class="card__rate">6.3</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover4.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Blindspotting</a></h3>
                                <span class="card__category">
									<a href="#">Comedy</a>
									<a href="#">Drama</a>
								</span>
                                <span class="card__rate">7.9</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover5.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">I Dream in Another Language</a></h3>
                                <span class="card__category">
									<a href="#">Action</a>
									<a href="#">Triler</a>
								</span>
                                <span class="card__rate">8.4</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover6.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Benched</a></h3>
                                <span class="card__category">
									<a href="#">Comedy</a>
								</span>
                                <span class="card__rate">7.1</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">I Dream in Another Language</a></h3>
                                <span class="card__category">
									<a href="#">Action</a>
									<a href="#">Triler</a>
								</span>
                                <span class="card__rate">8.4</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover2.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Benched</a></h3>
                                <span class="card__category">
									<a href="#">Comedy</a>
								</span>
                                <span class="card__rate">7.1</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover6.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Whitney</a></h3>
                                <span class="card__category">
									<a href="#">Romance</a>
									<a href="#">Drama</a>
									<a href="#">Music</a>
								</span>
                                <span class="card__rate">6.3</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover5.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Blindspotting</a></h3>
                                <span class="card__category">
									<a href="#">Comedy</a>
									<a href="#">Drama</a>
								</span>
                                <span class="card__rate">7.9</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover2.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Whitney</a></h3>
                                <span class="card__category">
									<a href="#">Romance</a>
									<a href="#">Drama</a>
									<a href="#">Music</a>
								</span>
                                <span class="card__rate">6.3</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Blindspotting</a></h3>
                                <span class="card__category">
									<a href="#">Comedy</a>
									<a href="#">Drama</a>
								</span>
                                <span class="card__rate">7.9</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover4.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">I Dream in Another Language</a></h3>
                                <span class="card__category">
									<a href="#">Action</a>
									<a href="#">Triler</a>
								</span>
                                <span class="card__rate">8.4</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->

                    <!-- card -->
                    <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                        <div class="card">
                            <a href="details1.html" class="card__cover">
                                <img src="../resources/dashboard/img/covers/cover3.jpg" alt="">
                                <span class="card__play">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
								</span>
                            </a>
                            <div class="card__content">
                                <h3 class="card__title"><a href="#">Benched</a></h3>
                                <span class="card__category">
									<a href="#">Comedy</a>
								</span>
                                <span class="card__rate">7.1</span>
                            </div>
                        </div>
                    </div>
                    <!-- end card -->
                </div>
            </div>
        </div>
        <!-- end content tabs -->
    </div>
</section>
<!-- end content -->

<!-- expected premiere -->
<section class="section section--bg" data-bg="img/section/section.jpg">
    <div class="container">
        <div class="row">
            <!-- section title -->
            <div class="col-12">
                <h2 class="section__title">Expected premiere</h2>
            </div>
            <!-- end section title -->
        </div>

        <div class="row row--grid">
            <!-- card -->
            <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                <div class="card">
                    <a href="details1.html" class="card__cover">
                        <img src="../resources/dashboard/img/covers/cover.jpg" alt="">
                        <span class="card__play">
							<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
						</span>
                    </a>
                    <div class="card__content">
                        <h3 class="card__title"><a href="#">I Dream in Another Language</a></h3>
                        <span class="card__category">
							<a href="#">Action</a>
							<a href="#">Triler</a>
						</span>
                        <span class="card__rate">8.4</span>
                    </div>
                </div>
            </div>
            <!-- end card -->

            <!-- card -->
            <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                <div class="card">
                    <a href="details1.html" class="card__cover">
                        <img src="../resources/dashboard/img/covers/cover3.jpg" alt="">
                        <span class="card__play">
							<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
						</span>
                    </a>
                    <div class="card__content">
                        <h3 class="card__title"><a href="#">Benched</a></h3>
                        <span class="card__category">
							<a href="#">Comedy</a>
						</span>
                        <span class="card__rate">7.1</span>
                    </div>
                </div>
            </div>
            <!-- end card -->

            <!-- card -->
            <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                <div class="card">
                    <a href="details1.html" class="card__cover">
                        <img src="../resources/dashboard/img/covers/cover2.jpg" alt="">
                        <span class="card__play">
							<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
						</span>
                    </a>
                    <div class="card__content">
                        <h3 class="card__title"><a href="#">Whitney</a></h3>
                        <span class="card__category">
							<a href="#">Romance</a>
							<a href="#">Drama</a>
							<a href="#">Music</a>
						</span>
                        <span class="card__rate">6.3</span>
                    </div>
                </div>
            </div>
            <!-- end card -->

            <!-- card -->
            <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                <div class="card">
                    <a href="details1.html" class="card__cover">
                        <img src="../resources/dashboard/img/covers/cover6.jpg" alt="">
                        <span class="card__play">
							<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
						</span>
                    </a>
                    <div class="card__content">
                        <h3 class="card__title"><a href="#">Blindspotting</a></h3>
                        <span class="card__category">
							<a href="#">Comedy</a>
							<a href="#">Drama</a>
						</span>
                        <span class="card__rate">7.9</span>
                    </div>
                </div>
            </div>
            <!-- end card -->

            <!-- card -->
            <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                <div class="card">
                    <a href="details1.html" class="card__cover">
                        <img src="../resources/dashboard/img/covers/cover4.jpg" alt="">
                        <span class="card__play">
							<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
						</span>
                    </a>
                    <div class="card__content">
                        <h3 class="card__title"><a href="#">I Dream in Another Language</a></h3>
                        <span class="card__category">
							<a href="#">Action</a>
							<a href="#">Triler</a>
						</span>
                        <span class="card__rate">8.4</span>
                    </div>
                </div>
            </div>
            <!-- end card -->

            <!-- card -->
            <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                <div class="card">
                    <a href="details1.html" class="card__cover">
                        <img src="../resources/dashboard/img/covers/cover5.jpg" alt="">
                        <span class="card__play">
							<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M18.54,9,8.88,3.46a3.42,3.42,0,0,0-5.13,3V17.58A3.42,3.42,0,0,0,7.17,21a3.43,3.43,0,0,0,1.71-.46L18.54,15a3.42,3.42,0,0,0,0-5.92Zm-1,4.19L7.88,18.81a1.44,1.44,0,0,1-1.42,0,1.42,1.42,0,0,1-.71-1.23V6.42a1.42,1.42,0,0,1,.71-1.23A1.51,1.51,0,0,1,7.17,5a1.54,1.54,0,0,1,.71.19l9.66,5.58a1.42,1.42,0,0,1,0,2.46Z"></svg>
						</span>
                    </a>
                    <div class="card__content">
                        <h3 class="card__title"><a href="#">Benched</a></h3>
                        <span class="card__category">
							<a href="#">Comedy</a>
						</span>
                        <span class="card__rate">7.1</span>
                    </div>
                </div>
            </div>
            <!-- end card -->

            <!-- section btn -->
            <div class="col-12">
                <a href="#" class="section__btn">Show more</a>
            </div>
            <!-- end section btn -->
        </div>
    </div>
</section>
<!-- end expected premiere -->
<!-- footer -->
<footer class="footer">
    <div class="container">
        <div class="row">
            <!-- footer list -->
            <div class="col-12 col-md-3">
                <h6 class="footer__title">Download Our App</h6>
                <ul class="footer__app">
                    <li><a href="#"><img src="../resources/dashboard/img/Download_on_the_App_Store_Badge.svg" alt=""></a></li>
                    <li><a href="#"><img src="../resources/dashboard/img/google-play-badge.png" alt=""></a></li>
                </ul>
            </div>
            <!-- end footer list -->

            <!-- footer list -->
            <div class="col-6 col-sm-4 col-md-3">
                <h6 class="footer__title">Resources</h6>
                <ul class="footer__list">
                    <li><a href="#">About Us</a></li>
                    <li><a href="#">Pricing Plan</a></li>
                    <li><a href="#">Help Center</a></li>
                </ul>
            </div>
            <!-- end footer list -->

            <!-- footer list -->
            <div class="col-6 col-sm-4 col-md-3">
                <h6 class="footer__title">Legal</h6>
                <ul class="footer__list">
                    <li><a href="#">Terms of Use</a></li>
                    <li><a href="#">Privacy Policy</a></li>
                    <li><a href="#">Security</a></li>
                </ul>
            </div>
            <!-- end footer list -->

            <!-- footer list -->
            <div class="col-12 col-sm-4 col-md-3">
                <h6 class="footer__title">Contact</h6>
                <ul class="footer__list">
                    <li><a href="tel:88002345678">099999999999</a></li>
                    <li><a href="mailto:support@flixgo.com">support@soict.com</a></li>
                </ul>
                <ul class="footer__social">
                    <li class="facebook"><a href="#"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M20.9,2H3.1A1.1,1.1,0,0,0,2,3.1V20.9A1.1,1.1,0,0,0,3.1,22h9.58V14.25h-2.6v-3h2.6V9a3.64,3.64,0,0,1,3.88-4,20.26,20.26,0,0,1,2.33.12v2.7H17.3c-1.26,0-1.5.6-1.5,1.47v1.93h3l-.39,3H15.8V22h5.1A1.1,1.1,0,0,0,22,20.9V3.1A1.1,1.1,0,0,0,20.9,2Z"></svg></a></li>
                    <li class="instagram"><a href="#"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M17.34,5.46h0a1.2,1.2,0,1,0,1.2,1.2A1.2,1.2,0,0,0,17.34,5.46Zm4.6,2.42a7.59,7.59,0,0,0-.46-2.43,4.94,4.94,0,0,0-1.16-1.77,4.7,4.7,0,0,0-1.77-1.15,7.3,7.3,0,0,0-2.43-.47C15.06,2,14.72,2,12,2s-3.06,0-4.12.06a7.3,7.3,0,0,0-2.43.47A4.78,4.78,0,0,0,3.68,3.68,4.7,4.7,0,0,0,2.53,5.45a7.3,7.3,0,0,0-.47,2.43C2,8.94,2,9.28,2,12s0,3.06.06,4.12a7.3,7.3,0,0,0,.47,2.43,4.7,4.7,0,0,0,1.15,1.77,4.78,4.78,0,0,0,1.77,1.15,7.3,7.3,0,0,0,2.43.47C8.94,22,9.28,22,12,22s3.06,0,4.12-.06a7.3,7.3,0,0,0,2.43-.47,4.7,4.7,0,0,0,1.77-1.15,4.85,4.85,0,0,0,1.16-1.77,7.59,7.59,0,0,0,.46-2.43c0-1.06.06-1.4.06-4.12S22,8.94,21.94,7.88ZM20.14,16a5.61,5.61,0,0,1-.34,1.86,3.06,3.06,0,0,1-.75,1.15,3.19,3.19,0,0,1-1.15.75,5.61,5.61,0,0,1-1.86.34c-1,.05-1.37.06-4,.06s-3,0-4-.06A5.73,5.73,0,0,1,6.1,19.8,3.27,3.27,0,0,1,5,19.05a3,3,0,0,1-.74-1.15A5.54,5.54,0,0,1,3.86,16c0-1-.06-1.37-.06-4s0-3,.06-4A5.54,5.54,0,0,1,4.21,6.1,3,3,0,0,1,5,5,3.14,3.14,0,0,1,6.1,4.2,5.73,5.73,0,0,1,8,3.86c1,0,1.37-.06,4-.06s3,0,4,.06a5.61,5.61,0,0,1,1.86.34A3.06,3.06,0,0,1,19.05,5,3.06,3.06,0,0,1,19.8,6.1,5.61,5.61,0,0,1,20.14,8c.05,1,.06,1.37.06,4S20.19,15,20.14,16ZM12,6.87A5.13,5.13,0,1,0,17.14,12,5.12,5.12,0,0,0,12,6.87Zm0,8.46A3.33,3.33,0,1,1,15.33,12,3.33,3.33,0,0,1,12,15.33Z"></svg></a></li>
                    <li class="twitter"><a href="#"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M22,5.8a8.49,8.49,0,0,1-2.36.64,4.13,4.13,0,0,0,1.81-2.27,8.21,8.21,0,0,1-2.61,1,4.1,4.1,0,0,0-7,3.74A11.64,11.64,0,0,1,3.39,4.62a4.16,4.16,0,0,0-.55,2.07A4.09,4.09,0,0,0,4.66,10.1,4.05,4.05,0,0,1,2.8,9.59v.05a4.1,4.1,0,0,0,3.3,4A3.93,3.93,0,0,1,5,13.81a4.9,4.9,0,0,1-.77-.07,4.11,4.11,0,0,0,3.83,2.84A8.22,8.22,0,0,1,3,18.34a7.93,7.93,0,0,1-1-.06,11.57,11.57,0,0,0,6.29,1.85A11.59,11.59,0,0,0,20,8.45c0-.17,0-.35,0-.53A8.43,8.43,0,0,0,22,5.8Z"></svg></a></li>
                    <li class="vk"><a href="#"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M15.07294,2H8.9375C3.33331,2,2,3.33331,2,8.92706V15.0625C2,20.66663,3.32294,22,8.92706,22H15.0625C20.66669,22,22,20.67706,22,15.07288V8.9375C22,3.33331,20.67706,2,15.07294,2Zm3.07287,14.27081H16.6875c-.55206,0-.71875-.44793-1.70831-1.4375-.86463-.83331-1.22919-.9375-1.44794-.9375-.30206,0-.38544.08332-.38544.5v1.3125c0,.35419-.11456.5625-1.04162.5625a5.69214,5.69214,0,0,1-4.44794-2.66668A11.62611,11.62611,0,0,1,5.35419,8.77081c0-.21875.08331-.41668.5-.41668H7.3125c.375,0,.51044.16668.65625.55212.70831,2.08331,1.91669,3.89581,2.40625,3.89581.1875,0,.27081-.08331.27081-.55206V10.10413c-.0625-.97913-.58331-1.0625-.58331-1.41663a.36008.36008,0,0,1,.375-.33337h2.29169c.3125,0,.41662.15625.41662.53125v2.89587c0,.3125.13544.41663.22919.41663.1875,0,.33331-.10413.67706-.44788a11.99877,11.99877,0,0,0,1.79169-2.97919.62818.62818,0,0,1,.63544-.41668H17.9375c.4375,0,.53125.21875.4375.53125A18.20507,18.20507,0,0,1,16.41669,12.25c-.15625.23956-.21875.36456,0,.64581.14581.21875.65625.64582,1,1.05207a6.48553,6.48553,0,0,1,1.22912,1.70837C18.77081,16.0625,18.5625,16.27081,18.14581,16.27081Z"></svg></a></li>
                </ul>
            </div>
            <!-- end footer list -->

            <!-- footer copyright -->
            <div class="col-12">
                <div class="footer__copyright">
                    <small>©ChuongHoang 09/2022</small>

                    <ul>
                        <li>Terms of Use</a></li>
                        <li>Privacy Policy</a></li>
                    </ul>
                </div>
            </div>
            <!-- end footer copyright -->
        </div>
    </div>
</footer>
<!-- end footer -->

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="/logout">Logout</a>
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