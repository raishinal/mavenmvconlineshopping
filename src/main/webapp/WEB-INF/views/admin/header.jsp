<%-- 
    Document   : header
    Created on : Oct 7, 2018, 2:06:04 PM
    Author     : stim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<c:url value="/Admin/Home"/>"><span>Admin</span>Pannel</a>
				<ul class="user-menu">
					<li class="dropdown pull-right">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> ${user} <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Profile</a></li>
							<li><a href="#"><svg class="glyph stroked gear"><use xlink:href="#stroked-gear"></use></svg> Settings</a></li>
							<li><a href="<c:url value="/Logout"/>"><svg class="glyph stroked cancel"><use xlink:href="#stroked-cancel"></use></svg> Logout</a></li>
						</ul>
					</li>
				</ul>
			</div>
							
		</div><!-- /.container-fluid -->
	</nav>
		
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<ul class="nav menu">
			<li class="active"><a href="<c:url value="/Admin/Home"/>"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-dashboard-dial"></use></svg> Dashboard</a></li>
			<li class="active"><a href="<c:url value="/Admin/Category/Add"/>"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-chevron-right"></use></svg>Add Category</a></li>
			<li class="active"><a href="<c:url value="/Admin/Category/Show"/>"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-chevron-right"></use></svg> Display Category</a></li>
			<li class="active"><a href="<c:url value="/Admin/Product/Add"/>"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-chevron-right"></use></svg> Add Product</a></li>
			<li class="active"><a href="<c:url value="/Admin/Product/Show"/>"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-chevron-right"></use></svg> Display Products</a></li>
			<li class="active"><a href="<c:url value="/Admin/Blog/Add"/>"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-chevron-right"></use></svg> Add Blog</a></li>
			<li class="active"><a href="<c:url value="/Admin/Blog/Show"/>"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-chevron-right"></use></svg> Display Blogs</a></li>
			<li class="active"><a href="<c:url value="/Admin/Register-user"/>"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-chevron-right"></use></svg> Register User</a></li>
			<li class="active"><a href="<c:url value="/Admin/UserManagement"/>"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-chevron-right"></use></svg> User Management</a></li>
			<li class="active"><a href="<c:url value="/Admin/News/Add"/>"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-chevron-right"></use></svg> Add News</a></li>
			<li class="active"><a href="<c:url value="/Admin/News/Show"/>"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-chevron-right"></use></svg> Display News</a></li>
			<li class="active"><a href="<c:url value="/Admin/Order"/>"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-chevron-right"></use></svg>Order Management</a></li>
			
                        
                        
                        
			
			
               </ul>

	</div><!--/.sidebar-->
		