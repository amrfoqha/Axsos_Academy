<%@ page import="org.example.booksapi.models.Book" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/11/2025
  Time: 8:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <title>Title</title>
  <script src="https://cdn.tailwindcss.com"></script>

</head>
<body class="mx-auto w-[1000px]">
<h1 class="mt-10 text-4xl text-red-600">All Books</h1>
<table class="border-2 border-black mt-6 text-3xl w-3/4">
  <thead>
  <tr class="border-b-2 border-black bg-gray-300">
    <th class="text-center py-1 px-2" >ID</th>
    <th class="text-center py-1 px-2">Title</th>
    <th class="text-center py-1 px-2">Language</th>
    <th class="text-center py-1 px-2"># Pages</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="book" items="${books}" >
    <tr>
      <td class="text-center py-1 px-2 border-[1px] m-1">${book.id}</td>
      <td class="text-center py-1 px-2 border-[1px] m-1 underline text-blue-700"> <a href="/books/${book.id}"> ${book.title} </a></td>
      <td class="text-center py-1 px-2 border-[1px] m-1">${book.language}</td>
      <td class="text-center py-1 px-2 border-[1px] m-1">${book.pages}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
