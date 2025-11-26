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
                    <div class="flex flex-row gap-10 justify-between pb-2">
                        <div>
                            <h1 class="text-4xl">Welcome, ${user.name}</h1>
                            <h1 class="mt-5">Books from everyone's shelves</h1>
                        </div>
                        <div class="flex flex-col text-lg mt-4">
                            <a href="/logout" class="underline text-blue-800 hover:text-blue-500">Logout</a>
                            <a href="/books/new" class="underline text-blue-800 hover:text-blue-500">+ Add a book to my
                                shelf</a>
                        </div>
                    </div>
                    <div>
                        <table class="w-full">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Title</th>
                                    <th>Author Name</th>
                                    <th>Posted By</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="book" items="${books}">
                                    <tr>
                                        <td>${book.id}</td>
                                        <td>${book.title}</td>
                                        <td>${book.owner.name}</td>
                                        <td>${book.pubUser.name}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

                </body>

                </html>