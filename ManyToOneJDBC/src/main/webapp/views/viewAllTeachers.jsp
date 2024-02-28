<%@ page import="com.example.ManyToOneJDBC.models.TeacherModel" %>
<%@ page import="java.util.ArrayList" %>
<%@page language="java" %>
<html>
<head>
    <title>Teacher</title>
    <link rel="stylesheet" href="../style.css" type="text/css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 15px;
            border-bottom: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #ff8800;
            color: #fff;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        a {
            text-decoration: none;
            color: #ff8800;
        }

        form {
            text-align: center;
            margin-top: 20px;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color:#ff8800;
            color: #fff;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color:#ff8800;
        }
    </style>
</head>
<body>
    <% ArrayList teacherModelList=(ArrayList) request.getAttribute("teacherModelList"); %>
    <table>
        <tr>
            <th> Teacher Id </th>
            <th> Name </th>
            <th> Age </th>
            <th> Number of Courses</th>
            <th> View Details </th>
            <th> Add Courses </th>
            <th> Delete </th>
        </tr>
        <%
            for(Object teacherModel: teacherModelList) {
                TeacherModel t= (TeacherModel) teacherModel;
        %>
            <tr>
                <td> <%= t.getTeacherId() %> </td>
                <td> <%= t.getTeacherName() %> </td>
                <td> <%= t.getAge() %> </td>
                <td> <%= t.getCourses().size() %> </td>
                <td> <a href="viewTeacherDetails?teacherId=<%=t.getTeacherId() %>">View Details</a> </td>
                <td> <a href="addCourses?teacherId=<%=t.getTeacherId() %>"> Add Courses</a> </td>
                <td> <a href="deleteteacher?teacherId=<%= t.getTeacherId()%> "> Delete Teacher</a> </td>
            </tr>
        <% } %>
    </table>
    <form action="/">
        <input type="submit" value="Go To Home">
    </form>
</body>
</html>