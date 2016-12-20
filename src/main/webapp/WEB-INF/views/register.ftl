<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: yangjian
  Date: 16-8-29
  Time: 上午10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<sf:form method="POST" commandName="jianGuo" >
    First Name:<sf:input path="name"/><br/>
    age:<sf:input path="tel"/><br/>
    telphone:<sf:input path="age"/><br/>
    password:<sf:password path="pwd"/><br/>
    <input type="submit" value="Register">
</sf:form>
</body>
</html>
