package servlets;

import mvc.DailyIncomeView;
import mvc.WeeklyIncomeView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@WebServlet(name = "payServlet", value = "/pay-servlet")
public class PayServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String etageChoosen = request.getParameter("statistikliste");
        DailyIncomeView dIV = null;
        WeeklyIncomeView wIV = null;

        if(etageChoosen.equals("parkhausetage1")) {
             dIV = (DailyIncomeView) getServletContext().getAttribute("Level1Daily");
             wIV = (WeeklyIncomeView) getServletContext().getAttribute("Level1Weekly");
        }
        if(etageChoosen.equals("parkhausetage2")){
             dIV = (DailyIncomeView) getServletContext().getAttribute("Level2Daily");
             wIV = (WeeklyIncomeView) getServletContext().getAttribute("Level2Weekly");
        }

        HttpSession ss = request.getSession();
        ss.setAttribute("dIV",dIV);
        ss.setAttribute("wIV",wIV);
        response.sendRedirect("dailyStatistik.jsp");


    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
