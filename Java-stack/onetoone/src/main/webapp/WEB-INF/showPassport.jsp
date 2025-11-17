<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Passport Details</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="mx-auto mt-20 w-max">
<h1 class="text-center text-4xl text-red-600">Passport Details</h1>
<div class="mt-10 text-2xl">
    <p><strong>Person ID:</strong> ${person.id}</p>
    <p><strong>First Name:</strong> ${person.firstName}</p>
    <p><strong>Last Name:</strong> ${person.lastName}</p>
    <p><strong>Email:</strong> ${person.email}</p>
    <c:if test="${not empty person.passport}">
    <p><strong>Passport:</strong> ${person.passport.pID}</p>
    <p><strong>Nationality:</strong> ${person.passport.nationality}</p>
    <p><strong>Location:</strong> ${person.passport.location}</p>
    </c:if>

</div>
<c:if test="${empty person.passport}">
<form:form action="/passport/new/${person.id}" modelAttribute="passport" class="mt-10 shadow-xl p-5 rounded-lg w-fit mx-auto">
    <h2 class="text-3xl text-blue-600 mb-5">Passport Information</h2>
    <form:label path="pID" class="text-2xl mr-2">Passport Number:</form:label>
    <form:input path="pID" class="border pl-2 h-10 rounded-xl" />
    <div>
        <form:errors path="pID" class="text-red-500 text-s underline " />
    </div>
    <form:label path="nationality" class="text-2xl mr-2">Nationality:</form:label>
    <form:input path="nationality" class="border pl-2 h-10 rounded-xl" />
    <div>
        <form:errors path="nationality" class="text-red-500 text-s underline " />
    </div>
    <form:label path="location" class="text-2xl mr-2">Location:</form:label>
    <form:input path="location" class="border pl-2 h-10 rounded-xl" />
    <div>
        <form:errors path="location" class="text-red-500 text-s underline " />
    </div>
    <br/>
    <div class="mx-auto w-max mt-5">
        <input type="submit" value="Add Passport" class="border cursor-pointer p-1 rounded-lg text-xl shadow-[4px_4px_0px_black]" />
    </div>


</form:form>
 </c:if>
</body>
</html>