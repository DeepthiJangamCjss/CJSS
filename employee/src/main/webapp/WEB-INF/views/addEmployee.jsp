<%@page language="java" %>
<html>
<head>
    <title>add employee</title>
    <link rel="stylesheet" href="../../style.css" type="text/css">
</head>
    <body>
    <h1>Employee Details</h1>
    <form action="addEmployee">
        <label for="empId"> Enter Id : </label>
        <input type="text" id="empId" name="empId" placeholder="Add Employee Id" required>
        <input type="submit" value="Add Employee">
    </form>
    </body>
</html>