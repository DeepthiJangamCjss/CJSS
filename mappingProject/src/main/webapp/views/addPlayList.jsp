<%@page language="java" %>
<html>
<head>
    <title> add song </title>
    <link rel="stylesheet" href="../style.css" type="text/css">
    <% int  userId = (int) request.getAttribute("userId"); %>
</head>
<body>
    <form action="/userOperations/savePlayList">
        <label for="playListName"> PlayListName </label>
        <input type="text" id="playListName" name="playListName"/>
        <br>
        <label for="description"> Description </label>
        <input type="text" id="description" name="description"/>
        <br>
        <input type="hidden" id="user" name="user" value="<%= userId %>" />
        <br>
        <input type="submit" value="Add PlayList" />
    </form>
</body>
</html>