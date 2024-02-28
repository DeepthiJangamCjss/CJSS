<%@ page import="com.example.ManyToManyJDBC.models.ProductModel" %>
<%@page language="java" %>
<html>
<head>
    <title>Product Details</title>
    <link rel="stylesheet" href="../style.css" type="text/css">
    <% ProductModel productModel=(ProductModel) request.getAttribute("productModel"); %>
</head>
<body>
<h1>Enter product Details</h1>
<form action="saveProduct" method="post" >
    <input type="hidden" value="<%=productModel%>" id="productModel" name="productModel">
    <label for="productName"> Enter Product Name  </label>
    <input type="text" id="productName" name="productName" required>
    <br>
    <label for="price">Enter Price  </label>
    <input type="text" id="price" name="price" required>
    <br>
    <input type="submit" value="Add Product">
</form>
<form action="/">
    <input type="submit" value="Go to Home">
</form>
</body>
</html>