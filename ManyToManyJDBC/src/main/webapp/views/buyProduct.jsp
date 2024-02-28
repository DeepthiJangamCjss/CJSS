<%@ page import="com.example.ManyToManyJDBC.models.CustomerModel" %>
<%@ page import="com.example.ManyToManyJDBC.entity.Product" %>
<%@ page import="com.example.ManyToManyJDBC.models.ProductModel" %>
<%@ page import="java.util.List" %>
<%@page language="java" %>
<html>
<head>
    <title>products</title>
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
    CustomerModel customerModel=(CustomerModel) request.getAttribute("customerModel");
    List<ProductModel> allProductsList=(List<ProductModel>) request.getAttribute("allProductsList");
%>
<div>
    <% if(customerModel!=null ) { %>
    <p> ID        :  <%= customerModel.getCustomerId() %></p>
    <p> Name      :  <%= customerModel.getCustomerName() %></p>
    <p> Age       :  <%= customerModel.getAge() %></p>
    <p> City      :  <%= customerModel.getCity() %> </p>
    <table>
        <tr>
            <th>Product Id</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Product Status</th>
        </tr>
        <%
            for(ProductModel product : allProductsList) {
                boolean isFound=false;
                for(Product p: customerModel.getProductList()){
                    if(p.getProductId()==product.getProductId()){
                        isFound=true;
                        break;
                    }
                }
                if(!isFound) {
        %>
            <tr>
                <td> <%= product.getProductId() %> </td>
                <td> <%= product.getProductName() %> </td>
                <td> <%= product.getPrice() %> </td>
                <td> <a href="buyProductByCustomer?productId=<%= product.getProductId()%>&customerId=<%=customerModel.getCustomerId()%>" >Buy</a> </td>
            </tr>
            <% } else { %>
            <tr>
                <td> <%= product.getProductId() %> </td>
                <td> <%= product.getProductName() %> </td>
                <td> <%= product.getPrice() %> </td>
                <td> <a href="removeProductByCustomer?productId=<%= product.getProductId()%>&customerId=<%=customerModel.getCustomerId()%>" >remove</a> </td>
            </tr>
            <% }
            } %>
    </table>
    <% } %>
</div>
<form action="/viewCustomers">
    <input type="submit" value="Go Back">
</form>
</body>
</html>
