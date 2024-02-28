<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.example.employee.model.Employee" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%
    Map<Integer, Employee> employeeMap = (Map<Integer, Employee>) request.getAttribute("employeeMap");
%>

<html>
<head>
    <link rel="stylesheet" href="../../style.css" type="text/css">
    <title> All Employee Details</title>
</head>
<body>
    <h1>Employee Details</h1>
    <div>
        <%
            for (Map.Entry<Integer, Employee> entry : employeeMap.entrySet()) {
        %>
        <div class="employee-container">
            <h1>Employee ID : <%= entry.getValue().getEmpId() %></h1>
            <p>First Name   : <%= entry.getValue().getFirstName() %></p>
            <p>Last Name    : <%= entry.getValue().getLastName() %></p>
            <p>Role         : <%= entry.getValue().getRole()%></p>
        </div>
        <br>
        <br>
        <%
            }
        %>
    </div>
    <form action="/">
        <input type="submit" value="Go to Home">
    </form>
</body>
</html>

<%--<%@ page import="com.example.employee.model.Employee" %>--%>
<%--<%@ page import="java.util.ArrayList" %>--%>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8"%>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Employee Details</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--    <h1>Employee Details</h1>--%>
<%--    <p>Employee Name : ${employeeList.get(0).getFirstName()}</p>--%>
<%--    <p>employee Name : ${employeeList.get(1).getFirstName()}</p>--%>
<%--    <br>--%>
<%--    <p>Employee Name : ${employeeMap.get(1).getFirstName()}</p>--%>
<%--    <p>employee Name : ${employeeMap.get(2).getFirstName()}</p>--%>
<%--    <br>--%>
<%--    <p>Employee Name: ${employeeMap[1].getFirstName()}</p>--%>
<%--    <p>Employee Name: ${employeeMap[2].getFirstName()}</p>--%>

<%--</body>--%>
<%--</html>--%>
