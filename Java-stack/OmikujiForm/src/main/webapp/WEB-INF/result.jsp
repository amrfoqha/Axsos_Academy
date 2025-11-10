<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/10/2025
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class=" text-4xl">
<h1 class="text-center mt-10">Here's Your Omikuji!</h1>
<p class="w-1/3 border-[1px] border-black bg-blue-300 mx-auto mt-10 flex-wrap p-5">In ${number}, You will live in ${city} with ${name} as your roommate,
    ${hobby} for a living the next time you see a ${living},you will have a good luck .
    Also,${nice}.</p>
<div class="flex justify-center">
<a href="/" class="text-center mt-10 underline text-blue-500 ">Go back</a>
</div>
</body>
</html>
