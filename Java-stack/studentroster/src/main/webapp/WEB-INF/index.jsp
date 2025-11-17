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
            <h1 class="text-4xl text-center">Dorms</h1>
            <a href="/dorms/new" class="underline text-blue-600 text-2xl">Add new Dorm</a>
            <a href="/students/new" class="underline text-blue-600 text-2xl block">Add new Student</a>

            <table class="table-auto w-full mt-10">
                <thead>
                    <tr>
                        <th class="px-4 py-2 text-2xl">Dorm Name</th>
                        <th class="px-4 py-2 text-2xl">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dorm" items="${dorms}">
                        <tr>
                            <td class="border px-4 py-2 text-2xl">${dorm.name}</td>
                            <td class="border px-4 py-2 text-2xl">
                                <a href="/dorms/${dorm.id}" class="underline text-blue-600">See Students</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </body>
    </html>