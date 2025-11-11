<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Jail</title>

<script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div class="flex flex-col justify-center items-center h-screen bg-gray-200">
    <h1 class="text-4xl font-bold">You have been sent to Jail!</h1>
    <h2 class="text-2xl">Pay ${balance} gold to get out.</h2>
    <a href="/flush" class="mt-5">
        <button class="bg-green-500 text-white font-bold py-2 px-4 rounded hover:bg-green-600">Pay Jail Fee</button>
    </a>

</div>
</body>
</html>
