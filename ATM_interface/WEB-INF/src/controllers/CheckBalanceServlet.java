package controllers;

import java.io.IOException;
import javax.servlet.*; 
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import models.Account;
import models.Atm;

@WebServlet("/check_balance.do")
public class CheckBalanceServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        request.getRequestDispatcher("check_balance.html").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        HttpSession session = request.getSession();

        Account account = (Account)session.getAttribute("account");
        if(account!=null){
            int pin = Integer.parseInt(request.getParameter("pin"));

            if(pin == account.getPin()){
                double balance = Atm.checkBalance(account);
                session.setAttribute("balance",balance);

                request.getRequestDispatcher("show_balance.jsp").forward(request,response);
            }else{
                request.getRequestDispatcher("error1.jsp").forward(request,response);
            }
        }else{
                request.getRequestDispatcher("error.jsp").forward(request,response);
            }

    }
}

