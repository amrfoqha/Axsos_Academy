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
                    <link rel="stylesheet" href="/style.css">
                    <script src="https://cdn.tailwindcss.com"></script>

                </head>

                <body class="mx-auto pt-20 w-2/3">
                        <h1 class="text-4xl font-bold text-center">${dorm.name} Students</h1>
                    <table class="table-auto w-3/4 mt-10 mx-auto">
                <thead>
                    <tr>
                        <th class="px-4 py-2 text-2xl">Student Name</th>
                        <th class="px-4 py-2 text-2xl">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="student" items="${dorm.students}">
                        <tr>
                            <td class="border px-4 py-2 text-2xl text-center">${student.name}</td>
                            <td class="border px-4 py-2 text-2xl text-center">
                                <a href="/dorms/${dorm.id}/remove/${student.id}" class="underline text-blue-600 ">Remove</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="flex justify-center">
                        <a href="/dorms" class="underline text-blue-600 text-2xl mt-10">Dashboard</a>
                    </div>
                </body>

                </html>