<%@ page import="com.example.employeeJDBC.entity.Employee" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%
   ArrayList<Employee> employeelist = (ArrayList<Employee>) request.getAttribute("employeesList");
%>

<html>
<head>
    <link rel="stylesheet" href="../style.css" type="text/css">
    <title> All Employee Details</title>
    <style>
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }

        form {
            margin-top: 20px;
        }
    </style>
</head>
    <body>
        <h1>Employee Details</h1>
            <table>
                <tr>
                    <th>Employee Id</th>
                    <th>First Name</th>
                    <th>last Name</th>
                    <th>Role</th>
                    <th>Street</th>
                    <th>city</th>
                    <th>Project Id</th>
                    <th>Project Name</th>
                    <th>Delete Employee</th>
                    <th>Update Employee</th>
                </tr>

            <%
                for (Employee employee : employeelist) {
            %>
            <tr>
                <td><%= employee.getEmpId() %></td>
                <td><%= employee.getFirstName() %></td>
                <td><%= employee.getLastName() %></td>
                <td><%= employee.getRole()%></td>
                <td><%= employee.getAddress().getStreet() %></td>
                <td><%= employee.getAddress().getCity()%></td>
                <td><%= employee.getProject().getProjectId() %></td>
                <td><%= employee.getProject().getProjectName()%></td>
                <td><a href="deleteEmployee?empId=<%=employee.getEmpId() %>">Delete </a></td>
                <td><a href="updateEmployee?empId=<%=employee.getEmpId() %>">Update </a></td>
            </tr>
            <%
                }
            %>
       </table>

        <form action="/">
            <input type="submit" value="Go to Home">
        </form>
    </body>
</html>
