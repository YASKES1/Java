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
         <a href="new">Add New Linear fun</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">List All Linear fun</a>
         
        </h2>
 </center>
    <div align="center">
  <c:if test="${linear_fun != null}">
   <form action="update" method="post">
        </c:if>
        <c:if test="${linear_fun == null}">
   <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
             <h2>
              <c:if test="${linear_fun != null}">
               Edit linear_fun
              </c:if>
              <c:if test="${linear_fun == null}">
               Add New Linear_fun
              </c:if>
             </h2>
            </caption>
          <c:if test="${linear_fun != null}">
           <input type="hidden" name="id" value="<c:out value='${linear_fun.id}' />" />
          </c:if>            
            <tr>
                <th>a: </th>
                <td>
                 <input type="number" name="a" 
                   value="<c:out value='${linear_fun.a}' />"
                  />
                </td>
            </tr>
            <tr>
                <th>x: </th>
                <td>
                 <input type="number" name="x" 
                   value="<c:out value='${linear_fun.x}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>b:</th>
                <td>
                 <input type="number" name="b" 
                   value="<c:out value='${linear_fun.b}' />"
                 />
                </td>
            </tr>
            <tr>
             <td colspan="2" align="center">
              <input type="submit" value="Save" />
             </td>
            </tr>
        </table>
        </form>
    </div> 
</body>
</html>