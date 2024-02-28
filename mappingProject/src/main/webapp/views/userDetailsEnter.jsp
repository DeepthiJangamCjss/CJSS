<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>User Details</title>
    <link rel="stylesheet" href="../style.css" type="text/css">
</head>
<body>
    <h1>User Details</h1>

    <form:form action="saveUserDetails" modelAttribute="userModel" method="post">
        <input type="hidden" name="userId" value="${userModel.userId}">
        <input type="hidden" name="username" value="${userModel.username}">
        <input type="hidden" name="password" value="${userModel.password}">

        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" value="${userModel.firstName}">
        <form:errors path="firstName" cssClass="error"/>
        <br>

        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" value="${userModel.lastName}">
        <form:errors path="lastName" cssClass="error"/>
        <br>

        <label for="address.street">Street:</label>
        <input type="text" id="address.street" name="address.street" value="${userModel.address.street}">
        <form:errors path="address.street" cssClass="error"/>
        <br>

        <label for="address.city">City:</label>
        <input type="text" id="address.city" name="address.city" value="${userModel.address.city}">
        <form:errors path="address.city" cssClass="error"/>
        <br>

        <input type="submit" value="Submit">
    </form:form>

    <form:form action="/" method="get">
        <input type="submit" value="Go to Home">
    </form:form>
</body>
</html>
