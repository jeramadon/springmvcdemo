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
        <link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Offers</title>
    </head>
    <body>
        <h1>Query Results Dao</h1>
        <p />
        <table class="offers">
            <tr><td>Name</td><td>Email</td><td>Text</td></tr>
            <c:forEach var="offer" items="${offers}">
                <tr><td><c:out value="${offer.name}" /></td><td><c:out value="${offer.email}" /></td><td><c:out value="${offer.text}" /></td></tr>
            </c:forEach>
        </table>            
    </body>
</html>
