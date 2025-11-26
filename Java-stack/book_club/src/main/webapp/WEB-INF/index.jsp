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
                        <h1 class="font-bold text-blue-500">Book Club</h1>
                        <p class="text-2xl text-gray-500">A place for friends to share thoughts on books they've read
                        </p>
                    </div>
                    <div class="flex flex-row gap-10 justify-center">
                        <div class="flex flex-col gap-4 w-1/2">
                            <h1 class="text-2xl font-bold">Register</h1>
                            <form:form action="/register" method="post" modelAttribute="user"
                                class="flex flex-col gap-3">
                                <div class="flex flex-col">
                                    <label for="name" class="font-semibold">Name</label>
                                    <form:input path="name" id="name" class="border border-gray-300 p-2 rounded"
                                        required />
                                    <form:errors path="name" class="text-red-500 text-sm" />
                                </div>
                                <div class="flex flex-col">
                                    <label for="email" class="font-semibold">Email</label>
                                    <form:input path="email" id="email" type="email"
                                        class="border border-gray-300 p-2 rounded" required />
                                    <form:errors path="email" class="text-red-500 text-sm" />
                                </div>
                                <div class="flex flex-col">
                                    <label for="password" class="font-semibold">Password</label>
                                    <form:input path="password" id="password" type="password"
                                        class="border border-gray-300 p-2 rounded" required />
                                    <form:errors path="password" class="text-red-500 text-sm" />
                                </div>
                                <div class="flex flex-col">
                                    <label for="confirmPassword" class="font-semibold">Confirm Password</label>
                                    <form:input path="confirmPassword" id="confirmPassword" type="password"
                                        class="border border-gray-300 p-2 rounded" required />
                                    <form:errors path="confirmPassword" class="text-red-500 text-sm" />
                                </div>
                                <button type="submit"
                                    class="bg-blue-500 text-white p-2 rounded hover:bg-blue-600 transition">Register</button>
                            </form:form>
                        </div>

                        <div class="flex flex-col gap-4 w-1/2">
                            <h1 class="text-2xl font-bold">Login</h1>
                            <form:form action="/login" method="post" modelAttribute="loginUser"
                                class="flex flex-col gap-3">
                                <div class="flex flex-col">
                                    <label for="loginEmail" class="font-semibold">Email</label>
                                    <form:input path="loginEmail" id="loginEmail" type="email"
                                        class="border border-gray-300 p-2 rounded" required />
                                    <form:errors path="loginEmail" class="text-red-500 text-sm" />
                                </div>
                                <div class="flex flex-col">
                                    <label for="loginPassword" class="font-semibold">Password</label>
                                    <form:input path="loginPassword" id="loginPassword" type="password"
                                        class="border border-gray-300 p-2 rounded" required />
                                    <form:errors path="loginPassword" class="text-red-500 text-sm" />
                                </div>
                                <button type="submit"
                                    class="bg-green-500 text-white p-2 rounded hover:bg-green-600 transition">Login</button>
                            </form:form>
                        </div>
                    </div>
                </body>

                </html>