<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Registration</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h1>Customer Registration</h1>

    <form:form action="/saveRestaurantOwner" method="post" modelAttribute="restaurantOwnerModel">

        <div>
            <label for="username">Username:</label>
            <form:input path="username" id="username" />
            <form:errors path="username" cssClass="error" />
        </div>

        <div>
            <label for="password">Password:</label>
            <form:password path="password" id="password" />
            <form:errors path="password" cssClass="error" />
        </div>

        <div>
            <label for="ownerName">Name:</label>
            <form:input path="ownerName" id="ownerName" />
            <form:errors path="ownerName" cssClass="error" />
        </div>

        <div>
            <label for="email">Email:</label>
            <form:input path="email" id="email" />
            <form:errors path="email" cssClass="error" />
        </div>

        <div>
            <input type="submit" value="Register">
        </div>
    </form:form>
    <form:form action="/">
        <input type="submit" value="Back" />
    </form:form>
</body>
</html>
