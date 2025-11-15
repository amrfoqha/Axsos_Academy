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
<h1 class="text-center text-4xl text-red-600">${dojo.name} Ninjas </h1>

<table class="border border-black border-separate text-4xl font-normal mt-20 mb-20">
    <thead>
        <tr class="bg-gray-400">
            <td class="border border-black px-2 py-2 text-center">First Name</td>
            <td class="border border-black px-2 text-center">Last Name</td>
            <td class="border border-black px-2 text-center">Age</td>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="ninja" items="${dojo.ninjas}">
                <tr class="border border-black">
                    <td class="border border-black px-2 py-2 text-center">${ninja.firstName}</td>
                    <td class="border border-black px-2 text-center">${ninja.lastName}</td>
                    <td class="border border-black px-2 text-center">${ninja.age}</td>
                </tr>
            </c:forEach>
        </tbody>
</table>
<div class="text-center">
    <a href="/ninjas" class="underline text-blue-700 text-2xl">Add New ninja</a>
</div>
</body>
</html>
