<%-- 
    Document   : createuser
    Created on : Sep 9, 2014, 4:06:11 PM
    Author     : jerryamadon
--%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" >
            $(document).ready(function() {
                $("#password").keyup(monitorPasswords);
                $("#confirmpassword").keyup(monitorPasswords);
                $("#userform").submit(onSubmit)
            });
            function onSubmit() {
                if (!passwordsMatch($("#password").val().length)) {
                    $("#confirmpasswordmessage").text("<fmt:message key='UnmatchedPassword.user.password' />");                    
                    return false;
                } else {
                    $("#confirmpasswordmessage").text("");                    
                }
                return true;
            }
            function monitorPasswords() {
                if (!passwordsMatch($("#confirmpassword").val().length)) {
                    $("#confirmpasswordmessage").text("<fmt:message key='UnmatchedPassword.user.password' />");                    
                } else {
                    $("#confirmpasswordmessage").text("");                    
                }
            }
            function passwordsMatch(matchLength) {
                var password = $("#password").val();
                var confirmpassword = $("#confirmpassword").val();
                var verifyLength = Math.min(password.length, matchLength);
                if (confirmpassword != password.substring(0, verifyLength)) {
                    return false;
                }
                return true;
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User</title>
    </head>
    <body>
        <h1>New User</h1>
            <sf:form id="userform" method="post" action="${pageContext.request.contextPath}/docreateuser" commandName="user">
                <table class="formtable">
                    <tr><td class="label">Username:</td><td><sf:input class="control" path="username" name="username" type="text" /><div class="formerror"><sf:errors path="username" /></div></td></tr>                        
                    <tr><td class="label">Email:</td><td><sf:input class="control" path="email" name="email" type="text" /><div class="formerror"><sf:errors path="email" /></div></td></tr>    
                    <tr><td class="label">Password:</td><td><sf:input id="password" class="control" path="password" name="password" type="password" /><div class="formerror"><sf:errors path="password" /></div></td></tr>    
                    <tr><td class="label">Confirm Password:</td><td><input id="confirmpassword" class="control" name="confirmpassword" type="password" /><div id="confirmpasswordmessage" class="formerror"></div></td></tr>    
                    <tr><td class="label"></td><td><input class="control" value="Create User" type="submit" /></td></tr>
                </table>
            </sf:form>
    </body>
</html>
