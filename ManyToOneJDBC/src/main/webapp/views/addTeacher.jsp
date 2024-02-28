<%@ page import="com.example.ManyToOneJDBC.models.TeacherModel" %>
<%@page language="java" %>
<html>
<head>
    <title>enter teacher Details</title>
    <link rel="stylesheet" href="../style.css" type="text/css">
    <% TeacherModel teacherModel=(TeacherModel) request.getAttribute("teacherModel"); %>
</head>
<body>
    <h1>Enter Teacher Details</h1>
    <form action="saveTeacher" method="post" >
        <input type="hidden" value="${teacherModel}" id="teacherModel" name="teacherModel">
        <label for="teacherName"> Enter Name : </label>
        <input type="text" id="teacherName" name="teacherName" required>
        <br>
        <label for="age">Enter Age : </label>
        <input type="text" id="age" name="age" required>
        <br>
        <input type="submit" value="Add Teacher">
    </form>
    <form action="/">
        <input type="submit" value="Go to Home">
    </form>
</body>
</html>