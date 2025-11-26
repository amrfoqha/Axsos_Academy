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

                <body class="mx-auto w-1/3 text-center mt-5 text-3xl ">
                    <h1 class="text-4xl text-red-700 ">Welcome!</h1>
                    <h1 class="text-2xl">Join our growing community.</h1>
                            <table class="border-2 border-black mx-auto w-full p-10 mt-10  bg-white rounded-lg shadow-lg ">
                                <tr class="bg-[#9fc4f8] "><td class="border-2 border-black py-2" colspan="2"><h1>Register</h1></td></tr>
                                <form:form action="/user/new" method="POST" modelAttribute="user">
                                    <tr class="bg-[#9fc4f8]">
                                        <td class="border-2 border-black w-1/2">
                                            <form:label path="name">Name:</form:label>
                                            </td>
                                    

                                        <td class="border-2 border-black w-1/2 pb-2">
                                <form:input path="name" class="border-2 border-black pl-2 text-xl rounded w-[80%]" />
                                <form:errors path="name" cssClass="text-red-900 text-sm block"/>
                                        </td>
                                        </tr>

                                <tr class="bg-[#9fc4f8]">
                                    <td class="border-2 border-black">
                                        <form:label path="email">Email:</form:label>
                                    </td>
                                    <td class="border-2 border-black w-1/2 p-2">
                                <form:input path="email" class="border-2 border-black  text-xl rounded w-[80%]" />
                                <form:errors path="email" cssClass="text-red-900 text-sm block" />
                                    </td>
                                </tr>
                                <tr class="bg-[#9fc4f8]">
                                    <td class="border-2 border-black">
                                        <form:label path="password">Password:</form:label>
                                    </td>
                                    <td class="border-2 border-black w-1/2 p-2">
                                <form:input path="password" type="password" class="border-2 border-black  text-xl rounded w-[80%]" />
                                <form:errors path="password" cssClass="text-red-900 text-sm block" />
                                    </td>
                                </tr>
                                <tr class="bg-[#9fc4f8]">
                                <td class="border-2 border-black">
                                <form:label path="confirm">Confirm Password:</form:label>
                                </td>
                                <td class="border-2 border-black w-1/2 p-2">
                                <form:input path="confirm" type="password" class="border-2 border-black  text-xl rounded w-[80%]" />
                                <form:errors path="confirm" cssClass="text-red-900 text-sm block" />
                                </td>
                                </tr>

                                <tr class="bg-[#9fc4f8]">
                                    <td colspan="2" class="border-2 border-black text-center py-2">
                                        <input type="submit" value="Register"
                                        class="cursor-pointer bg-white border-2 border-black shadow-[3px_3px_0px_black]  pb-1  text-xl w-[80%]" />
                                    </td>
                                </tr>
                            </form:form>
                            </table>
                            <hr/>
                        <table class="border-2 border-black mx-auto w-full p-10 mt-4  bg-white rounded-lg shadow-lg ">
                                <tr class="bg-[#9fc4f8] "><td class="border-2 border-black py-2" colspan="2"><h1>Register</h1></td></tr>
                                <form:form action="/user/login" method="POST" modelAttribute="userLogin">
                                    <tr class="bg-[#9fc4f8]">
                                    <td class="border-2 border-black">
                                        <form:label path="loginEmail">Email:</form:label>
                                    </td>
                                    <td class="border-2 border-black w-1/2 p-2">
                                <form:input path="loginEmail" class="border-2 border-black  text-xl rounded w-[80%]" />
                                <form:errors path="loginEmail" cssClass="text-red-900 text-sm block" />
                                    </td>
                                </tr>
                                <tr class="bg-[#9fc4f8]">
                                    <td class="border-2 border-black">
                                        <form:label path="loginPassword">Password:</form:label>
                                    </td>
                                    <td class="border-2 border-black w-1/2 p-2">
                                <form:input path="loginPassword" type="password" class="border-2 border-black  text-xl rounded w-[80%]"/>
                                <form:errors path="loginPassword" cssClass="text-red-900 text-sm block" />
                                    </td>
                                <tr class="bg-[#9fc4f8]">
                                    <td colspan="2" class="border-2 border-black text-center py-2">
                                        <input type="submit" value="Login"
                                        class="cursor-pointer bg-white border-2 border-black shadow-[3px_3px_0px_black]  pb-1  text-xl w-[80%]" />
                                    </td>
                                </tr>
                            </form:form>
                            </table>

                </body>


                </html>