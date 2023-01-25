<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedback</title>
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

            .feed{
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
           .feed button{
             padding: 0.75em;
             border: none;
             outline: none;
             background-color: rgb(1, 6, 8);
             color: white;
              border-radius: 0.25em;
             opacity: 0.9;
            }
        .feed button:hover{
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
	<h1>Feedback</h1>
	<form name="feedback" action="FeedbackServlet" method="post">
	<div class="feed">
	<label for="id"><b>Enter User Id:</b></label><br>
    <input type="number" name="id" placeholder="User Id" required id="id"><br><br>
              
    <label for="feedback"><b>Enter FeedBack:</b></label><br>
    <input type="text" name="feedback" placeholder="Feedback" id="feedback"><br><br>
    
    <div>
   		<button type="submit">Submit</button>&emsp;&emsp;&emsp;
        <button type="reset">Cancel</button>
        </div><br>
        <input TYPE="button" VALUE="Back" onClick="history.go(-1);">
       </div>
       </div>
	</form>
	</div>
</body>
</html>