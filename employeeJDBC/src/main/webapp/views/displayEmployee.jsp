<%@ page import="com.example.employeeJDBC.entity.Employee" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%
    Employee employee= (Employee) request.getAttribute("employee");
%>

<html>
<head>
    <link rel="stylesheet" href="../style.css" type="text/css">
    <title> All Employee Details</title>
</head>
<body>
    <div>
        <p>Employee ID : <%= employee.getEmpId() %></p>
        <p>First Name   : <%= employee.getFirstName() %></p>
        <p>Last Name    : <%= employee.getLastName() %></p>
        <p>Role         : <%= employee.getRole()%></p>
        <p>Street       : <%= employee.getAddress().getStreet() %></p>
        <p>City         : <%= employee.getAddress().getCity()%></p>
        <p>Project Id   : <%= employee.getProject().getProjectId()%></p>
        <p>Project Name : <%= employee.getProject().getProjectName()%></p>
    </div>
    <form action="/">
        <input type="submit" value="Go to Home">
    </form>
</body>
</html>
