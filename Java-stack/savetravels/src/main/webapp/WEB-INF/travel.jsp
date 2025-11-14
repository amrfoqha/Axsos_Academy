<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Title</title>
<script src="https://cdn.tailwindcss.com"></script>
<body class="bg-yellow-50">

<div class="flex-col justify-center  w-1/3 mx-auto text-2xl  mt-20">
     <div class="flex justify-between mb-20 item-center"><h1 class="text-start text-4xl text-blue-500">Expense Details</h1><a href="/" class="text-2xl text-blue-700 underline " >Go Back</a></div>
    
     
            <div class="flex justify-between">
                <label >Expense Name:</label>
        <label  class=" pl-2 ">${travel.expense}</label>
            </div>
        
    

    
    
            <div class="flex justify-between mt-20">
                <label >Vendor:</label>
        <label  class=" pl-2 ">${travel.vendor}</label>
            </div>

  

    

            <div class="flex justify-between mt-20">
                <label >Amount:</label>
        <label class=" pl-2 ">${travel.amount}</label>
            </div>




            <div class="flex justify-between mt-20">
                <label >Description:</label>
        <label  class="pl-2 text-end"  disabled>${travel.description}</label>
            </div>


        </div>

</body>
</html>