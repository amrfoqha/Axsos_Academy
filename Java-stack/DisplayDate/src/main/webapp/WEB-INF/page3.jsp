<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/8/2025
  Time: 10:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="index.css">
    <script type="text/javascript" src="time.js"></script>
</head>
<body>
<div class="time"> <c:out value="${time}" /> </div>
</body>
</html>
