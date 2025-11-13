<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Title</title>
<script src="https://cdn.tailwindcss.com"></script>
<body >

<div class="flex justify-center mt-20 ">

    <table class="border border-black w-1/2 text-2xl">
        <tbody>
            <tr class="bg-yellow-50">
                <th>Burger Name</th>
        <th>Restaurant Name</th>
        <th>Rating (out of 5)</th>
        <th>Action</th>
    </tr>
    <c:forEach var="item" items="${burgers}">
        <tr class="border border-black">
        <td class="text-center py-1">${item.name}</td>
        <td class="text-center border-l border-black py-1">${item.restaurant}</td>
        <td class="text-center border-l border-black py-1">${item.rating}</td>
        <td class="text-center border-l border-black py-1"> <a href="/burgers/edit/${item.id}" class="underline text-blue-700">Edit</a> </td>
    </tr>
        </c:forEach>
    </tbody>
</table>
            </div>
<div class="flex-col justify-center  w-1/3 mx-auto text-2xl bg-yellow-50 mt-20">
    <h1 class="text-start text-4xl text-blue-500">Burger Tracker</h1>
    <form:form action ="/burgers" method = "post" modelAttribute = "burger" class="w-[100%] border border-black p-10 mt-4">
        <p class="">
            <div class="flex justify-between">
                <form:label path="name">Burger Name</form:label>
        <form:input path="name" class="border border-black pl-2 rounded-xl"/>
            </div>
        <form:errors path="name" class="text-sm text-red-700"/>
    </p>

    
    <p class="mt-2">
            <div class="flex justify-between mt-4">
                <form:label path="restaurant">Restaurant Name</form:label>
        <form:input path="restaurant" class="border border-black pl-2 rounded-xl"/>
            </div>
        <form:errors path="restaurant" class="text-sm text-red-700"/>
    </p>

    
    <p class="mt-2">
            <div class="flex justify-between mt-4">
                <form:label path="rating">Rating</form:label>
        <form:input type="number" max="5" min="1" path="rating" class="border border-black pl-2 rounded-xl"/>
            </div>
        <form:errors path="rating" class="text-sm text-red-700"/>
    </p>

    <p class="mt-2">
            <div class="flex justify-between mt-4">
                <form:label path="notes">Notes</form:label>
        <form:textarea path="notes" class="border border-black pl-2 rounded-xl" cols="23" rows="4"></form:textarea>
            </div>
        <form:errors path="notes" class="text-sm text-red-700"/>
    </p>


<div class="flex justify-center mt-2">
    <input type="submit" value="submit" class="mt-5 border rounded-2xl p-2 bg-green-300 cursor-pointer"/>
</div>
</form:form>
        </div>

</body>
</html>