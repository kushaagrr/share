<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
        <br>
        <form action="search">
            <label for="color">Enter the Color of the T-shirt</label>
            <input name="color" type="text"><br>
            <label for="size">Enter the size of the T-shirt</label>
            <input name="size" type="text"><br>
            <label for="gender">Enter the gender</label>
            <input name="gender" type="text"><br>
            <label for="output">Enter the output preference</label>
            <input name="output" type="text"><br>
            <button class="btn btn-success" type="submit">Search</button>
        </form>
    </center>
    </main>
	<script src="/scripts/index.js"></script>
</body>
</html>