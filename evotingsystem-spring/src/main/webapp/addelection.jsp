<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add election</title>
<style type="text/css">
		*{
             padding: 9px;
             margin: 0;
             box-sizing: border-box;
            }
            body{
                background-color: lightBlue;
                height: 100%;
                background-repeat:no-repeat;
                background-size: cover;
                background-position: center;
                box-sizing: border-box;
            }
            .voter button{
                padding: 0.75em;
                border: none;
                outline: none;
                background-color: rgb(8, 8, 7);
                color: white;
                border-radius: 0.25em;
                opacity: 0.9;
            }

            .add{
                width: 382px;
                margin: auto;
                margin: 20 0 0 450px;
                padding: 20px;
                border-radius: 10px;
                background-color: aliceblue;
            }
            .voter button a{
                color: white;
            }
           .add button{
             padding: 0.75em;
             border: none;
             outline: none;
             background-color: rgb(1, 6, 8);
             color: white;
              border-radius: 0.25em;
             opacity: 0.9;
            }
        .add button:hover{
         cursor: pointer;
         background-color:rgb(140, 140, 151);
        }
        h1{
        text-align:center;
        }
        
</style>
</head>
<body>
<div class="voter">
	<h1>Election</h1>
    <form name="Election" action="AddElectionServlet" method="post">
            <div class="add">
              <label for="id"><b>Enter Election Id:</b> </label><br>
               <input type="number" name="id" placeholder="Election Id"><br><br>
               
               <label for="name"><b>Enter Election Name:</b></label><br>
               <input type="text" name="name" placeholder="Name"><br><br>
               
               <label for="date"><b>Enter Election Date:</b></label><br>
               <input type="date" name="Date" placeholder="Election Date"><br>
               <div>
               <button type="submit">Submit</button>&emsp;&emsp;&emsp;
               <button type="reset">Cancel</button><br>
               <INPUT TYPE="button" VALUE="Back" onClick="history.go(-1);">
            </div>
            </div>
            </form>
            </div>
</body>
</html>