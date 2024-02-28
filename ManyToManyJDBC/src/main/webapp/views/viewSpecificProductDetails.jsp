<%@ page import="com.example.ManyToManyJDBC.models.CustomerModel" %>
<%@ page import="com.example.ManyToManyJDBC.models.ProductModel" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.ManyToManyJDBC.entity.Product" %>
<%@ page import="com.example.ManyToManyJDBC.entity.Customer" %>
<%@page language="java" %>
<html>
<head>
    <title>Product Details</title>
    <link rel="stylesheet" href="../style.css" type="text/css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        div {
            background-color: #fff;
            margin: 20px;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        a {
            text-decoration: none;
            color: #ffa600;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<%
    ProductModel productModel=(ProductModel) request.getAttribute("productModel");
%>
<div>
    <% if(productModel!=null ) { %>
    <p> ID        :  <%= productModel.getProductId() %></p>
    <p> Name      :  <%= productModel.getProductName() %></p>
    <p> Price       :  <%= productModel.getPrice() %></p>
    <table>
        <tr>
            <th>Customer Id</th>
            <th>Customer Name</th>
            <th>Age </th>
            <th>City </th>
        </tr>
        <%
            if(!productModel.getCustomerList().isEmpty()) {
            for(Customer customer: productModel.getCustomerList()) {
        %>
        <tr>
            <td> <%= customer.getCustomerId() %> </td>
            <td> <%= customer.getCustomerName() %> </td>
            <td> <%= customer.getAge() %> </td>
            <td> <%= customer.getCity() %> </td>
        </tr>
        <% }
        }
        %>
    </table>
    <% } %>
</div>
<form action="/viewProducts">
    <input type="submit" value="Go Back">
</form>
</body>
</html>