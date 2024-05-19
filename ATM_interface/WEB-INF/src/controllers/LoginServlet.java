package controllers;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import models.Account;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        HttpSession session = request.getSession();
        Account acc = new Account(Integer.parseInt(request.getParameter("account_number")));
        Account account = acc.exists();

        if(account != null){
            session.setAttribute("account",account);
            request.getRequestDispatcher("atm.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }
    }
}