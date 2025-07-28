<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
 <title>User Management Application</title>
</head>
<body>
 <center>
  <h1>User Management</h1>
        <h2>
         <a href="new">Add New Linear Fun</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">List All Linear Fun</a>
         
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of linear funs</h2></caption>
            <tr>
                <th>ID</th>
                <th>a</th>
                <th>x</th>
                <th>b</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="linear_fun" items="${listLinearFun}">
                <tr>
                    <td><c:out value="${linear_fun.id}" /></td>
                    <td><c:out value="${linear_fun.a}" /></td>
                    <td><c:out value="${linear_fun.x}" /></td>
                    <td><c:out value="${linear_fun.b}" /></td>
                    <td>
                     <a href="edit?id=<c:out value='${linear_fun.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?id=<c:out value='${linear_fun.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>