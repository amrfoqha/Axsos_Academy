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
                        <h1 class="text-4xl font-bold text-center">New Student</h1>
                    <form:form method="post" action="/students/new" modelAttribute="student" class="flex flex-col w-1/3 mx-auto mt-10">
                        <div class="mb-4">
                            <form:label path="name" class="block text-gray-700 text-lg font-bold mb-2">Student Name:</form:label>
                            <form:input path="name" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
                            <form:errors path="name" cssClass="text-red-500 text-xs italic mt-2" />
                        </div>
                        <div class="mb-4">
                            <form:label path="dorm" class="block text-gray-700 text-lg font-bold mb-2">Select Dorm:</form:label>
                            <form:select path="dorm" class="shadow  border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" >
                            <form:options items="${dorms}" itemValue="id" itemLabel="name" />
                            </form:select>
                            <form:errors path="dorm" cssClass="text-red-500 text-xs italic mt-2" />
                        </div>
                        <div class="flex items-center justify-between">
                            <input type="submit" value="Create Student" class="bg-green-700 hover:bg-green-500 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline" />
                        </div>
                    </form:form>
                    <div class="flex justify-center">
                        <a href="/dorms" class="underline text-blue-600 text-2xl mt-10">Dashboard</a>
                    </div>
                </body>

                </html>