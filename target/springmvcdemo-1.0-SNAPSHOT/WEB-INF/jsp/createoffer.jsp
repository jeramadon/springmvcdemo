<%-- 
    Document   : createoffer
    Created on : Sep 9, 2014, 4:06:11 PM
    Author     : jerryamadon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Offer</title>
    </head>
    <body>
        <h1>New Offer</h1>
            <form method="post" action="${pageContext.request.contextPath}/docreate">
                <table>
                    <tr><td>Name:</td><td><input name="name" type="text" /></td></tr>                        
                    <tr><td>Email:</td><td><input name="email" type="text" /></td></tr>    
                    <tr><td>Text:</td><td><textarea name="text" rows="10" cols="10"></textarea></td></tr>
                    <tr><td></td><td><input value="Create Offer" type="submit" /></td></tr>
                </table>
            </form>
    </body>
</html>
