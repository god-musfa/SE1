<%@ page import="servlets.PayServlet" %>
<%@ page import="mvc.DailyIncomeView" %>
<%@ page import="mvc.WeeklyIncomeView" %><%--
  Created by IntelliJ IDEA.
  User: cedri
  Date: 05.07.2022
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    DailyIncomeView dIV = (DailyIncomeView) session.getAttribute("dIV");
    WeeklyIncomeView wIV = (WeeklyIncomeView) session.getAttribute("wIV");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Title</title>
</head>
<body>
<table>
    <caption>Daily and Weekly Income</caption>
    <tr>
        <th id="daily">Daily Income</th>
        <th id="weekly">Weekly Income</th>
    </tr>
    <tr>
        <td><%= Math.round(dIV.getDailyIncome()*100.0)/100.0 %></td>
        <td><%= Math.round(wIV.getWeeklyIncome()*100.0)/100.0 %></td>
    </tr>
</table>
</body>
</html>
