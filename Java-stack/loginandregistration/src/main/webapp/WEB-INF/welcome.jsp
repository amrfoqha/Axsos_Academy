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
                    <h1 class="text-4xl text-red-700 ">Welcome,${user.name}!</h1>
                    <h1 class="text-2xl">This is your dashboard.Nothing to see here yet.</h1>
                    <a href="/logout" class="text-2xl underline text-blue-600">logout</a>
                    
                        
                           

                </body>


                </html>