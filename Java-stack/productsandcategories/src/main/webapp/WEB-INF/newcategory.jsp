<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Category</title>
    <!-- Tailwind CSS CDN -->
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-white flex items-center justify-center mt-10">
<div class="w-[700px] border-2 border-black p-8">
    <h2 class="text-center text-3xl font-semibold mb-6">New Category</h2>
    <a href="/" class="text-blue-700 underline mb-6 inline-block text-2xl">Home</a>
    <hr class="border-black mb-6" />

    <form:form method="post" action="/new/category" modelAttribute="category">
        <table class="w-full border-collapse border-2 border-black text-lg">
            <tr>
                <td class="border-2 border-black px-6 py-4 font-semibold w-1/3 text-2xl">Name:</td>
                <td class="border-2 border-black px-6 py-4 w-2/3">
                    <form:input path="name" 
                        cssClass="w-full border-2 border-gray-400 px-4 py-3 text-lg" />
                    <form:errors path="name" cssClass="text-red-700 text-base mt-1 block" />
                </td>
            </tr>
        </table>
        <button type="submit" 
                class="w-full border-2 border-black mt-6 py-4 bg-white text-2xl font-semibold hover:bg-gray-100 transition-colors">
            Submit
        </button>
    </form:form>
</div>
</body>
</html>