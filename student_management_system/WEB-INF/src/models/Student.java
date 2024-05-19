package models;

import java.sql.*;
import java.util.ArrayList;
// import java.util.Date;
public class Student {
    private int studentId;
    private String name;
    private String rollNo;
    private String branch;
    private int semester;
    private String college;
    

//---------------------------------------------------------------------
    public Student(){

    }
    public Student(String name ,String rollNo,String branch,int semester,String college){
        this.name=name;
        this.rollNo=rollNo;
        this.branch=branch;
        this.semester=semester;
        this.college=college;
    }
    public Student(int studentId ,String name ,String rollNo,String branch,int semester,String college){
        this.studentId=studentId;
        this.name=name;
        this.rollNo=rollNo;
        this.branch=branch;
        this.semester=semester;
        this.college=college;
    }
    
    
    public Student(int studentId ){
        this.studentId=studentId;
    }
    


//-------------------------------------------------------------------------
    public void saveStudent(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?user=root&password=112003");

            String query="insert into students (name ,roll_no ,branch ,semester ,college) value (?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(query);

            ps.setString(1,name);
            ps.setString(2,rollNo);
            ps.setString(3,branch);
            ps.setInt(4,semester);
            ps.setString(5,college);
            

            int val=ps.executeUpdate();
            

            con.close();

        }catch(ClassNotFoundException|SQLException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Student> fetchAllStudents(){
        ArrayList<Student> list=new ArrayList<>();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?user=root&password=112003");

            String query="select * from students";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Student pd=new Student(rs.getInt("student_id"),rs.getString("name"),rs.getString("roll_no"),rs.getString("branch"),rs.getInt("semester"),rs.getString("college"));
                list.add(pd);
            }

            

        }catch(ClassNotFoundException|SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public void retreiveStudentDetails(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?user=root&password=112003");

            String query="select * from students where student_id=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,studentId);
            ResultSet rs=ps.executeQuery();

            if(rs.next()){
                name=rs.getString("name");
                rollNo=rs.getString("roll_no");
                branch=rs.getString("branch");
                semester=rs.getInt("semester");
                college=rs.getString("college");
            }

        }catch(ClassNotFoundException|SQLException e){
            e.printStackTrace();
        }
    }
    public int deleteStudent(){
        int val=0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?user=root&password=112003");

            String query="delete from students where student_id=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,studentId);
            val=ps.executeUpdate();
            
        }catch(ClassNotFoundException|SQLException e){
            e.printStackTrace();
        }
        return val;
    }
    public int updateStudentDetails(){
         int val=0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?user=root&password=112003");

            String query="update students set name=?,roll_no=?,branch=?,semester=?,college=? where student_id=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,name);
            ps.setString(2,rollNo);
            ps.setString(3,branch);
            ps.setInt(4,semester);
            ps.setString(5,college);
            ps.setInt(6,studentId);
            val=ps.executeUpdate();
            
        }catch(ClassNotFoundException|SQLException e){
            e.printStackTrace();
        }
        return val;
    }

    //----------------------------------------------------------------------
    public void setName(String name){
        name=name;
    } 
    public void setRollNo(String rollNo){
        rollNo=rollNo;
    } 
    public void setBranch(String branch){
        branch=branch;
    } 
    public void setSemester(int semester){
        semester=semester;
    } 
    public void setCollege(String college ){
        college=college;
    }
   

    public String getName(){
        return name;
    } 
    public String getRollNo(){
        return rollNo;
    } 
    public int getSemester(){
        return semester;
    } 
    public String getBranch(){
        return branch;
    } 
    public String getCollege(){
        return college;
    } 
    public int getStudentId(){
        return studentId;
    }
    


}