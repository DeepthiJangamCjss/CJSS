<%@page language="java" %>
<html>
<head>
    <title>add album</title>
    <link rel="stylesheet" href="../style.css" type="text/css">
</head>
<body>
<div>
    <h1> Enter Album Details </h1>
    <form action="/adminOperations/saveAlbum">
        <label for="albumTitle"> Title  </label>
        <input type="text" id="albumTitle" name="albumTitle" required>
        <br>
        <label for="artist"> Artist  </label>
        <input type="text" id="artist" name="artist" required>
        <br>
        <input type="submit" value="Add Album">
    </form>
    <form action="/adminMainPage">
        <input type="submit" value="Go to Home">
    </form>
</div>
</body>
</html>