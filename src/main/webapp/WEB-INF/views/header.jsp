<%-- 
    Document   : header
    Created on : Jun 3, 2019, 1:47:05 PM
    Author     : roslm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<header class="header_area sticky-header">
		<div class="main_menu">
			<nav class="navbar navbar-expand-lg navbar-light main_box">
				<div class="container">
					<!-- Brand and toggle get grouped for better mobile display -->
                                        <a class="navbar-brand logo_h" href="<c:url value="/Index"/>"><img src="<c:url value="/resources/front/img/images.png"/>" alt=""></a>
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
					 aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
						<ul class="nav navbar-nav menu_nav ml-auto">
							<li class="nav-item active"><a class="nav-link" href="<c:url value="/Index"/>"> Home</a></li>
							<li class="nav-item active"><a class="nav-link" href="<c:url value="/Product/Category/Show"/>"> Category</a></li>

							<li class="nav-item active"><a class="nav-link" href="<c:url value="/Blog"/>">Blog</a></li>
							<li class="nav-item active"><a class="nav-link" href="<c:url value="/About"/>">About Us</a></li>
							<li class="nav-item active"><a class="nav-link" href="<c:url value="/Contact"/>">Contact Us</a></li>
                                                        
                                                            <c:if test="${status==0}">
                                                            <li class="nav-item active"><a class="nav-link" href="<c:url value="/Login"/>">Login</a></li>
                                                            </c:if>
                                                            
                                                            <c:if test="${status==1}">
                                                            <li class="nav-item active"><a class="nav-link" href="<c:url value="/User/Cart"/>">My Cart</a></li>
                                                            <li class="nav-item active"><a class="nav-link" href="<c:url value="/Logout"/>">Logout</a></li>
                                                            </c:if>
                                                            
                                                        
                                                </ul>
                                                   
						<ul class="nav navbar-nav navbar-right">
							<li class="nav-item">
								<button class="search"><span class="lnr lnr-magnifier" id="search"></span></button>
							</li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
		<div class="search_input" id="search_input_box">
			<div class="container">
				<form class="d-flex justify-content-between">
					<input type="text" class="form-control" id="search_input" placeholder="Search Here">
					<button type="submit" class="btn"></button>
					<span class="lnr lnr-cross" id="close_search" title="Close Search"></span>
				</form>
			</div>
		</div>
	</header>
