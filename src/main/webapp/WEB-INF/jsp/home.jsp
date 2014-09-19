<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring MVC Demo</title>
    </head>
    <body>
        <p><a href="${pageContext.request.contextPath}/offers" >Current Offers</a></p>
        <p><a href="${pageContext.request.contextPath}/createoffer" >Create Offer</a></p>
        <sec:authorize access="hasRole('admin')">
            <p><a href="<c:url value="/admin" />">Admin Console</a></p>
        </sec:authorize>
        <sec:authorize access="!isAuthenticated()">
            <p><a href="<c:url value="/login" />">Login</a></p>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <p><a href="<c:url value="/j_spring_security_logout" />">Logout</a></p>
        </sec:authorize>
    </body>
</html>
