<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/9/2025
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${fruits}">
            <tr>
                <td><c:out value="${item.getName()}"/></td>
                <td><c:out value="${item.getPrice()}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
