<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<style type="text/css">
		*{
             padding: 9px;
             margin: 0;
             box-sizing: border-box;
            }
            body{
                background-color: #c6e1e0;
                height: 100%;
                background-repeat:no-repeat;
                background-size: cover;
                background-position: center;
                box-sizing: border-box;
            }
            .Admin button{
                padding: 0.75em;
                border: none;
                outline: none;
                background-color: rgb(8, 8, 7);
                color: white;
                border-radius: 0.25em;
                opacity: 0.9;
            }

            .login{
                width: 382px;
                margin: auto;
                margin: 20 0 0 450px;
                padding: 20px;
                border-radius: 10px;
                background-color: aliceblue;
            }
            .Admin button a{
                color: white;
            }
           .login button{
             padding: 0.75em;
             border: none;
             outline: none;
             background-color: rgb(1, 6, 8);
             color: white;
              border-radius: 0.25em;
             opacity: 0.9;
            }
        .login button:hover{
         cursor: pointer;
         background-color:rgb(140, 140, 151);
        }
        h1{
        text-align:center;
        }
        h2{
        text-align:center;
        }
        
</style>
</head>
<body >
	<div class="Admin">
       <p align="right"> <button type="submit"><a href="mainPage.jsp">Home</a></button></p> </div>
       <h1 >WELCOME ADMIN</h1>
        <h2>ADMIN LOGIN</h2><br>
        <form name="Login"  action="/adminLogin" method="post">
            <div class="login">
            <label for="AdminId"><b>Enter Admin Id:</b></label>
            <input type="text" name="adminId" placeholder="Admin Id" required><br><br>  
              
            <label for="password"><b>Enter Password:</b></label>
            <input type="password" name="password" placeholder="Password" required><br><br>
            
            <div >&emsp;&emsp;&emsp;&emsp;<button type="submit">Login</button>&emsp;&emsp;
           <button type="reset">Cancel</button></div><br>
            </div>
</form>
</body>
</html>