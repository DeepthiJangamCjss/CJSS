<%@page language="java" %>
<%@ page import="com.example.mappingProject.Entity.User" %>
<%@page import="java.util.List" %>
<html>
<head>
    <title>User main page</title>
    <link rel="stylesheet" href="../style.css" type="text/css">
    <% List<User> userList=(List<User>) request.getAttribute("userList"); %>
</head>
<body>
        <h1> All Users </h1>
        <% if( ! userList.isEmpty()) { %>
            <table>
                <tr>
                    <th> user Id </th>
                    <th> FirstName </th>
                    <th> Last Name </th>
                    <th> city  </th>
                    <th> Street </th>
                    <th> Delete User </th>
                </tr>
                <% for(User user: userList ) {
                 %>
                 <tr>
                    <td> <%= user.getUserId() %> </td>
                    <td> <%= user.getFirstName() %> </td>
                    <td> <%= user.getLastName() %> </td>
                    <td> <%= user.getAddress().getCity() %> </td>
                    <td> <%= user.getAddress().getStreet() %> </td>
                    <td> <a href="/adminOperations/deleteUser?userId=<%=user.getUserId()%>"> Delete </a>  </td>
                 </tr>
                <% } %>
            </table>
        <% } else { %>
            <p> No users Available </p>
        <% } %>
        <form action="/adminMainPage">
            <input type="submit" value="Go to Home">
        </form>
</body>
</html>