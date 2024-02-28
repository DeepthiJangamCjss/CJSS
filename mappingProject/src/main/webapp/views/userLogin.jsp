<%@page language="java" %>
<html>
<head>
    <title>User login</title>
    <link rel="stylesheet" href="../style.css" type="text/css">
</head>
<body>
<div>
    <form action="/userLoginToWebsite">
        <label for="username"> Enter User Name  </label>
        <input type="text" id="username" name="username" required>
        <br>
        <label for="password"> Enter Password  </label>
        <input type="text" id="password" name="password" required>
        <br>
        <input type="submit" value="Login">
    </form>
    <form action="/user">
            <input type="submit" value="Go to Home">
        </form>
</div>
</body>
</html>