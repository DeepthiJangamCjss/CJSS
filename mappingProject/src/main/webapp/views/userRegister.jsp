<%@page language="java" %>
<html>
<head>
    <title>user register</title>
    <link rel="stylesheet" href="../style.css" type="text/css">
</head>
    <body>
    <h1>Register as a user</h1>
    <form action="saveUser">
        <label for="username"> Enter User Name  </label>
        <input type="text" id="username" name="username" required>
        <br>
        <label for="password"> Enter Password  </label>
        <input type="text" id="password" name="password" required>
        <br>
        <input type="submit" value="Add User">
    </form>
    <form action="/user">
        <input type="submit" value="Go to Home">
    </form>
    </body>
</html>