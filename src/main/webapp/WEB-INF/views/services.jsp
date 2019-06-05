<%-- 
    Document   : services
    Created on : Oct 4, 2018, 2:06:31 PM
    Author     : stim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Services we offer..</h1>
        <p>
            <a href="<c:url value="/Index"/>">Home</a>
            <a href="<c:url value="/About"/>">About Us</a>
            <a href="<c:url value="/Services"/>">Our Services</a>
            <a href="<c:url value="/Contact"/>">Contact Us</a>
        </p>
    </body>
</html>
