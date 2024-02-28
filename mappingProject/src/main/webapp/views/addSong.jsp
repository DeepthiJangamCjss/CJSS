<%@page language="java" %>
<html>
<head>
    <title> add song </title>
    <link rel="stylesheet" href="../style.css" type="text/css">
    <% int  albumID = (int) request.getAttribute("albumID"); %>
</head>
<body>
    <form action="/adminOperations/saveSong">
        <input type="hidden" id="albumID" name="albumID" value="<%= albumID %>" />
        <br>
        <label for="title"> Title </label>
        <input type="text" id="title" name="title"/>
        <br>
        <label for="genre"> Genre </label>
        <input type="text" id="genre" name="genre"/>
        <br>
        <label for="duration"> Duration </label>
        <input type="text" id="duration" name="duration"/>
        <br>
        <input type="submit" value="Add Song" />
    </form>
    <form action="/adminOperations/goToAlbumDetails?albumID=<%= albumID %>">
        <input type="hidden" id="albumID" name="albumID" value="<%= albumID %>" />
        <input type="submit" value="Go Back">
    </form>
</body>
</html>