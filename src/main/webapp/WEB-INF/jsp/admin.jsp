<%-- 
    Document   : admin
    Created on : Sep 19, 2014, 2:05:35 PM
    Author     : jerryamadon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <h1>Authorized Users</h1>
        <table class="formtable">
            <tr><td>Username</td><td>Email</td><td>Authority</td><td>Enabled</td></tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td><c:out value="${user.username}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.authority}" /></td>
                    <td><c:out value="${user.enabled}" /></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
