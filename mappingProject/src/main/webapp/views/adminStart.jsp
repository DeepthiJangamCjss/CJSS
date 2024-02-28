<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>admin login</title>
    <link rel="stylesheet" href="../style.css" type="text/css">
</head>
<body>
<div>
    <form:form action="/adminLogin" modelAttribute="adminModel">
        <label for="username"> Enter User Name  </label>
        <form:input type="text" id="username" path="username"/>
        <form:errors path="username" cssClass="error"/>
        <br>
        <label for="password"> Enter Password  </label>
        <form:input type="text" id="password" path="password"/>
        <form:errors path="password" cssClass="error"/>
        <br>
        <input type="submit" value="Login">
    </form:form>
    <form:form action="/">
        <input type="submit" value="Go Back">
    </form:form>
</div>
</body>
</html>