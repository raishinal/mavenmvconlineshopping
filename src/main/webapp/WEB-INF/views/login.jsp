<%-- 
    Document   : index
    Created on : Oct 1, 2018, 3:19:13 PM
    Author     : stim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<!DOCTYPE html>
<html lang="en" class="no-js">

<head>
	<!-- Mobile Specific Meta -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Favicon-->
	<link rel="shortcut icon" href="img/fav.png">
	<!-- Author Meta -->
	<meta name="author" content="CodePixar">
	<!-- Meta Description -->
	<meta name="description" content="">
	<!-- Meta Keyword -->
	<meta name="keywords" content="">
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>My Online Shop</title>
	<!--
		CSS
		============================================= -->
        <link rel="stylesheet" href="<c:url value="/resources/front/css/linearicons.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/front/css/font-awesome.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/front/css/themify-icons.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/front/css/bootstrap.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/front/css/owl.carousel.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/front/css/nice-select.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/front/css/nouislider.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/front/css/ion.rangeSlider.css"/>" />
        <link rel="stylesheet" href="<c:url value="/resources/front/css/ion.rangeSlider.skinFlat.css"/>" />
        <link rel="stylesheet" href="<c:url value="/resources/front/css/magnific-popup.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/front/css/main.css"/>">
        
</head>

<body>

	<!-- Start Header Area -->
	<jsp:include page="header.jsp"/>
	<!-- End Header Area -->

	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>Login/Register</h1>
					<nav class="d-flex align-items-center">
						<a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
						<a href="category.html">Login/Register</a>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->

	<!--================Login Box Area =================-->
	<section class="login_box_area section_gap">
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div class="login_box_img">
                                            <img class="img-fluid" src="<c:url value="/resources/front/img/login.jpg" />"alt="">
						<div class="hover">
							<h4>New to our website?</h4>
							<p>There are advances being made in science and technology everyday, and a good example of this is the</p>
                                                        <a class="primary-btn" href="<c:url value="/Register-User"/>">Create an Account</a>
						</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="login_form_inner">
						<h3>Login to enter</h3>
						<form class="row login_form" action="<c:url value="/Login?${_csrf.parameterName}=${_csrf.token}"/>" method="post" id="contactForm" novalidate="novalidate">
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" id="name" name="username" placeholder="Username" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Username'">
							</div>
							<div class="col-md-12 form-group">
								<input type="password" class="form-control" id="name" name="password" placeholder="Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Password'">
							</div>
							<div class="col-md-12 form-group">
								<div class="creat_account">
									<input type="checkbox" id="f-option2" name="selector">
									<label for="f-option2">Keep me logged in</label>
								</div>
							</div>
							<div class="col-md-12 form-group">
								<button type="submit" value="submit" class="primary-btn">Login</button>
								<a href="#">Forgot Password?</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
        
        
	<jsp:include page="footer.jsp"/>
	<!-- End footer Area -->

        <script src="<c:url value="/resources/front/js/vendor/jquery-2.2.4.min.js"/>"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	 crossorigin="anonymous"></script>
	<script src="<c:url value="/resources/front/js/vendor/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/front/js/jquery.ajaxchimp.min.js"/>"></script>
	<script src="<c:url value="/resources/front/js/jquery.nice-select.min.js"/>"></script>
	<script src="<c:url value="/resources/front/js/jquery.sticky.js"/>"></script>
	<script src="<c:url value="/resources/front/js/nouislider.min.js"/>"></script>
	<script src="<c:url value="/resources/front/js/countdown.js"/>"></script>
	<script src="<c:url value="/resources/front/js/jquery.magnific-popup.min.js"/>"></script>
	<script src="<c:url value="/resources/front/js/owl.carousel.min.js"/>"></script>
	<!--gmaps Js-->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
	<script src="<c:url value="/resources/front/js/gmaps.min.js"/>"></script>
	<script src="<c:url value="/resources/front/js/main.js"/>"></script>
</body>

</html>
