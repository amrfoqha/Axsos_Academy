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
                    <div class="flex flex-row justify-between border-b-2 border-black pb-4 ml-10">
                        <div class="flex flex-row items-center">
                            <a href="/dashboard"
                                class="text-blue-800 hover:text-blue-500 border border-black px-4 rounded shadow-xl">+
                                Dashboard</a>

                        </div>
                        <div class="flex flex-row gap-4 text-lg items-center">
                            <h1 class="text-4xl">Welcome, ${user.name}</h1>
                            <a href="/logout" class="text-blue-800 hover:text-blue-500">
                                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                                    stroke-width="1.5" stroke="currentColor" class="mt-2 w-8 h-8 scale-x-[-1]">
                                    <path stroke-linecap="round" stroke-linejoin="round"
                                        d="M8.25 9V5.25A2.25 2.25 0 0 1 10.5 3h6a2.25 2.25 0 0 1 2.25 2.25v13.5A2.25 2.25 0 0 1 16.5 21h-6a2.25 2.25 0 0 1-2.25-2.25V15m-3 0-3-3m0 0 3-3m-3 3H15" />
                                </svg>
                            </a>
                        </div>
                    </div>
                    <div class="text-4xl mb-10">
                        <h1 class="font-bold text-blue-500">Add a Task</h1>
                    </div>
                    <form:form action="/tasks/new" method="post" modelAttribute="task" class="flex flex-col gap-3">
                        <div class="flex flex-col">
                            <label for="name" class="font-semibold">Name</label>
                            <form:input path="name" id="name" class="border border-gray-300 p-2 rounded" />
                            <form:errors path="name" class="text-red-500 text-sm" />
                        </div>
                        <div class="flex flex-col">
                            <label for="description" class="font-semibold">Description</label>
                            <form:textarea path="description" id="description" rows="6"
                                class="border border-gray-300 p-2 rounded resize-none" />
                            <form:errors path="description" class="text-red-500 text-sm" />
                        </div>
                        <div class="flex flex-col">
                            <label for="dueDate" class="font-semibold">Due Date</label>
                            <form:input type="date" path="dueDate" id="dueDate" min="${toDay}"
                                class="border border-gray-300 p-2 rounded" />
                            <form:errors path="dueDate" class="text-red-500 text-sm" />
                        </div>
                        <div class="flex flex-row gap-5 justify-center mt-5 text-xl">
                            <button type="submit" class="bg-blue-500 text-white p-2 rounded hover:bg-blue-600 ">Add
                                Task</button>
                            <a href="/dashboard"
                                class="bg-blue-500 text-white p-2 rounded hover:bg-blue-600 ">Cancel</a>
                        </div>
                    </form:form>
                </body>

                </html>