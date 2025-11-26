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

                <body class="mx-auto w-screen mx-auto mt-10">
                    <div class="flex flex-row w-[100%]  justify-center">

                        <div
                            class="flex flex-col gap-4 fixed left-0 top-0 z-10 border-r-2 border-black py-5 h-screen xl:text-2xl lg:text-lg md:text-lg sm:text-sm xl:w-[10%] lg:w-[10%] md:w-[10%] sm:w-[15%] ">
                            <a href="/dashboard" class="hover:bg-blue-300 pl-5">Todo</a>
                            <a href="/dashboard/inprogress" class="hover:bg-blue-300 pl-5">InProgress</a>
                            <a href="/dashboard/done" class="hover:bg-blue-300 pl-5">Done</a>
                            <a href="/dashboard/important" class="hover:bg-blue-300 pl-5">Important</a>
                        </div>
                        <div class=" w-[80%] ml-20">
                            <div class="flex flex-row justify-between border-b-2 border-black pb-4 ml-10">
                                <div class="flex flex-row items-center">
                                    <a href="/tasks/new"
                                        class="text-blue-800 hover:text-blue-500 border border-black px-4 rounded shadow-xl">+
                                        Task</a>

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
                            <div class="ml-10">
                                <div class="flex flex-wrap justify-evenly">
                                    <c:forEach var="task" items="${tasks}">

                                        <!-- this is the tasks **this is my comment not an AI. Ok ibrahim ? -->
                                        <div class="border border-black w-[300px] h-72 mt-10 overflow-y-scroll ">
                                            <div
                                                class="flex flex-row items-center justify-between gap-2 border-b-2 border-black  px-4 py-2">
                                                <h1><a href="/task/${task.id}">${task.name}</a></h1>
                                                <a href="/toggleImportance/${task.id}"><svg
                                                        xmlns="http://www.w3.org/2000/svg" <c:if
                                                        test="${task.isImportant}">
                                                        fill="red"
                                                        </c:if>
                                                        <c:if test="${!task.isImportant}">
                                                            fill="none"
                                                        </c:if>
                                                        viewBox="0 0 24 24" stroke-width="1.5"
                                                        stroke="currentColor" class="w-6 h-6">
                                                        <path stroke-linecap="round" stroke-linejoin="round"
                                                            d="M11.48 3.499a.562.562 0 0 1 1.04 0l2.125 5.111a.563.563 0 0 0 .475.345l5.518.442c.499.04.701.663.321.988l-4.204 3.602a.563.563 0 0 0-.182.557l1.285 5.385a.562.562 0 0 1-.84.61l-4.725-2.885a.562.562 0 0 0-.586 0L6.982 20.54a.562.562 0 0 1-.84-.61l1.285-5.386a.562.562 0 0 0-.182-.557l-4.204-3.602a.562.562 0 0 1 .321-.988l5.518-.442a.563.563 0 0 0 .475-.345L11.48 3.5Z" />
                                                    </svg>
                                                </a>
                                            </div>
                                            <div class="px-2 py-2">
                                                <p class="text-lg">${task.description}</p>
                                            </div>
                                        </div>
                                    </c:forEach>

                                </div>

                            </div>
                        </div>
                    </div>


                </body>

                </html>