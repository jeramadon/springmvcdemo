<%-- 
    Document   : createuser
    Created on : Sep 9, 2014, 4:06:11 PM
    Author     : jerryamadon
--%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User</title>
    </head>
    <body>
        <h1>New User</h1>
            <sf:form method="post" action="${pageContext.request.contextPath}/docreateuser" commandName="user">
                <table class="formtable">
                    <tr><td class="label">Username:</td><td><sf:input class="control" path="username" name="username" type="text" /><br /><sf:errors path="username" cssClass="formerror" /></td></tr>                        
                    <tr><td class="label">Password:</td><td><sf:input class="control" path="password" name="password" type="text" /><br /><sf:errors path="password" cssClass="formerror" /></td></tr>    
                    <tr><td class="label">Confirm Password:</td><td><input class="control" name="confirmpassword" type="text" /><br /></td></tr>    
                    <tr><td class="label"></td><td><input class="control" value="Create User" type="submit" /></td></tr>
                </table>
            </sf:form>
    </body>
</html>
