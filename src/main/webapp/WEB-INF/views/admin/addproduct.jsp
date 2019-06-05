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
				<li class="active">Product/Add</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Product</h1>
			</div>
		</div><!--/.row-->
				
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Add Product</div>
					<div class="panel-body">
						<div class="col-md-6">
							 
                             
                             <form role="form" action="<c:url value="/Admin/Product/Add?${_csrf.parameterName}=${_csrf.token}"/>" method="post" enctype="multipart/form-data">
                                        
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                        <div class="form-group">
                                            <label>Product Name</label>
                                            <input class="form-control" type="text" placeholder="Product name here..." name="name">
                                             <p class="help-block">${error_title}</p>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Stock</label>
                                            <input class="form-control" type="number" placeholder="How many in stock" name="stock">
                                             <p class="help-block">${error_title}</p>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Product Price</label>
                                            <input class="form-control" type="text" placeholder="Product Price here.." name="price">
                                             <p class="help-block">${error_tag}</p>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Product Description</label>
                                            <textarea class="form-control" name="description" rows="7"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label>Product Specification</label>
                                            <textarea class="form-control" name="specification" rows="7"></textarea>
                                        </div>
                                       
                                        
                                        <div class="form-group">
                                            <label>Choose Category</label>
                                            <select class="form-control" name="category">
                                              
                                                <c:forEach items="${categorylist}" var="cat">
                                                    <option value="${cat.id}"> ${cat.title}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Choose Tags</label>
                                            <select class="form-control" name="tags">
                                              
                                                <c:forEach items="${tagslist}" var="t">
                                                    <option value="${t.tags}"> ${t.tags}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Product Image</label>
                                            <input type="file" name="image" placeholder="Select image file">
                                            <p class="help-block"></p>
                                        </div>
                                      
                                        <button type="submit" class="btn btn-default">Submit Button</button>
                                        <button type="reset" class="btn btn-default">Reset Button</button>
                                    </form>
                             
                             
                             
                             
                             
                             	</div>
							
						
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
