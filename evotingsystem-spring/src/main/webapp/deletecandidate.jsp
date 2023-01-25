<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Candidate</title>
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

            .delete{
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
           .delete button{
             padding: 0.75em;
             border: none;
             outline: none;
             background-color: rgb(1, 6, 8);
             color: white;
              border-radius: 0.25em;
             opacity: 0.9;
            }
        .delete button:hover{
         cursor: pointer;
         background-color:rgb(140, 140, 151);
        }
        h2{
        text-align:center;
        }
        
</style>
</head>
<body>
<div class="voter">
	<h2>Delete Candidate </h2>
	<form  name="deleteForm" action="DeleteCandidateServlet" method="post">
	<div class="delete">
	<label for="id"><b>Enter Candidate Id:</b></label><br><br>
    <input type="number" name="id" placeholder="Candidate Id" required id="id"><br><br>
          
    <div>
    <button type="submit">Submit</button>&emsp;&emsp;&emsp;
    <button type="reset">Cancel</button>
    </div><br>
    <input TYPE="button" VALUE="Back" onClick="history.go(-1);">
    </div>
	</form>
	</div>
</body>
</html>