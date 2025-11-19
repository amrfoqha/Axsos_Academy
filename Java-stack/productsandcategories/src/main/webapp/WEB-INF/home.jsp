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

                <body class="mx-auto w-1/2 text-center mt-5 text-3xl">
                    <h1 class="text-4xl text-red-700 ">Home Page</h1>
                    
                    <div class="flex flex-col items-start  text-lg ml-2">
                        <a href="/new/product" class="underline text-blue-700">New Product</a>
                        <a href="/new/category" class="underline text-blue-700">New Category</a>
                    </div>
                    <hr class=" border border-black mt-5"/>
                    <table class="border-2 border-black w-full mt-10">
                        <thead>
                            <tr class="border-b-2 border-black">
                        <th class="py-2 pb-3 border-r-2 border-black">Products</th>
                        <th>Categories</th>
                    </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="border-r-2 border-black">
                                <ul class="list-disc list-inside text-lg underline text-blue-600">
                                    <c:forEach var="product" items="${products}">
                                        <li><span class="text-3xl">
                                            <a href="/details/product/${product.id}">
                                            ${product.name}
                                            </a>
                                            </span></li>
                                    </c:forEach>
                                    
                                </ul>
                            </td>
                            <td class="border-r-2 border-black">
                                <ul class="list-disc list-inside text-lg underline text-blue-600">
                                    <c:forEach var="category" items="${categories}">
                                        <li><span class="text-3xl">
                                            <a href="/details/category/${category.id}">
                                            ${category.name}
                                            </a></span></li>
                                    </c:forEach>
                                </ul>
                            </td>
                            
                            
                        </tr>
                    </tbody>
                    </table>
                        
                            

                </body>


                </html>