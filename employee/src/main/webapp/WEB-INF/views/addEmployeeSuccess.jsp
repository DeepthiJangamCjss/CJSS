<%@ page import="com.example.employee.model.Employee" %>
<%@page language="java" %>
<html>
<head>
    <title>add employee</title>
    <link rel="stylesheet" href="../../style.css" type="text/css">
</head>
    <body>
    <%
        Employee employee= (Employee) request.getAttribute("addEmployee");
        int employeeId= (int) request.getAttribute("employeeId");
        if(employee==null){
    %>
        <h1>Employee Details</h1>
        <form action="addEmployeeSuccess">
            <label for="empId"> Enter Id : </label>
            <input type="text" id="empId" name="empId" value="${employeeId}" required readonly>
            <br>
            <label for="firstName">Enter First Name : </label>
            <input type="text" id="firstName" name="firstName" required>
            <br>
            <label for="lastName"> Enter Last Name : </label>
            <input type="text" id="lastName" name="lastName" required>
            <br>
            <label for="role">Enter Role : </label>
            <input type="text" id="role" name="role" required>
            <br>
            <input type="submit" value="Add Employee">
        </form>
    <% } else { %>
        <h1> Employee Id ${employeeId} Already Exists </h1>
    <% } %>
    <form action="/">
        <input type="submit" value="Go to Home">
    </form>
    </body>
</html>