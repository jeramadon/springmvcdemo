<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring MVC Demo</title>
    </head>
    <body>
        <h1>Yo</h1>
        <%= "Session name: " + session.getAttribute("name")%> <p />
        <%= "Request name: " + request.getAttribute("name")%> <p />
        Request name(2): ${name} <p />
        Request name(3): <c:out value="${name}" /> <p />

        <sql:query var="results" dataSource="jdbc/springmvcdemo">
            select id, name, email, text from offers
        </sql:query>
            
        <h1>Query Results Manual</h1>
        <p />
        <c:forEach var="row" items="${results.rows}">
            Id: ${row.id}<br/>
            Name: ${row.name}<br/>
            Email: ${row.email}<br/>
            Text: ${row.text}<br/>
            <br/>
        </c:forEach>
            
        <h1>Query Results Dao</h1>
        <p />
        <c:forEach var="offer" items="${offers}">
            Id: ${offer.id}<br/>
            Name: ${offer.name}<br/>
            Email: ${offer.email}<br/>
            Text: ${offer.text}<br/>
            <br/>            
        </c:forEach>
            
    </body>
</html>
