<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>

    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<div class="container">
    <div class="input">
        <label>Your Gold:</label>
        <input
                type="text"
                name="gold"
                id="gold"
                placeholder="Enter Gold"
                value="${balance}"
        />
    </div>
    <div class="forms">
        <form action="/gold" method="post">

            <input type="hidden" value="farm" name="hidden" />
            <div class="card">
                <h1>Farm</h1>
                <h2>(earns 10-20 gold)</h2>
                <button type="submit">Find Gold!</button>
            </div>
        </form>
        <form action="/gold" method="post">

            <input type="hidden" value="Cave" name="hidden" />
            <div class="card">
                <h1>Cave</h1>
                <h2>(earns 10-20 gold)</h2>
                <button type="submit">Find Gold!</button>
            </div>
        </form>
        <form action="/gold" method="post">

            <input type="hidden" value="House" name="hidden" />
            <div class="card">
                <h1>House</h1>
                <h2>(earns 10-20 gold)</h2>
                <button type="submit">Find Gold!</button>
            </div>
        </form>
        <form action="/gold" method="post">

            <input type="hidden" value="Quest" name="hidden" />
            <div class="card">
                <h1>Quest</h1>
                <h2>(earns/takes 0-50 gold)</h2>
                <button type="submit">Find Gold!</button>
            </div>
        </form>
        <form action="/gold" method="post">

            <input type="hidden" value="Spa" name="hidden" />
            <div class="card">
                <h1>Spa</h1>
                <h2>(takes 5-20 gold)</h2>
                <button type="submit">Find Gold!</button>
            </div>
        </form>
    </div>
    <div class="info">
        <h2>Activities :</h2>
        <div class="textarea">
            <c:forEach var="el" items="${activities}">
            <h4 
            style="color:
            <c:if test="${el.contains('earned')}">green</c:if>
            <c:if test="${el.contains('lost')}">red</c:if>
            ">
            ${el}
            </h4>
            </c:forEach>
        </div>
    </div>
    
    <a href="/flush" style="margin-top:10px; margin-left:20px; width:100px;"> <button style="width:100%; padding:5px; font-size:16px; font-weight:bold; background-color:gray; cursor:pointer;">Reset Game</button> </a>
</div>
</body>
</html>
