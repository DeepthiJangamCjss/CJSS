<%@page language="java" %>
<%@ page import="java.util.List" %>
<%@page import="com.example.mappingProject.models.AlbumModel" %>
<html>
    <head>
        <link rel="stylesheet" href="../style.css" type="text/css">
        <title> album details </title>
        <% List<AlbumModel> albumModelList = (List<AlbumModel>) request.getAttribute("albumModelList"); %>
    </head>
    <body>
        <h1> Album Details </h1>
        <table>
        <% if(albumModelList != null ) { %>
            <tr>
                <th> Album ID </th>
                <th> Title </th>
                <th> Artist </th>
                <th> Number of tracks </th>
                <th> Details </th>
            </tr>
            <% for(AlbumModel albumModel: albumModelList) { %>
                <tr>
                    <td> <%= albumModel.getAlbumID() %> </td>
                    <td> <%= albumModel.getAlbumTitle() %> </td>
                    <td> <%= albumModel.getArtist() %> </td>
                    <td> <%= albumModel.getNumberOfTracks() %> </td>
                    <td> <a type="submit" href="/adminOperations/albumDetails?albumID=<%= albumModel.getAlbumID() %>"> View Details </a> </td>
                </tr>
            <% }
         }%>
        </table>
        <form action="/adminMainPage">
            <input type="submit" value="Go to Home">
        </form>
    </body>
</html>