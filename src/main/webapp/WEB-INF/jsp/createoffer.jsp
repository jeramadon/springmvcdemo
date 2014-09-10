<%-- 
    Document   : createoffer
    Created on : Sep 9, 2014, 4:06:11 PM
    Author     : jerryamadon
--%>

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
            <form method="post" action="${pageContext.request.contextPath}/docreate">
                <table class="formtable">
                    <tr><td class="label">Name:</td><td><input class="control" name="name" type="text" /></td></tr>                        
                    <tr><td class="label">Email:</td><td><input class="control" name="email" type="text" /></td></tr>    
                    <tr><td class="label">Text:</td><td><textarea class="control" name="text" rows="10" cols="10"></textarea></td></tr>
                    <tr><td class="label"></td><td><input class="control" value="Create Offer" type="submit" /></td></tr>
                </table>
            </form>
    </body>
</html>
