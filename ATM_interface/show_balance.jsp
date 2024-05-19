<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <% Object balance = session.getAttribute("balance"); %>

    <h1>Your Balance is : <%= balance %></h1>

    <a href="atm.jsp">Home</a> <br><br>
    <a href="logout.do">exit</a> <br><br>
</body>
</html>