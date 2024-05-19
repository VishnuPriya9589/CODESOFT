package controllers;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.*;
import models.Student;
import java.util.Date;

@WebServlet("/save.do")
public class SaveServlet extends HttpServlet{
    public void doGet(HttpServletRequest request ,HttpServletResponse response) throws IOException,ServletException {
        String name =request.getParameter("name");
        String rollNo =request.getParameter("roll_no");
        String branch=request.getParameter("branch");
        Integer semester=Integer.parseInt(request.getParameter("semester"));
        String college=request.getParameter("college");
        // Date date=new Date();


        Student pd=new Student(name,rollNo,branch,semester,college);
        pd.saveStudent();

        request.getRequestDispatcher("index.html").forward(request,response);

    }
}
