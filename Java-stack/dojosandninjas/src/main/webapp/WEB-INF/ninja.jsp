<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Home - Dojos & Ninjas</title>
    <script src="https://cdn.tailwindcss.com"></script>

</head>
<body class="mx-auto mt-20 w-[500px]">
<h1 class="text-center text-4xl text-red-600">Add New Ninja </h1>
<form:form action="/ninjas/new" method="POST" modelAttribute="ninja" class="mt-5 shadow-xl p-5 rounded-lg w-max mx-auto">
        <div class="flex justify-between mt-4">
        <form:label path="dojo" class="text-2xl mr-2">Dojo Name:</form:label>
        <form:select path="dojo" class="border pl-2 h-10 rounded-xl ml-10 w-1/3">

                <form:options items="${dojos}" itemValue="id" itemLabel="name"/>    
        </form:select>
        </div>
            <div>
                <form:errors path="dojo" Class="text-red-500 text-s underline " />
            </div>
        <div class="flex justify-between mt-4">
        <form:label path="firstName" class="text-2xl mr-2">First Name:</form:label>
        <form:input path="firstName" class="border pl-2 h-10 rounded-xl ml-10 w-1/3" />
        </div>
            <div>
                <form:errors path="firstName" Class="text-red-500 text-s underline " />
            </div>
        <div class="flex justify-between mt-4">
        <form:label path="lastName" class="text-2xl mr-2">Last Name:</form:label>
        <form:input path="lastName" class="border pl-2 h-10 rounded-xl ml-10 w-1/3" />
        </div>
            <div>
                <form:errors path="lastName" Class="text-red-500 text-s underline " />
            </div>
        <div class="flex justify-between mt-4">
        <form:label path="age" class="text-2xl mr-2">Age:</form:label>
        <form:input path="age" class="border pl-2 h-10 rounded-xl ml-28 w-1/3" />
        </div>
            <div>
                <form:errors path="age" Class="text-red-500 text-s underline " />
            </div>

<div class="mx-auto w-max mt-5">
    <input type="submit" value="Add Ninja" class="border cursor-pointer p-1 rounded-lg text-xl shadow-[4px_4px_0px_black]" />
</div>
</form:form>
<div class="flex justify-center">
    <a href="/ " class="underline text-blue-600 text-lg mt-5">Add new Dojos</a>
</div>
</body>
</html>
