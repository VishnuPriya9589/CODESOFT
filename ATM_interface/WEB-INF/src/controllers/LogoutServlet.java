package controllers;

import java.io.IOException;
import javax.servlet.*; 
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import models.Account;
import models.Atm;

@WebServlet("/logout.do")
public class LogoutServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        HttpSession session = request.getSession();

        session.invalidate();

        request.getRequestDispatcher("index.html").forward(request,response);
    }

}

