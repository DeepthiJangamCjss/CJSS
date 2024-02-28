<%@page language="java" %>
<%@ page import="java.util.List" %>
<%@page import="com.example.mappingProject.entity.PlayList" %>
<html>
    <head>
        <link rel="stylesheet" href="../style.css" type="text/css">
        <title> album details </title>
        <%
            List<PlayList> playLists = (List<PlayList>) request.getAttribute("playLists");
            int userId=(int) request.getAttribute("userId");
        %>
    </head>
    <body>
        <h1> PlayList Details </h1>
        <th> PlayList ID </th>
        <th> Title </th>
        <th> description </th>
        <th> Number of songs </th>
        <th> Details </th>
        <% if(!playLists.isEmpty() ) { %>
            <table>
            <tr>
                <th> Song ID </th>
                <th> Title </th>
                <th> description </th>
                <th> Number of songs </th>
                <th> Details </th>
                <th> Delete </th>
            </tr>
            <% for(PlayList playList: playLists) { %>
                <tr>
                    <td> <%= playList.getPlayListId() %> </td>
                    <td> <%= playList.getPlayListName() %> </td>
                    <td> <%= playList.getDescription() %> </td>
                    <td> <%= playList.getSongsList().size() %> </td>
                    <td> <a href="/userOperations/viewPlayList?userId= <%=userId %>&playListId=<%= playList.getPlayListId() %>"> View Details </a>
                    <td> <a href="/userOperations/deletePlayList?userId= <%=userId %>&playListId=<%= playList.getPlayListId() %>"> Delete </a>
                </tr>
            <% } %>
            </table>
        <% } else { %>
            <p> No playLists Available </p>
        <% } %>
        <form action="/userOperations/addPlayList">
            <input type="hidden" id="userId" name="userId" value="<%= userId %>" />
            <input type="submit" value="Add PlayList">
        </form>
        <form action="/userOperations/gotoMainPage">
            <input type="hidden" id="userId" name="userId" value="<%= userId%>">
            <input type="submit" value="Go Back">
        </form>
    </body>
</html>