<%@page language="java" %>
<%@ page import="com.example.mappingProject.models.UserModel" %>
<html>
<head>
    <title>User main page</title>
    <link rel="stylesheet" href="../style.css" type="text/css">
    <% UserModel userModel=(UserModel) request.getAttribute("userModel"); %>
</head>
<body>
        <h1> User Details </h1>
        <% if(userModel !=null) { %>
            <p> User : <%= userModel.getFirstName() %> <%= userModel.getLastName() %> </p>
            <p> Street :  <%= userModel.getAddress().getStreet() %> </p>
            <p> User : <%= userModel.getAddress().getCity() %> </p>
            <form action="/userOperations/viewPlaylists">
                <input type="hidden" id="userId" name="userId" value="<%= userModel.getUserId() %>" />
                <input type="submit" value="View All PlayList">
            </form>
        <% } %>
        <form action="/user">
            <input type="submit" value="Go to Home">
        </form>
</body>
</html>