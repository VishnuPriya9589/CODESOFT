<%@ page import="models.Student"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        body{
            font: 1em sans-serif;
            background-color: beige;
        }

        .form1{
            width: 25%;
            margin-top: 100px;
            margin-left: 550px;
            
        }
        label{
            font-weight: bold;
        
        }
        table{
           height: 250px;
           width: 300px;
            border: 1px solid black;
            margin: auto;
            margin-top: 5px;
            /* background-color: rgb(235, 235, 223); */
        }
        td{
            border: 1px solid black;
            padding: 3px;
        }
        .head h1{
            height: 100px;
            margin-left: 530px;
            padding: 20px;
        }
        .head{
            background-color: black;
            color: white;
        }
        
    </style>
</head>
<body>
    <% Student pd=(Student)request.getAttribute("student"); %>
    <header>
        <div class="head">
            <h1>Edit Student Record</h1>
        </div>
    </header>
    <div class="form1">
        <form action="update.do" method="post">
        <input type="text"  hidden  name="student_id" value="<%= pd.getStudentId() %>">
        <table  class="table">

            <tr name="row" style="border: 1px solid black;">
                <td><label for="name" class="lb">Name</label></td>
                <td><input type="text" name="name" value="<%= pd.getName() %>"></td>
            </tr>
            <tr name="row">
                <td><label for="roll_no" class="lb">Roll No.</label></td>
                <td><input type="text" name="roll_no" value="<%= pd.getRollNo() %>"></td>
            </tr>
            <tr name="row">
                <td><label for="branch">Branch</label></td>
                <td><input type="text" name="branch" value="<%= pd.getBranch() %>"></td>
            </tr>
            <tr name="row">
                <td><label for="semester">Semester</label></td>
                <td><input type="number" name="semester" value="<%= pd.getSemester() %>"></td>
            </tr>
            <tr name="row">
                <td><label for="college">College</label></td>
                <td><input type="text" name="college" value="<%= pd.getCollege() %>"></td>
            </tr>
            
            <tr name="row">
                <td colspan="2" align="center" ><input type="submit" value="save" style="font-size: larger;width: 100px;background-color: rgb(66, 53, 50);color: white;padding-bottom: 4px;"></td>
            </tr>
            
        </table>
        </form>
    </div>
    <a href="show.do" name="an" style="font-size: larger;margin-left: 820px;">Show Records</a>
</body>
</html>