package controllers;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.ArrayList;
import models.Student;

@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet{
    public void doGet(HttpServletRequest request ,HttpServletResponse response) throws IOException,ServletException{
        Integer studentId=Integer.parseInt(request.getParameter("student_id"));

        Student pd=new Student(studentId);
        pd.retreiveStudentDetails();
        request.setAttribute("student",pd);

        request.getRequestDispatcher("update.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request ,HttpServletResponse response)  throws IOException,ServletException{
        Integer studentId=Integer.parseInt(request.getParameter("student_id"));
        String name =request.getParameter("name");
        String rollNo =request.getParameter("roll_no");
        Integer semester=Integer.parseInt(request.getParameter("semester"));
        String branch=request.getParameter("branch");
        String college=request.getParameter("college");
        
        Student pd=new Student(studentId,name,rollNo,branch,semester,college);
        
        int val=pd.updateStudentDetails();
        if(val==1){
            request.getRequestDispatcher("success.html").forward(request,response);
        }else{
            request.getRequestDispatcher("failure.html").forward(request,response);
        }

    }
}