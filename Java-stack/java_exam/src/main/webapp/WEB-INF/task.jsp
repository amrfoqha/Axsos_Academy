<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

                        <div class="flex justify-between">
                            <div class="flex flex-col mt-10 w-1/2">

                                <div>

                                    <div class="flex flex-col mt-10">
                                        <label class="font-light text-4xl">${task.name}</label>

                                    </div>
                                    <div class="flex flex-col mt-10">
                                        <label class="font-light text-2xl">${task.description}</label>

                                    </div>
                                    <div class="flex flex-col mt-4">
                                        <label class="font-normal text-xl text-blue-300">Your dead line:
                                            <fmt:formatDate value="${task.dueDate}" pattern="yyyy-MM-dd" />
                                        </label>

                                    </div>
                                </div>
                                <div class="flex flex-row gap-4 mt-10">
                                    <a href="/editTask/${task.id}"
                                        class=" hover:bg-blue-100  font-bold py-2 px-4 rounded border border-black">
                                        Edit
                                    </a>
                                    <a href="/deleteTask/${task.id}"
                                        class=" hover:bg-blue-100  font-bold py-2 px-4 rounded border border-black">
                                        Delete
                                    </a>
                                </div>

                            </div>
                            <div class="flex flex-col gap-4 mt-20 w-1/4 ">
                                <a href="/toggelInProgress/${task.id}"
                                    class="hover:bg-blue-100  font-bold py-2 px-4 rounded border border-black">In
                                    Progress</a>
                                <a href="/toggelDone/${task.id}"
                                    class="hover:bg-blue-100  font-bold py-2 px-4 rounded border border-black">Done</a>
                            </div>
                        </div>


                    </body>

                    </html>