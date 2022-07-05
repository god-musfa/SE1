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
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>Daily Income</th>
        <th>Weekly Income</th>
    </tr>
    <tr>
        <td><%= Math.round(dIV.getDailyIncome()) %></td>
        <td><%= Math.round(wIV.getWeeklyIncome()) %></td>
    </tr>
</table>
</body>
</html>
