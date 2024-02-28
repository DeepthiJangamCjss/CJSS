<%@ page import="com.example.ManyToOneJDBC.entity.Course" %>
<%@page language="java" %>
<html>
<head>
    <title>enter teacher Details</title>
    <link rel="stylesheet" href="../style.css" type="text/css">
    <%
        Course course=(Course) request.getAttribute("course");
        int teacherId=(int) request.getAttribute("teacherId");
    %>
</head>
<body>
<h1>Enter Course Details</h1>
<form action="updateCourseDetails" >
    <input type="hidden" value="${teacherId}" id="teacherId" name="teacherId">
    <label for="courseId" >Course ID : </label>
    <input type="text" id="courseId" name="courseId" value="<%= course.getCourseId()%>" readonly>
    <br>
    <label for="courseName"> Enter Course Name : </label>
    <input type="text" id="courseName" name="courseName" value="<%=course.getCourseName()%>" required>
    <br>
    <label for="year"> Course year : </label>
    <input type="text" id="year" name="year" value="<%=course.getCourseYear()%>" required>
    <br>
    <input type="submit" value="Update Course">
</form>
<form action="/">
    <input type="submit" value="Go to Home">
</form>
</body>
</html>