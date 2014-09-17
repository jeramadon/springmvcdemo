<%-- 
    Document   : createoffer
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
        <title>Create Offer</title>
    </head>
    <body>
        <h1>New Offer</h1>
            <sf:form method="post" action="${pageContext.request.contextPath}/docreateoffer" commandName="offer">
                <table class="formtable">
                    <tr><td class="label">Name:</td><td><sf:input class="control" path="name" name="name" type="text" /><div class="formerror"><sf:errors path="name" /></div></td></tr>                        
                    <tr><td class="label">Email:</td><td><sf:input class="control" path="email" name="email" type="text" /><div class="formerror"><sf:errors path="email" /></div></td></tr>    
                    <tr><td class="label">Text:</td><td><sf:textarea class="control" path="text" name="text" rows="10" cols="10"></sf:textarea><div class="formerror"><sf:errors path="text" /></div></td></tr>
                    <tr><td class="label"></td><td><input class="control" value="Create Offer" type="submit" /></td></tr>
                </table>
            </sf:form>
    </body>
</html>
