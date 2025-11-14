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

<div class="flex-col justify-center  w-1/3 mx-auto text-2xl bg-yellow-50 mt-20">
    <div class="flex justify-between"><h1 class="text-start text-4xl text-blue-500">Edit Expense</h1><a href="/" class="text-2xl text-blue-700 underline" >Go Back</a></div>
    <form:form action ="/edit/${travel.id}" method = "post" modelAttribute = "travel" class="w-[100%] border border-black p-10 mt-4">
        
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
        <form:input path="Vendor" class="border border-black pl-2 rounded-xl"/>
            </div>
        <form:errors path="Vendor" class="text-sm text-red-700"/>
    </p>

    
    <p class="mt-2">
            <div class="flex justify-between mt-4">
                <form:label path="amount">Amount:</form:label>
        <form:input path="amount" class="border border-black pl-2 rounded-xl"/>
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