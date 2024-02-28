<%@ page import="java.util.Map" %>
<%@ page import="com.example.employee.model.Employee" %>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%
    Map<Integer, Employee> employeeMap = (Map<Integer, Employee>) request.getAttribute("employeeMap");
    ObjectMapper objectMapper = new ObjectMapper();
    String employeeMapJson = objectMapper.writeValueAsString(employeeMap);
%>

<html>
<head>
    <link rel="stylesheet" href="../../style.css" type="text/css">
    <title>All Employee Details</title>

    <script>
        var employeeMap = <%= employeeMapJson %>;

        function displayEmployeeDetails() {
            var employeeId = document.getElementById("employeeId").value;
            var employeeDetailsDiv = document.getElementById("employeeDetails");
            employeeDetailsDiv.innerHTML = "";
            if (employeeMap && employeeMap.hasOwnProperty(parseInt(employeeId))) {
                var employee = employeeMap[parseInt(employeeId)];
                var detailsHTML = "<p>Employee ID: " + employee.empId + "</p>" +
                    "<p>First Name: " + employee.firstName + "</p>" +
                    "<p>Last Name: " + employee.lastName + "</p>" +
                    "<p>Role: " + employee.role + "</p>";
                employeeDetailsDiv.innerHTML = detailsHTML;
            } else {
                // Display a message if employeeId is not found
                employeeDetailsDiv.innerHTML = "<p>Employee not found</p>";
            }
        }
    </script>
</head>
    <body>
        <h1>Employee Details</h1>

        <form>
            <label>Employee Id :</label>
            <input type="text" id="employeeId" placeholder="Enter Employee ID">
            <input type="button" value="Search" onclick="displayEmployeeDetails()">
        </form>

        <div id="employeeDetails"></div>
    </body>
</html>
