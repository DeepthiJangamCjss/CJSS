<%@ page import="com.example.employee.model.Employee" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <link rel="stylesheet" href="../../style.css" type="text/css">
    <title>All Employee Details</title>
</head>
<body>
<h1>Employee Details</h1>
<form action="deleteEmployeeResult" method="get">
    <label>Employee Id :</label>
    <input type="text" name="employeeId" id="employeeId" placeholder="Enter Employee ID" required>
    <input type="submit" value="Search">
    </form>
    <div>
        <%
            boolean deletedEmployee = (boolean) request.getAttribute("deletedEmployee");
            String employeeName= (String) request.getAttribute("employeeName");
            if (deletedEmployee ) {
        %>
            <h1> ${employeeName} deleted Successfully </h1>
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
