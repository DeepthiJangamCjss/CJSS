<%@ page import="com.example.ManyToOneJDBC.models.TeacherModel" %>
<%@ page import="com.example.ManyToOneJDBC.entity.Course" %>
<%@page language="java" %>
<html>
<head>
    <title>employee</title>
    <link rel="stylesheet" href="../style.css" type="text/css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        div {
            background-color: #fff;
            margin: 20px;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        a {
            text-decoration: none;
            color: #ffa600;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<%
    TeacherModel teacherModel=(TeacherModel) request.getAttribute("teacherModel");
%>
<div>
    <% if(teacherModel!=null ) { %>
    <p> ID        :  <%= teacherModel.getTeacherId() %></p>
    <p> Name      :  <%= teacherModel.getTeacherName() %></p>
    <p> Age       :  <%= teacherModel.getAge() %></p>
    <% if(!teacherModel.getCourses().isEmpty()) { %>
    <table>
        <tr>
            <th>Course Id</th>
            <th>Course Name</th>
            <th>Year</th>
            <th>Delete</th>
            <th>Update</th>
        </tr>
        <% for(Course course : teacherModel.getCourses()) {  %>
        <tr>
            <td> <%= course.getCourseId() %> </td>
            <td> <%= course.getCourseName() %> </td>
            <td> <%= course.getCourseYear() %> </td>
            <td> <a href="deleteCourse?courseId=<%= course.getCourseId()%>&teacherId=<%=teacherModel.getTeacherId()%>" >Delete</a> </td>
            <td> <a href="updateCourse?courseId=<%=course.getCourseId()%>&teacherId=<%=teacherModel.getTeacherId()%>">Update</a> </td>
        </tr>
        <%  } %>
    </table>
    <% } %>
    <% } %>
</div>
    <form action="viewTeachers">
        <input type="submit" value="Go Back">
    </form>
</body>
</html>