<%-- 
    Document   : offers
    Created on : Sep 9, 2014, 4:06:02 PM
    Author     : jerryamadon
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Offers</title>
    </head>
    <body>
        <h1>Query Results Dao</h1>
        <p />
        <c:forEach var="offer" items="${offers}">
            ${offer}<br/>
        </c:forEach>
            
    </body>
</html>
