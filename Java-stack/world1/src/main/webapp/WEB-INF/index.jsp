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
                    <div
                        class="text-center text-blue-500 text-xl flex flex-col items-center gap-4 fixed top-0 left-[-1px] pl-4 p-4 bg-gray-200 h-full">
                        <a href="#query1" class="underline mr-2 underline-offset-2">Query 1</a>
                        <a href="#query2" class="underline mr-2 underline-offset-2">Query 2</a>
                        <a href="#query3" class="underline mr-2 underline-offset-2">Query 3</a>
                        <a href="#query4" class="underline mr-2 underline-offset-2">Query 4</a>
                        <a href="#query5" class="underline mr-2 underline-offset-2">Query 5</a>
                        <a href="#query6" class="underline mr-2 underline-offset-2">Query 6</a>
                        <a href="#query7" class="underline mr-2 underline-offset-2">Query 7</a>
                        <a href="#query8" class="underline mr-2 underline-offset-2">Query 8</a>
                    </div>
                    <h1 id="query1" class="text-2xl font-bold">Query 1</h1>
                    <table class="table-auto w-full border-collapse border mt-2">
                        <thead>
                            <tr class="border-b-2 border-black">
                                <th class="px-4 py-2 border">Country</th>
                                <th class="px-4 py-2 border">Language</th>
                                <th class="px-4 py-2 border">Percentage</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${table}" var="row">
                                <tr>
                                    <td class="px-4 py-2 border text-center">${row[0]}</td>
                                    <td class="px-4 py-2 border text-center">${row[1]}</td>
                                    <td class="px-4 py-2 border text-center">${row[2]}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <h1 id="query2" class="text-2xl font-bold">Query 2</h1>
                    <table class="table-auto w-full border-collapse border mt-2">
                        <thead>
                            <tr class="border-b-2 border-black">
                                <th class="px-4 py-2 border">Country</th>
                                <th class="px-4 py-2 border">Cities</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${table2}" var="row">
                                <tr>
                                    <td class="px-4 py-2 border text-center">${row[0]}</td>
                                    <td class="px-4 py-2 border text-center">${row[1]}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <h1 id="query3" class="text-2xl font-bold">Query 3</h1>
                    <table class="table-auto w-full border-collapse border mt-2">
                        <thead>
                            <tr class="border-b-2 border-black">
                                <th class="px-4 py-2 border">City</th>
                                <th class="px-4 py-2 border">Population</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${table3}" var="row">
                                <tr>
                                    <td class="px-4 py-2 border text-center">${row[0]}</td>
                                    <td class="px-4 py-2 border text-center">${row[1]}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <h1 id="query4" class="text-2xl font-bold">Query 4</h1>
                    <table class="table-auto w-full border-collapse border mt-2">
                        <thead>
                            <tr class="border-b-2 border-black">
                                <th class="px-4 py-2 border">Country</th>
                                <th class="px-4 py-2 border">Language</th>
                                <th class="px-4 py-2 border">Percentage</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${table4}" var="row">
                                <tr>
                                    <td class="px-4 py-2 border text-center">${row[0]}</td>
                                    <td class="px-4 py-2 border text-center">${row[1]}</td>
                                    <td class="px-4 py-2 border text-center">${row[2]}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <h1 id="query5" class="text-2xl font-bold">Query 5</h1>
                    <table class="table-auto w-full border-collapse border mt-2">
                        <thead>
                            <tr class="border-b-2 border-black">
                                <th class="px-4 py-2 border">Country</th>
                                <th class="px-4 py-2 border">Surface</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${table5}" var="row">
                                <tr>
                                    <td class="px-4 py-2 border text-center">${row[0]}</td>
                                    <td class="px-4 py-2 border text-center">${row[1]}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <h1 id="query6" class="text-2xl font-bold">Query 6</h1>
                    <table class="table-auto w-full border-collapse border mt-2">
                        <thead>
                            <tr class="border-b-2 border-black">
                                <th class="px-4 py-2 border">Country</th>
                                <th class="px-4 py-2 border">Government Form</th>
                                <th class="px-4 py-2 border">Surface</th>
                                <th class="px-4 py-2 border">Life Expectancy</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${table6}" var="row">
                                <tr>
                                    <td class="px-4 py-2 border text-center">${row[0]}</td>
                                    <td class="px-4 py-2 border text-center">${row[1]}</td>
                                    <td class="px-4 py-2 border text-center">${row[2]}</td>
                                    <td class="px-4 py-2 border text-center">${row[3]}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <h1 id="query7" class="text-2xl font-bold">Query 7</h1>
                    <table class="table-auto w-full border-collapse border mt-2">
                        <thead>
                            <tr class="border-b-2 border-black">
                                <th class="px-4 py-2 border">Country</th>
                                <th class="px-4 py-2 border">City</th>
                                <th class="px-4 py-2 border">District</th>
                                <th class="px-4 py-2 border">Population</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${table7}" var="row">
                                <tr>
                                    <td class="px-4 py-2 border text-center">${row[0]}</td>
                                    <td class="px-4 py-2 border text-center">${row[1]}</td>
                                    <td class="px-4 py-2 border text-center">${row[2]}</td>
                                    <td class="px-4 py-2 border text-center">${row[3]}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <h1 id="query8" class="text-2xl font-bold">Query 8</h1>
                    <table class="table-auto w-full border-collapse border mt-2">
                        <thead>
                            <tr class="border-b-2 border-black">
                                <th class="px-4 py-2 border">Region</th>
                                <th class="px-4 py-2 border">Count</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${table8}" var="row">
                                <tr>
                                    <td class="px-4 py-2 border text-center">${row[0]}</td>
                                    <td class="px-4 py-2 border text-center">${row[1]}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </body>

                </html>