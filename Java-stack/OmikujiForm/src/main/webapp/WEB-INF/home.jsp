<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/10/2025
  Time: 1:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="pt-10">
<h1 class="text-4xl text-center text-blue-700">Send an Omikuji!</h1>
<form action="/submit" method="post" class="border-2 border-black w-1/4 text-2xl mx-auto p-10 px-4 mt-5">
    <div class="flex flex-col justify-between  mx-auto"><label>Pick any number from 5 to 25:</label><input type="number" max="25" min="5" name="number" class="border-2 border-black w-1/4 mx-auto"/></div>
    <div class="flex flex-col justify-between  mt-5 mx-auto"><label>enter the name of any city:</label><input type="text" name="city" class="border-2 border-black" /></div>
    <div class="flex flex-col justify-between  mt-5 mx-auto"><label>enter the name of any real person:</label><input type="text" name="name" class="border-2 border-black" /></div>
    <div class="flex flex-col justify-between  mt-5 mx-auto"><label>enter the professional endeavor or hobby:</label><input type="text" name="hobby" class="border-2 border-black" /></div>
    <div class="flex flex-col justify-between  mt-5 mx-auto"><label>enter any type of living things:</label><input type="text" name="living" class="border-2 border-black" /></div>
    <div class="flex flex-col justify-between  mt-5 mx-auto"><label>say something nice to someone:</label>
    <textarea name="nice" class="border-2 border-black" rows="2" cols="23" > </textarea></div>
    <div class="flex flex-col justify-between mt-5 w-3/4 mx-auto"><label class="mx-auto">Send and show a friend </label><input type="submit" value="Send" class="border-2 border-black p-1 bg-green-700 hover:bg-green-300 w-1/2 mx-auto" /> </div>
</form>
</body>
</html>
