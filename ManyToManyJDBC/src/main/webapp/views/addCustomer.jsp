<%@ page import="com.example.ManyToManyJDBC.models.CustomerModel" %>
<%@page language="java" %>
<html>
<head>
    <title>Customer Details</title>
    <link rel="stylesheet" href="../style.css" type="text/css">
    <% CustomerModel customerModel=(CustomerModel) request.getAttribute("customerModel"); %>
</head>
<body>
    <h1>Enter Customer Details</h1>
    <form action="saveCustomer" method="post" >
        <input type="hidden" value="<%=customerModel%>" id="customerModel" name="customerModel">
        <label for="customerName"> Enter Name  </label>
        <input type="text" id="customerName" name="customerName" required>
        <br>
        <label for="age">Enter Age  </label>
        <input type="text" id="age" name="age" required>
        <br>
        <label for="city">Enter City </label>
        <input type="text" id="city" name="city" required>
        <br>
        <input type="submit" value="Add Customer">
    </form>
    <form action="/">
        <input type="submit" value="Go to Home">
    </form>
</body>
</html>