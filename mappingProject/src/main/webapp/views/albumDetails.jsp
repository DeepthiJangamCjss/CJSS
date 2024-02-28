<%@page language="java" %>
<%@page import="com.example.mappingProject.models.AlbumModel" %>
<%@page import="com.example.mappingProject.entity.Songs" %>
<%@page import="com.example.mappingProject.entity.SongDetails" %>
<%@page import="java.util.List" %>
<html>
    <head>
        <link rel="stylesheet" href="../style.css" type="text/css">
        <title> album details </title>
        <% AlbumModel albumModel = (AlbumModel) request.getAttribute("albumModel"); %>
    </head>
    <body>
        <h1> Album Details </h1>
        <p> Album ID         :  <%= albumModel.getAlbumID() %> </p>
        <p> Title            :  <%= albumModel.getAlbumTitle() %> </p>
        <p> Artist           :  <%= albumModel.getArtist() %> </p>
        <p> Number of tracks :  <%= albumModel.getNumberOfTracks() %> </p>
        <% if ( ! albumModel.getSongsList().isEmpty() ) { %>
        <table>
            <tr>
                <th> Song Id </th>
                <th> Title </th>
                <th> Song Details Id </th>
                <th> Genre  </th>
                <th> Duration </th>
                <th> Delete Song </th>
            </tr>
            <% for(Songs songs: albumModel.getSongsList() ) {
                SongDetails songDetails = songs.getSongDetails();
             %>
             <tr>
                <td> <%= songs.getSongId() %> </td>
                <td> <%= songs.getTitle() %> </td>
                <td> <%= songDetails.getSongDetailsId() %> </td>
                <td> <%= songDetails.getGenre() %> </td>
                <td> <%= songDetails.getDuration() %> </td>
                <td> <a href="/adminOperations/deleteSong?albumID=<%=albumModel.getAlbumID()%>&songId=<%= songs.getSongId() %>"> Delete </a>  </td>
             </tr>
            <% } %>
        </table>
        <% } else { %>
            <p> No songs in this album </p<
        <% } %>
        <br>
        <form action="/adminOperations/addSong">
            <input type="hidden" id="albumID" name="albumID" value="<%= albumModel.getAlbumID() %>">
            <input type="submit" value="Add Song">
        </form>
        <form action="/adminOperations/mainPage">
            <input type="submit" value="Go to Home">
        </form>
    </body>
</html>