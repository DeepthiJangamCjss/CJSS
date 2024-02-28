<%@page language="java" %>
<html>
<head>
    <title>Customer product</title>
    <link rel="stylesheet" href="../style.css" type="text/css">
</head>
<body>
<div>
    <form action="/addCustomer">
        <input type="submit" value="Add Customer">
    </form>
    <form action="/viewCustomers">
        <input type="submit" value="View All Customers">
    </form>
    <form action="/addProduct">
        <input type="submit" value="Add Product">
    </form>
    <form action="/viewProducts">
        <input type="submit" value="View All products">
    </form>
</div>
</body>
</html>