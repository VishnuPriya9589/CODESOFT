package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;
import models.Student;

@WebServlet("/delete.do")
public class DeleteServlet extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
       
        Integer studentId=Integer.parseInt(request.getParameter("student_id"));
        Student pd=new Student(studentId);
        int val=pd.deleteStudent();
        if(val==1){
               
                request.getRequestDispatcher("success.html").forward(request,response);
            }
            else{
                
                request.getRequestDispatcher("failure.html").forward(request,response);
            }
        
    }
}
