<%@ page language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.mappingProject.entity.Songs" %>
<%@ page import="com.example.mappingProject.entity.PlayList" %>
<%@ page import="com.example.mappingProject.entity.SongDetails" %>

<html>
<head>
    <link rel="stylesheet" href="../style.css" type="text/css">
    <title>Playlist Details</title>
    <%
        List<Songs> songsList = (List<Songs>) request.getAttribute("songsList");
        PlayList playList = (PlayList) request.getAttribute("playList");
        int userId = playList.getUser().getUserId();
    %>
</head>
<body>

<h1>Playlist Details</h1>
<p>Playlist ID: <%= playList.getPlayListId() %></p>
<p>Title: <%= playList.getPlayListName() %></p>
<p>Description: <%= playList.getDescription() %></p>

<% if (!songsList.isEmpty()) { %>
    <h1> My Songs </h1>
    <table>
        <tr>
            <th>Song Id</th>
            <th>Title</th>
            <th>Song Details Id</th>
            <th>Genre</th>
            <th>Duration</th>
        </tr>
        <% for (Songs song : songsList ) {
            boolean isFound = false;
            for(Songs s: playList.getSongsList()){
                if(s==song){
                    isFound=true;
                    break;
                }
            }
            SongDetails songDetails = song.getSongDetails();
            if (isFound) {
        %>

            <tr>
                <td><%= song.getSongId() %></td>
                <td><%= song.getTitle() %></td>
                <td><%= songDetails.getSongDetailsId() %></td>
                <td><%= songDetails.getGenre() %></td>
                <td><%= songDetails.getDuration() %></td>
            </tr>
        <% }
        } %>
    </table>
<% } else { %>
    <p>No songs in this playlist.</p>
<% } %>
<br>
<br>
<h1> All Songs </h1>
<table>
        <tr>
            <th>Song Id</th>
            <th>Title</th>
            <th>Status</th>
        </tr>
        <% for (Songs song : songsList ) {
            boolean isFound = false;
            for(Songs s: playList.getSongsList()){
                if(s==song){
                    isFound=true;
                    break;
                }
            }
            SongDetails songDetails = song.getSongDetails();
        %>
            <tr>
                <td><%= song.getSongId() %></td>
                <td><%= song.getTitle() %></td>
                <td>
                    <% if (!isFound) { %>
                        <a href="/userOperations/addSongToPlayList?songId=<%= song.getSongId() %>&playListId=<%= playList.getPlayListId() %>">Add Song</a>
                    <% } else { %>
                        <a href="/userOperations/removeSongFromPlayList?songId=<%= song.getSongId() %>&playListId=<%= playList.getPlayListId() %>">Remove song</a>
                    <% } %>
                </td>
            </tr>
        <% } %>
    </table>
<form action="/userOperations/gotoMainPage">
    <input type="hidden" id="userId" name="userId" value="<%= userId %>">
    <input type="submit" value="Go Back">
</form>

</body>
</html>
