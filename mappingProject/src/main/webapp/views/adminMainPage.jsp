<%@page language="java" %>
<html>
<head>
    <title>admin main page</title>
    <link rel="stylesheet" href="../style.css" type="text/css">
</head>
<body>
        <div>
            <form action="/adminOperations/addAlbum">
                <input type="submit" value="add Album"/>
            </form>
            <form action="/adminOperations/viewAlbums">
                <input type="submit" value="view Albums"/>
            </form>
            <form action="/adminOperations/viewUsers">
                <input type="submit" value="view Users"/>
            </form>
        </div>
        <form action="/">
            <input type="submit" value="Go Back">
        </form>
</body>
</html>