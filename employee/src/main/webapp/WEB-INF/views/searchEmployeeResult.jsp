<%@ page import="com.example.employee.model.Employee" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <link rel="stylesheet" href="../../style.css" type="text/css">
    <title>All Employee Details</title>
</head>
<body>
<h1>Employee Details</h1>
<form action="searchEmployeeResult" method="get">
    <label>Employee Id :</label>
    <input type="text" name="employeeId" id="employeeId" placeholder="Enter Employee ID">
    <input type="submit" value="Search">
</form>
<div>
    <%
        Employee searchEmployee = (Employee) request.getAttribute("searchEmployee");
        if (searchEmployee != null) {
    %>
    <h1>Employee ID : ${searchEmployee.getEmpId()} </h1>
    <p>First Name   : ${searchEmployee.getFirstName()} </p>
    <p>Last Name    :  ${searchEmployee.getLastName()}</p>
    <p>Role         :  ${searchEmployee.getRole()}</p>
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
