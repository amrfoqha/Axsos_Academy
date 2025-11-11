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
                value="{{request.session.total}}"
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
    </div>
    <div class="info">
        <h2>Activities :</h2>
        <div class="textarea">
            {% for el in request.session.context %}
            <h4 style="color: {{el.color}} ">{{ el.message }}</h4>
            {% endfor %}
        </div>
    </div>
</div>
</body>
</html>
