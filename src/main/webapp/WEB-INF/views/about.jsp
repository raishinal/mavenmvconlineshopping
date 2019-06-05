<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

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
	<title>About Us</title>

	<!--
            CSS
            ============================================= -->
        <link rel="stylesheet" href="<c:url value="/resources/front/css/linearicons.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/front/css/owl.carousel.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/front/css/themify-icons.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/front/css/font-awesome.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/front/css/nice-select.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/front/css/nouislider.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/front/css/bootstrap.css"/>">
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
					<h1>About Us</h1>
					<nav class="d-flex align-items-center">
						<a href="<c:url value="/Index"/>">Home<span class="lnr lnr-arrow-right"></span></a>
						About
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->

	<!--================Contact Area =================-->
	<section class="features-area">
            <p>Every Thing About the Company In this paragraph</p>
	</section>
	<!--================Contact Area =================-->

	<!-- start footer Area -->
        <jsp:include page="footer.jsp"/>
	<!-- End footer Area -->

	<!--================Contact Success and Error message Area =================-->
<!--	<div id="success" class="modal modal-message fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<i class="fa fa-close"></i>
					</button>
					<h2>Thank you</h2>
					<p>Your message is successfully sent...</p>
				</div>
			</div>
		</div>
	</div>-->

	<!-- Modals error -->

<!--	<div id="error" class="modal modal-message fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<i class="fa fa-close"></i>
					</button>
					<h2>Sorry !</h2>
					<p> Something went wrong </p>
				</div>
			</div>
		</div>
	</div>-->
	<!--================End Contact Success and Error message Area =================-->


        <script src="<c:url value="/resources/front/js/vendor/jquery-2.2.4.min.js"/>"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	 crossorigin="anonymous"></script>
         <script src="<c:url value="/resources/front/js/vendor/bootstrap.min.js"/>"></script>
         <script src="<c:url value="/resources/front/js/jquery.ajaxchimp.min.js"/>"></script>
         <script src="<c:url value="/resources/front/js/jquery.nice-select.min.js"/>"></script>
         <script src="<c:url value="/resources/front/js/jquery.sticky.js"/>"></script>
         <script src="<c:url value="/resources/front/js/nouislider.min.js"/>"></script>
         <script src="<c:url value="/resources/front/js/jquery.magnific-popup.min.js"/>"></script>
         <script src="<c:url value="/resources/front/js/owl.carousel.min.js"/>"></script>
	<!--gmaps Js-->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
        <script src="<c:url value="/resources/front/js/gmaps.min.js"/>"></script>
        <script src="<c:url value="/resources/front/js/main.js"/>"></script>
</body>

</html>