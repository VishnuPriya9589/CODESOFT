<%@ page import="java.util.ArrayList,models.Student,java.util.Date" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://kit.fontawesome.com/6509189463.js" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        body{
            background-color: beige;
        }
       
        td{
           border: 1px solid black;
          
        }
        th{
            border: 1px solid black;
            /* background-color: rgb(163, 182, 143); */
        }
        .head h1{
            height: 100px;
            margin-left: 450px;
            padding: 20px;
        }
        .head{
            background-color: black;
            color: white;
        }
        .t1{
            width: 75%;
            margin-top: 5px;
            margin-left: 100px;
        }

    </style>
</head>
<body>
    <% ArrayList<Student> list=(ArrayList)request.getAttribute("list");
    
    %>
    
    <header>
        <div class="head">
            <h1>Student Records</h1>
        </div>
    </header>
        <div class="t1" >
            <table class="table table-sm">
            <thead>
              <tr >
                  <th scope="col" class="head">Name</th>
                  <th scope="col" class="head">Roll No.</th>
                  <th scope="col" class="head">Branch</th>
                  <th scope="col" class="head">Semester</th>
                  <th scope="col" class="head">College</th>
                  <th scope="col" class="head">Edit</th>
                  <th scope="col" class="head">Delete</th>
              </tr>
            </thead>
            <tbody>
                
                <% for(Student pd :list) {%>

                    <tr>
                        <td><%= pd.getName() %></td>
                        <td><%= pd.getRollNo() %></td>
                        <td><%= pd.getBranch() %></td>
                        <td><%= pd.getSemester() %></td>
                        <td><%= pd.getCollege() %></td>
                        <td><a href="update.do?student_id=<%= pd.getStudentId() %>" id="update" style="font-size: larger;"><i class="fa-solid fa-pen"></i></a></td>
                        <td><a href="delete.do?student_id=<%= pd.getStudentId() %>" id="delete" style="font-size: larger;"><i class="fa-solid fa-trash"></i></a></td>
                    </tr>
    
                <% } %> 
                
            </tbody>
            </table>
        </div>
        <a href="index.html" id="html" style="font-size: larger;margin-left: 1150px;">Index page</a>
</body>
</html>