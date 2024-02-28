<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.ManyToManyJDBC.models.CustomerModel" %>
<%@page language="java" %>
<html>
<head>
    <title>all customers</title>
    <link rel="stylesheet" href="../style.css" type="text/css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 15px;
            border-bottom: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #ff8800;
            color: #fff;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        a {
            text-decoration: none;
            color: #ff8800;
        }

        form {
            text-align: center;
            margin-top: 20px;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color:#ff8800;
            color: #fff;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color:#ff8800;
        }
    </style>
</head>
<body>
<% ArrayList customerModelList=(ArrayList) request.getAttribute("customerModelList"); %>
<table>
    <tr>
        <th> Customer Id </th>
        <th> Name </th>
        <th> Age </th>
        <th> City</th>
        <th> Number of Products Bought </th>
        <th> View Details </th>
        <th> Buy Products </th>
        <th> Delete </th>
    </tr>
    <%
        for(Object customerModel: customerModelList) {
            CustomerModel c= (CustomerModel) customerModel;
    %>
    <tr>
        <td> <%= c.getCustomerId() %> </td>
        <td> <%= c.getCustomerName() %> </td>
        <td> <%= c.getAge() %> </td>
        <td> <%= c.getCity() %> </td>
        <td> <%= c.getProductList().size() %> </td>
        <td> <a href="viewCustomerdetails?customerId=<%=c.getCustomerId() %>">View Details</a> </td>
        <td> <a href="customerBuyProducts?customerId=<%=c.getCustomerId() %>">buy Products</a> </td>
        <td> <a href="deleteCustomer?customerId=<%= c.getCustomerId()%> "> Delete Customer</a> </td>
    </tr>
    <% } %>
</table>
<form action="/">
    <input type="submit" value="Go To Home">
</form>
</body>
</html>