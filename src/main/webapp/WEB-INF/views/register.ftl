<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
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
