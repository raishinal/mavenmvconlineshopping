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
	<title>Contact Page</title>

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
					<h1>Contact Us</h1>
					<nav class="d-flex align-items-center">
						<a href="<c:url value="/Index"/>">Home<span class="lnr lnr-arrow-right"></span></a>
						Contact
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->

	<!--================Contact Area =================-->
	<section class="contact_area section_gap_bottom">
		<div class="container">
			<div id="mapBox" class="mapBox" data-lat="27.682450" data-lon="85.327780" data-zoom="15" data-info="Patan 44600"
			 data-mlat="27.682450" data-mlon="85.327780">
			</div>
			<div class="row">
				<div class="col-lg-3">
					<div class="contact_info">
						<div class="info_item">
							<i class="lnr lnr-home"></i>
							<h6>Lalitpur Nepal</h6>
							<p>Chakupat Patan</p>
						</div>
						<div class="info_item">
							<i class="lnr lnr-phone-handset"></i>
							<h6>+977-9862799177</h6>
							<p>Sun to Fri 9am to 6 pm</p>
						</div>
						<div class="info_item">
							<i class="lnr lnr-envelope"></i>
							<h6>company@email.com</h6>
							<p>Send us your query anytime!</p>
						</div>
					</div>
				</div>
				<div class="col-lg-9">
					<form class="row contact_form" action="contact_process.php" method="post" id="contactForm" novalidate="novalidate">
						<div class="col-md-6">
							<div class="form-group">
								<input type="text" class="form-control" id="name" name="name" placeholder="Enter your name" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter your name'">
							</div>
							<div class="form-group">
								<input type="email" class="form-control" id="email" name="email" placeholder="Enter email address" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter email address'">
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="subject" name="subject" placeholder="Enter Subject" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Subject'">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<textarea class="form-control" name="message" id="message" rows="1" placeholder="Enter Message" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Message'"></textarea>
							</div>
						</div>
						<div class="col-md-12 text-right">
							<button type="submit" value="submit" class="primary-btn">Send Message</button>
						</div>
					</form>
				</div>
			</div>
		</div>
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