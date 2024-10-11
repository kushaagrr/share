<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>T-SHIRT WEB-APP</title>
    <link rel="stylesheet" href="/css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
    rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
    crossorigin="anonymous">
</head>
<body>
    <main>
    <center>
        <h1>T SHIRT WEBAPP</h1>
        <h2>The available shirts are :</h2>
        <c:forEach items="${result}" var="shirt">
            <p>shirt name : ${shirt.name}</p>
            <p>shirt size : ${shirt.size}</p>
            <p>shirt color : ${shirt.color}</p>
            <p>shirt gender : ${shirt.gender}</p>
            <p>shirt price : ${shirt.price}</p>
            <p>shirt rating : ${shirt.rating}</p>
            <p>shirt availability : ${shirt.availability}</p>
            <br>
            <br>
        </c:forEach>
    </center>
    </main>
	<script src="/scripts/index.js"></script>
</body>
</html>