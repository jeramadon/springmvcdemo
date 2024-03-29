<%-- 
    Document   : login
    Created on : Sep 15, 2014, 5:34:14 PM
    Author     : jerryamadon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css">
        <title>Login Page</title>
    </head>
    <body onload='document.f.j_username.focus();'>
        <h3>Login with Username and Password</h3>
        <c:if test="${param.error != null}">
            <p class="loginerror">Login failed</p>            
        </c:if>
        <form name='f' action='${pageContext.request.contextPath}/j_spring_security_check' method='POST'>
            <table class="formtable">
                <tr><td>User:</td><td><input type='text' name='j_username' value=''></td></tr>
                <tr><td>Password:</td><td><input type='password' name='j_password'/></td></tr>
                <tr><td>Remember Me:</td><td><input type='checkbox' name='_spring_security_remember_me' /></td></tr>
                <tr><td colspan='2'><input name="submit" type="submit" value="Login"/></td></tr>
            </table>
        </form>
        <p><a href="<c:url value="/createuser" />">Create User</a></p>
    </body>
</html>
