<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.ManyToManyJDBC.models.CustomerModel" %>
<%@ page import="com.example.ManyToManyJDBC.models.ProductModel" %>
<%@ page language="java" %>
<html>
<head>
    <title>all products</title>
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
<%
    ArrayList productModelList = (ArrayList) request.getAttribute("productModelList");
    if (productModelList != null) {
%>
<table>
    <tr>
        <th> Product Id </th>
        <th> Name </th>
        <th> Price </th>
        <th> Number of Customers </th>
        <th> View Details </th>
        <th> Delete </th>
    </tr>
    <%
        for (Object productModel : productModelList) {
            ProductModel p = (ProductModel) productModel;
    %>
    <tr>
        <td> <%= p.getProductId() %> </td>
        <td> <%= p.getProductName() %> </td>
        <td> <%= p.getPrice() %> </td>
        <td> <%= p.getCustomerList().size() %> </td>
        <td> <a href="viewProductDetails?productId=<%= p.getProductId() %>">View Details</a> </td>
        <td> <a href="deleteProduct?productId=<%= p.getProductId() %> "> Delete Product</a> </td>
    </tr>
    <% } %>
</table>
<%
    } else {
        out.println("No products available.");
    }
%>
<form action="/">
    <input type="submit" value="Go To Home">
</form>
</body>
</html>
