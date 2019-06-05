<%-- 
    Document   : showcategory
    Created on : Oct 9, 2018, 2:47:42 PM
    Author     : stim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    
<jsp:include page="title.jsp"/>

    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<c:url value="/resources/vendor/metisMenu/metisMenu.min.css"/>" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="<c:url value="/resources/vendor/datatables-plugins/dataTables.bootstrap.css"/>" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="<c:url value="/resources/vendor/datatables-responsive/dataTables.responsive.css"/>" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/dist/css/sb-admin-2.css"/>" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<c:url value="/resources/vendor/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

       <jsp:include page="header.jsp"/>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Order management</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Display all orders
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="cat-table">
                                <thead>
                                    <tr>
                                        <th>Id</th>
                                      
                                        
                                        <th>Product Name</th>
                                        <th>Ordered Date and Time</th>
                                     
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${cartlist}" var="cart">
                                        <tr>
                                            <td>${cart.id}</td>
                                         
                                            <td>${cart.productname}</td>
                                            <td>${cart.orderdate}</td>
                                          
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                           
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
        
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="<c:url value="/resources/vendor/jquery/jquery.min.js"/>"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js"/>"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<c:url value="/resources/vendor/metisMenu/metisMenu.min.js"/>"></script>

    <!-- DataTables JavaScript -->
    <script src="<c:url value="/resources/vendor/datatables/js/jquery.dataTables.min.js"/>"></script>
    <script src="<c:url value="/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"/>"></script>
    <script src="<c:url value="/resources/vendor/datatables-responsive/dataTables.responsive.js"/>"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<c:url value="/resources/dist/js/sb-admin-2.js"/>"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#cat-table').DataTable({
            responsive: true
        });
    });
    </script>

</body>

</html>
