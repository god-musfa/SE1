<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<style>
    * {
        font-family: sans-serif, Helvetica, Arial;
    }
</style>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=yes">
    <title>Parkhaus Kasse</title>
</head>
<body>
<h1><%= "Parkhaus Kasse" %></h1>
<div>
    <select id="statistik" name="statistikliste" form="statistikchoose">
            <option value="daily">Daily</option>
            <option value="weekly">Weekly</option>
    </select>
    <form action="pay-servlet"  method="get" id="statistikchoose">
            <input type="submit">
    </form>
</div>
<br>
<a href="index.jsp">zurück zum Parkhaus</a>
</body>
</html>