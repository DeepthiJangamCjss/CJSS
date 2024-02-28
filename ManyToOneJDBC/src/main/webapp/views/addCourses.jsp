<%@page language="java" %>
<html>
<head>
    <title>enter teacher Details</title>
    <link rel="stylesheet" href="../style.css" type="text/css">
    <% int teacherId=(int) request.getAttribute("teacherId"); %>
</head>
<body>
<h1>Enter Teacher Details</h1>
    <form action="saveCourse" >
        <input type="hidden" value="${teacherId}" id="teacherId" name="teacherId">
        <label for="courseName"> Enter Course Name : </label>
        <input type="text" id="courseName" name="courseName" required>
        <br>
        <label for="year">Course year : </label>
        <input type="text" id="year" name="year" required>
        <br>
        <input type="submit" value="Add Course">
    </form>
    <form action="/">
        <input type="submit" value="Go to Home">
    </form>
</body>
</html>