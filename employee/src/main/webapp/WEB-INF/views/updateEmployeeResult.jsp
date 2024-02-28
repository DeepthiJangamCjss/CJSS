<%@ page import="com.example.employee.model.Employee" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <link rel="stylesheet" href="../../style.css" type="text/css">
    <title>All Employee Details</title>
</head>
<body>
    <%
        Employee updateEmployee = (Employee) request.getAttribute("updateEmployee");
    %>
    <div>
        <%
            if (updateEmployee!= null) {
        %>
        <form action="updateEmployeeSuccess">
            <h1>Enter Employee Details</h1>
            <br>
            <label for="empId">Employee Id : </label>
            <input type="text" id="empId" name="empId" value=${updateEmployee.getEmpId()} required>
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
            <input type="submit" value="Update">
        </form>
        <%
        } else {
        %>
        <h1> Employee Id Not found </h1>
        <%
            }
        %>
        <form action="/">
            <input type="submit" value="Go to Home">
        </form>
    </div>
</body>
</html>
