<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cast Vote</title>
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

            .cast{
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
           .cast button{
             padding: 0.75em;
             border: none;
             outline: none;
             background-color: rgb(1, 6, 8);
             color: white;
              border-radius: 0.25em;
             opacity: 0.9;
            }
        .cast button:hover{
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
	<h1>Voting Process</h1>
	<form name="castVote" action="CastVoteServlet" method="post">
	<div class="cast">
	<label for="name"><b>Select Election Name:</b></label><br>
    <select name="electionName" id="electionName">
	  	<option value="PM Selection">PM Selection</option>
	 	<option value="None">None</option>
	</select><br><br>
    
    <label for="type"><b>Select Your Type:</b></label><br>
     <select name="type" id="type">
	  	<option value="RVoter">Resident Voter</option>
	 	<option value="NResidentVoter">Non-ResidentVoter</option>
	</select><br><br>
	
	<label for="id"><b>Enter User Id:</b></label><br>
    <input type="number" name="id" placeholder="User Id" required id="id"><br><br>
              
    <label for="partyName"><b>Select Party Name:</b></label><br>
   	<select name="partyName" id="partyName">
	  	<option value="AIADMK">AIADMK</option>
	 	 <option value="DMK">DMK</option>
	  	<option value="PMK">PMK</option>
	 	 <option value="DMDK">DMDK</option>
	 	 <option value="MDMK">MDMK</option>
	 	 <option value="BJP">BJP</option>
	 	 <option value="TNCC">TNCC</option>
	 	 <option value="VCK">VCK</option>
	</select><br><br>
   
    <input type="checkbox" name="vote" value="vote" > Vote<br>
                        
    <form name="vote" action="" method="post">
   		<button type="submit">Submit</button>
   		</form>
        <button type="reset">Cancel</button>
        <input TYPE="button" VALUE="Back" onClick="history.go(-1);">
        </div>
	</form>
	</div>
</body>
</html>