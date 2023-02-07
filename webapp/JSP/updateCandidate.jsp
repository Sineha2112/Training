<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
            .voter button{
                padding: 0.75em;
                border: none;
                outline: none;
                background-color: rgb(8, 8, 7);
                color: white;
                border-radius: 0.25em;
                opacity: 0.9;
            }

            .update{
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
           .update button{
             padding: 0.75em;
             border: none;
             outline: none;
             background-color: rgb(1, 6, 8);
             color: white;
              border-radius: 0.25em;
             opacity: 0.9;
            }
        .update button:hover{
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
	<h2>Update Candidate Details</h2>
	<form  name="updateForm" action="/updateCandidates" method="post">
	<div class="update">
	<label for="id"><b>Enter Candidate Id:</b></label><br>
    <input type="number" name="id" placeholder="Candidate Id" required id="id"><br><br>
           
    <label for="changeData"><b>Enter Data To Be Updated:</b></label><br>
    <input type="text" name="changeData" placeholder="Changing Data" id="changeData"><br><br>
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