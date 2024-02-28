<%@page language="java" %>
<html>
<head>
    <title>add employee</title>
    <link rel="stylesheet" href="../style.css" type="text/css">
</head>
<body>
<h1>Employee Details</h1>
<form action="addEmployee">
<%--    <label for="empId">Enter Employee Id : </label>--%>
<%--    <input type="text" id="empId" name="empId" required>--%>
<%--    <br>--%>
    <label for="firstName">Enter First Name : </label>
    <input type="text" id="firstName" name="firstName" required>
    <br>
    <label for="lastName"> Enter Last Name : </label>
    <input type="text" id="lastName" name="lastName" required>
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
<%--    <label for="projectId">project Id : </label>--%>
<%--    <input type="text" id="projectId" name="projectId" required>--%>
<%--    <br>--%>
    <label for="projectName">Project Name : </label>
    <input type="text" id="projectName" name="projectName" required>
    <br>
    <input type="submit" value="Add Employee">
</form>
</body>
</html>