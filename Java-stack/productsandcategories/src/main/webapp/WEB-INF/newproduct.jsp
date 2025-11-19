<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Product</title>
    <!-- Tailwind CSS CDN -->
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-white flex items-center justify-center mt-10">
<div class=" border border-black p-4 w-1/3">
    <h2 class="text-center text-3xl font-semibold mb-3">New Product</h2>
    <a href="/" class="text-blue-600 underline mb-3 inline-block text-2xl">Home</a>
    <hr class="border-black mb-3">
    
    <form:form action="/new/product" method="post" modelAttribute="product">
        <table class="border-collapse border border-black text-3xl">
            <tr>
                <td>

                    <form:label path="name" class="px-3 py-2 font-semibold" >Name:</form:label>
                </td>
                <td class="border border-black px-3 py-2">
                    <form:input  path="name" class="w-full border border-gray-300 px-2 py-1" />
                    <form:errors path="name" class="text-sm text-red-700"/>
                </td>
            </tr>
            <tr>
                <td>

                    <form:label path="description" class=" px-3 py-2 font-semibold" >Description:</form:label>
                </td>
                <td class="border border-black px-3 py-2">
                    <form:input  path="description"   class="w-full border border-gray-300 px-2 py-1" />
                    <form:errors path="description" class="text-sm text-red-700"/>
                </td>
            </tr>
            <tr>
                <td>

                    <form:label path="Price" class=" px-3 py-2 font-semibold" >Price:</form:label>
                </td>
                <td class="border border-black px-3 py-2">
                    <form:input type="number" step="0.1" path="Price"   class="w-full border border-gray-300 px-2 py-1" />
                    <form:errors path="Price" class="text-sm text-red-700"/>
                </td>
            </tr>
        </table>
        <div class="flex justify-center">
            <button type="submit" class="w-full mx-auto border border-black mt-3 py-1 bg-white hover:bg-gray-100 text-2xl">Submit</button>
        </div>
    </form:form>
</div>
</body>
</html>