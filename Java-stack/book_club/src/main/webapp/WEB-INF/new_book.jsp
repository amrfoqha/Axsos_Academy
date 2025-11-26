<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <%@ page isErrorPage="true" %>
                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Document</title>
                    <script src="https://cdn.tailwindcss.com"></script>
                </head>

                <body class="mx-auto w-[800px] mx-auto mt-10">
                    <div class="text-4xl mb-10">
                        <h1 class="font-bold text-blue-500">ِِِِAdd a Book to your shelf</h1>
                    </div>
                    <form:form action="/books/new" method="post" modelAttribute="book" class="flex flex-col gap-3">
                        <div class="flex flex-col">
                            <label for="title" class="font-semibold">Title</label>
                            <form:input path="title" id="title" class="border border-gray-300 p-2 rounded" />
                            <form:errors path="title" class="text-red-500 text-sm" />
                        </div>
                        <div class="flex flex-col">
                            <label for="author" class="font-semibold">Author</label>
                            <form:input path="author" id="author" class="border border-gray-300 p-2 rounded" />
                            <form:errors path="author" class="text-red-500 text-sm" />
                        </div>
                        <div class="flex flex-col">
                            <label for="language" class="font-semibold">Language</label>
                            <form:input path="language" id="language" class="border border-gray-300 p-2 rounded" />
                            <form:errors path="language" class="text-red-500 text-sm" />
                        </div>
                        <div class="flex flex-col">
                            <label for="pages" class="font-semibold">Pages</label>
                            <form:input path="pages" id="pages" class="border border-gray-300 p-2 rounded" />
                            <form:errors path="pages" class="text-red-500 text-sm" />
                        </div>
                        <button type="submit"
                            class="bg-blue-500 text-white p-2 rounded hover:bg-blue-600 transition">Add Book</button>
                    </form:form>
                </body>

                </html>