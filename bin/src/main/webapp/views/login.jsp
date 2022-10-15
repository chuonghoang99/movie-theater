<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Login</title>

<!-- Custom fonts for this template-->
<link href="/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

	<div class="container">

		<!-- Outer Row -->
		<div class="row justify-content-center">

			<div class="col-xl-10 col-lg-12 col-md-9 mt-5">

				<div class="card o-hidden border-0 shadow-lg my-5">
					<div class="card-body p-0">

						<div class="row">
							<div class="col-lg-4">

								<img src="/resources/img/logo.png" alt="logo"
									style="width: 400px; height: 400px;">

							</div>
							<div class="col-lg-8">
								<div class="p-5">
									<div class="text-center">
										<h1 class="h4 text-gray-900 mb-4">LOGIN</h1>

										<c:if test="${param.error == true}">
											<h6 class="text-danger">User or password is incorrect !
											</h6>
										</c:if>

										<form class="user" action="/j_spring_security_check"
											method='POST'>
											<div class="form-group mt-1">
												<input type="text" class="form-control form-control-user"
													name="username" aria-describedby="emailHelp"
													placeholder="Enter username">
											</div>
											<div class="form-group">
												<input type="password"
													class="form-control form-control-user" name="password"
													placeholder="Password">
											</div>

											<button type="submit"
												class="btn btn-primary btn-user btn-block">Login</button>

										</form>
										<hr>
										<div class="text-center">
											<a class="small" href="forgot-password.html">Forgot
												Password?</a>
										</div>
										<div class="text-center">
											<a class="small" href="register.html">Dont't have an
												account yet? Register now!</a>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>

				</div>

			</div>

		</div>

		<!-- Bootstrap core JavaScript-->

		<script src="/resources/vendor/jquery/jquery.min.js"></script>
		<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

		<!-- Core plugin JavaScript-->
		<script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

		<!-- Custom scripts for all pages-->
		<script src="/resources/js/sb-admin-2.min.js"></script>
</body>

</html>
