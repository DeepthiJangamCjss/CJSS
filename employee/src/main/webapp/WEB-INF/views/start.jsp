<%@page language="java" %>
<html>
    <head>
        <title>employee</title>
        <link rel="stylesheet" href="../../style.css" type="text/css">
    </head>
    <body>
        <div>
            <form action="viewEmployees">
                <input type="submit" value="View All Employees">
            </form>
            <form action="searchEmployee">
                <input type="submit" value="search Employee">
            </form>
            <form action="updateEmployee">
                <input type="submit" value="Update Employee">
            </form>
            <form action="deleteEmployee">
                <input type="submit" value="Delete Employee">
            </form>
            <form action="add">
                <input type="submit" value="Add Employee">
            </form>
        </div>
    </body>
</html>