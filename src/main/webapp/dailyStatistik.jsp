<%@ page import="servlets.PayServlet" %>
<%@ page import="mvc.DailyIncomeView" %>
<%@ page import="mvc.WeeklyIncomeView" %>
<%@ page import="jakarta.json.JsonObject" %>
<%@ page import="template.ChartStatisticsCarTypesView" %><%--
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
    ChartStatisticsCarTypesView cST = (ChartStatisticsCarTypesView) session.getAttribute("ChartView");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <script src="plotly-latest.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        function plotChart(elementId, data, layout) {
            Plotly.newPlot(document.getElementById(elementId),
                data, layout, {displayModeBar: false});
        }
    </script>
    <style>
        h2 {
            text-align: center;
        }
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        .center {
            margin-left: auto;
            margin-right: auto;
        }
        th,td{
            text-align: center;
            vertical-align: middle;
        }
    </style>
    <title>Title</title>
</head>
<body>
<a href="kasse.jsp">zurück zur Kasse</a>
<table class="center" style="width:50%">
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
<h2>Pie Chart for Car Types</h2>
<div class="center" id="carTypeChart" style="width: 500px;height:500px;"></div>
<script>
    PIECHART = document.getElementById('carTypeChart');
    Plotly.newPlot( PIECHART,<%=cST.getPieChart()%>);
</script>
</body>
</html>
