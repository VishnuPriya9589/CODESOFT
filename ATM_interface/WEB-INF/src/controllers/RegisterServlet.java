package controllers;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import models.Account;

@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet{
    int count=0;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        request.getRequestDispatcher("register.html").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        String name = request.getParameter("name");
        int pin = Integer.parseInt(request.getParameter("pin"));

        Account account = new Account(name,pin);
        boolean result = account.createAccount(name,pin);
        if(result==true){
            request.getRequestDispatcher("index.html").forward(request,response);
        }else{
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }
    }
}