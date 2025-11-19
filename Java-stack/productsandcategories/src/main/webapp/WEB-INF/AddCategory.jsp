<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>TV</title>
    <!-- Tailwind CSS CDN -->
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-white min-h-screen p-8 font-sans w-1/2 mx-auto">
    <!-- Home Link and Heading -->
    <div class="mb-4">
        <a href="/" class="text-blue-600 underline text-base">Home</a>
    </div>
    <h1 class="text-xl font-semibold mb-4">${product.name}</h1>

    <!-- Container -->
    <div class="w-[600px] border border-black p-6">
        <!-- Categories Section -->
        <div class="mb-6">
            <h2 class="font-semibold mb-2">Categories:</h2>
            <ul class="list-disc list-inside ml-4 text-base">
                <!-- Dynamically list categories -->
                <c:forEach var="category" items="${product.categories}">
                    <li>${category.name}</li>
                </c:forEach>
            </ul>
        </div>

        <hr class="border-black mb-6" />

        <form method="post" action="/details/product/${product.id}">
    <div class="mb-3">
        <label class="block mb-1 font-semibold text-base">Add Category:</label>
        <select name="categoryId" class="w-full border border-black px-3 py-2 text-base">
            <option value="">-- Select Product --</option>
            <c:forEach var="category" items="${categories}">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select>
        <c:if test="${not empty errorMessage}">
            <div class="text-red-600 text-sm mt-1">${errorMessage}</div>
        </c:if>
    </div>

    <button type="submit" class="w-full border border-black py-2 bg-white font-semibold hover:bg-gray-100 transition-colors text-base">
        Add
    </button>
</form>
    </div>
</body>
</html>