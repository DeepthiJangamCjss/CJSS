<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <link rel="stylesheet" href="../../style.css" type="text/css">
    <title>All Employee Details</title>
</head>
<body>
<h1>Employee Details</h1>
    <form action="searchEmployeeResult">
        <label for="employeeId" >Employee Id :</label>
        <input type="text" id="employeeId" placeholder="Enter Employee ID" name="employeeId" required>
        <input type="submit" value="Search">
    </form>
    <form action="/">
        <input type="submit" value="Go to Home">
    </form>
</body>
</html>
