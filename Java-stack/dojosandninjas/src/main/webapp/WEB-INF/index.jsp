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
<body class="mx-auto mt-20 w-max">
<h1 class="text-center text-4xl text-red-600">Add new Dojo </h1>
<form:form action="/dojos/new" method="POST" modelAttribute="dojo" class="mt-5  shadow-xl p-5 rounded-lg w-fit mx-auto">
<form:label path="name" class="text-2xl mr-2">Dojo Name:</form:label>
<form:input path="name" class="border pl-2 h-10 rounded-xl" />
<div>
    <form:errors path="name" Class="text-red-500 text-s underline " />
</div>
<br/>
<div class="mx-auto w-max mt-5">
    <input type="submit" value="Add Dojo" class="border cursor-pointer p-1 rounded-lg text-xl shadow-[4px_4px_0px_black]" />
</div>
</form:form>
<div class="flex justify-center">
    <a href="/ninjas " class="underline text-blue-600 text-lg mt-5">Add new Ninjas</a>
</div>
<h1 class="mt-20 text-4xl text-red-500">
All Dojos
</h1>
<table class="border border-black border-separate text-3xl mt-5 font-normal">
    <thead>
        <tr class="bg-gray-400">
            <td class="border border-black px-2 py-2 text-center">ID</td>
            <td class="border border-black px-2 text-center">Name</td>
            <td class="border border-black px-2 text-center">Number of ninjas</td>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="dojo" items="${dojos}">
                <tr class="border border-black">
                    <td class="border border-black px-2 py-2 text-center"><a href="/dojo/${dojo.id}" class="underline text-blue-500">${dojo.id}</a></td>
                    <td class="border border-black px-2 text-center">${dojo.name}</td>
                    <td class="border border-black px-2 text-center">${dojo.ninjas.size()}</td>
                </tr>
            </c:forEach>
        </tbody>
</table>
</body>
</html>
