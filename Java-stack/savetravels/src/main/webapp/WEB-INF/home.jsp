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
                <th>Expense</th>
        <th>Vendor</th>
        <th>Amount</th>
        <th>Action</th>
    </tr>
    <c:forEach var="item" items="${travels}">
        <tr class="border border-black">
        <td class="text-center py-1"> <a href="/travel/${item.id}" class="underline text-blue-700">${item.expense}</a> </td>
        <td class="text-center border-l border-black py-1">${item.vendor}</td>
        <td class="text-center border-l border-black py-1">$${item.amount}</td>
        <td class="text-center border-l border-black py-2"> 
            <a href="/travels/edit/${item.id}" class="underline text-blue-700">Edit</a>
            <a href="/travels/delete/${item.id}" class="border-2 border-black bg-red-700 text-white px-1 shadow-[2px_2px_0px_black]">Delete</a>
             </td>
    </tr>
        </c:forEach>
    </tbody>
</table>
            </div>
<div class="flex-col justify-center  w-1/3 mx-auto text-2xl bg-yellow-50 mt-20">
    <h1 class="text-start text-4xl text-blue-500">Add an expense:</h1>
    <form:form action ="/travels" method = "post" modelAttribute = "travel" class="w-[100%] border border-black p-10 mt-4">
        <p class="">
            <div class="flex justify-between">
                <form:label path="expense">Expense Name:</form:label>
        <form:input path="expense" class="border border-black pl-2 rounded-xl"/>
            </div>
        <form:errors path="expense" class="text-sm text-red-700"/>
    </p>

    
    <p class="mt-2">
            <div class="flex justify-between mt-4">
                <form:label path="vendor">Vendor:</form:label>
        <form:input path="vendor" class="border border-black pl-2 rounded-xl"/>
            </div>
        <form:errors path="vendor" class="text-sm text-red-700"/>
    </p>

    
    <p class="mt-2">
            <div class="flex justify-between mt-4">
                <form:label path="amount">Amount:</form:label>
        <form:input  path="amount" class="border border-black pl-2 rounded-xl"/>
            </div>
        <form:errors path="amount" class="text-sm text-red-700"/>
    </p>

    <p class="mt-2">
            <div class="flex justify-between mt-4">
                <form:label path="description">Description:</form:label>
        <form:textarea path="description" class="border border-black pl-2 rounded-xl" cols="23" rows="4"></form:textarea>
            </div>
        <form:errors path="description" class="text-sm text-red-700"/>
    </p>


<div class="flex justify-center mt-2">
    <input type="submit" value="submit" class="mt-5 border rounded-2xl p-2 bg-green-300 cursor-pointer"/>
</div>
</form:form>
        </div>

</body>
</html>