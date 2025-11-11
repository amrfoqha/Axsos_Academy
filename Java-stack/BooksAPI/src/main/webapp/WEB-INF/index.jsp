<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/11/2025
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="mx-auto  mt-20 w-[500px]">
<h1 class="text-4xl text-blue-700 ">${book.title}</h1>
<h1 class="text-3xl text-red-700 mt-10">Description: <span class="text-blue-500">${book.description}</span></h1>
<h1 class="text-3xl text-red-700 mt-2">Language: <span class="text-blue-500">${book.language}</span></h1>
<h1 class="text-3xl text-red-700 mt-2">Number of Pages: <span class="text-blue-500">${book.pages}</span></h1>
</body>
</html>
