package controllers;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.ArrayList;
import models.Student;

@WebServlet("/show.do")
public class ShowServlet extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException ,ServletException{
        ArrayList<Student> list=Student.fetchAllStudents();

        request.setAttribute("list",list);

        request.getRequestDispatcher("show.jsp").forward(request,response);

    }
}