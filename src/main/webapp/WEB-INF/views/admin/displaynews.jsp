<%-- 
    Document   : index
    Created on : Oct 1, 2018, 3:19:13 PM
    Author     : stim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Admin Dashboard</title>

<link href="<c:url value="/resources/back/css/bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/back/css/datepicker3.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/back/css/styles.css"/>" rel="stylesheet">

<!--Icons-->
<script src="<c:url value="/resources/back/js/lumino.glyphs.js"/>"></script>

<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->

</head>

<body>
    <jsp:include page="header.jsp"/>
    
    <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="<c:url value="/Admin/Home"/>"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
				<li class="active">News/Show</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">News</h1>
			</div>
		</div><!--/.row-->
				
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Show All News</div>
					<div class="panel-body">
						<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">All News</div>
					<div class="panel-body">
						<div class="col-lg-12">
							  <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="cat-table">
                                <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Title</th>
                                        <th>Tags</th>
                                        <th>Description</th>
                                        <th>Date</th>
                                        <th>Status</th>
                                        <th>Edit</th>
                                        <th>Delete</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${newslist}" var="cat">
                                        <tr>
                                            <td>${cat.id}</td>
                                            <td>${cat.title}</td>
                                            <td>${cat.tags}</td>
                                            <td>${cat.description}</td>
                                            <td>${cat.now}</td>
                                            <td>${cat.status}</td>
                                            <td><a href="<c:url value="/Admin/News/Edit/${cat.id}"/>">Edit</a></td>
                                            <td><a href="<c:url value="/Admin/News/Delete/${cat.id}"/>" onclick="return confirm('Are you sure?')">Delete</a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                           
                        </div>
                             
                             
                             
                             
                             
                             
                             
                             	</div>
							
						
					</div>
				</div>
			</div><!-- /.col-->
							
						
					</div>
				</div>
			</div><!-- /.col-->
		</div><!-- /.row -->
		
	</div><!--/.main-->





        <script src="<c:url value="/resources/back/js/jquery-1.11.1.min.js"/>"></script>
        <script src="<c:url value="/resources/back/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/resources/back/js/chart.min.js"/>"></script>
        <script src="<c:url value="/resources/back/js/chart-data.js"/>"></script>
        <script src="<c:url value="/resources/back/js/easypiechart.js"/>"></script>
	<script src="<c:url value="/resources/back/js/easypiechart-data.js"/>"></script>
            <script src="<c:url value="/resources/back/js/bootstrap-datepicker.js"/>"></script>
	<script>
		$('#calendar').datepicker({
		});

		!function ($) {
		    $(document).on("click","ul.nav li.parent > a > span.icon", function(){          
		        $(this).find('em:first').toggleClass("glyphicon-minus");      
		    }); 
		    $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function () {
		  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function () {
		  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
		})
	</script>	
</body>

</html>
