<%@page language="java" %>
<html>
<head>
    <title>User exists</title>
    <link rel="stylesheet" href="../style.css" type="text/css">
</head>
    <body>
        <h1>Username Exists</h1>
        <form action="/userRegister">
            <input type="submit" value="Register">
        </form>
        <p> try with other username </p>
        <form action="/user">
            <input type="submit" value="Go to Home">
        </form>
    </body>
</html>