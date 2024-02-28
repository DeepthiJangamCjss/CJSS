<%@ page import="com.example.employeeJDBC.entity.Employee" %>
<%@page language="java" %>
<html>
<head>
    <title>add employee</title>
    <link rel="stylesheet" href="../style.css" type="text/css">
</head>
<body>
<% Employee employee= (Employee) request.getAttribute("employee"); %>
<h1>Employee Details</h1>
<form action="updateEmployeeDetails">
    <label for="empId"> Id :  </label>
    <input type="text" id="empId" name="empId" value="${empId}" readonly>
    <br>
    <label for="firstName">First Name : </label>
    <input type="text" id="firstName" name="firstName" value="${employee.getFirstName()}"} readonly>
    <br>
    <label for="lastName">Last Name : </label>
    <input type="text" id="lastName" name="lastName" value="${employee.getLastName()}" required readonly>
    <br>
    <label for="role">Enter Role : </label>
    <input type="text" id="role" name="role" required>
    <br>
    <label for="street">Enter Street : </label>
    <input type="text" id="street" name="street" required>
    <br>
    <label for="city">Enter City : </label>
    <input type="text" id="city" name="city" required>
    <br>
    <label for="projectId">project Id : </label>
    <input type="text" id="projectId" name="projectId" value="${employee.getProject().getProjectId()}" readonly>
    <br>
    <label for="projectName">Project Name : </label>
    <input type="text" id="projectName" name="projectName" value="${employee.getProject().getProjectName()}" readonly>
    <br>
    <input type="submit" value="Update Employee">
</form>
</body>
</html>