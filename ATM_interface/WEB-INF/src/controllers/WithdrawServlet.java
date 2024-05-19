package controllers;

import java.io.IOException;
import javax.servlet.*; 
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import models.Account;
import models.Atm;

@WebServlet("/withdraw.do")
public class WithdrawServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        request.getRequestDispatcher("withdraw.html").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        HttpSession session = request.getSession();

        Account account = (Account)session.getAttribute("account");

        double amount = Double.parseDouble(request.getParameter("amount"));
        int pin = Integer.parseInt(request.getParameter("pin"));

        if(pin == account.getPin()){
            Atm.withdraw(account,amount);
            request.getRequestDispatcher("atm.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }
    }
}

