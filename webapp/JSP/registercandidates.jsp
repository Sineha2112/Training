<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Candidates</title>
</head>
<body>
<h2>Add Candidates</h2>
	<form id="uploadfile" name="uploadfile" action="/regCandidates" method="post">
            <div class="container">
                <label for="name"><b>Enter Candidate Name:</b></label><br>
                <input type="text" name="name" placeholder="Name" required id="name"><br><br>
                
                <label for="partyName"><b>Enter Party Name:</b></label><br>
                <input type="text" name="partyName" placeholder="Party Name" id="partyName"><br><br> 
                
                <label for="partySymbol"><b>Enter Party Symbol Name:</b></label><br>
                <input type="text" name="partySymbol" placeholder="Party Symbol" id="partySymbol"><br><br>
                
                <div>
                    <label for="gender"><b>Enter Gender:</b></label><br>
                    <input type="checkbox" name="gender" value="male" > Male
                    <input type="checkbox" name="gender" value="female"> Female
                    <input type="checkbox" name="gender" value="prefer not to say">Prefer not to say<br><br>
                </div>
                
                <label for="age"><b>Enter Age:</b></label><br>
                <input type="number" name="age" placeholder="Age" id="age"><br><br>
                
                       
                <label for="address"><b>Enter Address:</b></label><br>
                <input type="text" name="address" placeholder="Address" id="address"><br><br>
                
                <label for="city"><b>Enter City:</b></label><br>
                <input type="text" name="city" placeholder="City" id="city"><br><br>
                
                <label for="Nationality"><b>Enter Nationality:</b></label><br>
                <input type="text" name="nationality" placeholder="Nationality" id="nationality"><br><br>
                
                <label for="mobileNumber"><b>Enter Mobile Number:</b></label><br>
                <input type="tel" name="mobileNumber" placeholder="Mobile Number" id="mobileNumber"><br><br>
                
                <label for="email"><b>Enter Email Id:</b></label><br>
                <input type="email" name="email" placeholder="Email Id" id="email"><br><br>
                
            	<label for="pdf"><b>Upload File</b></label>
            	<input type="file" name="file" placeholder="File" id="file">
            	<input type="submit">
                
                <div>
                    <button type="submit">Submit</button>&emsp;&emsp;&emsp;
                    <button type="reset">Cancel</button>
                </div><br>
                    <input TYPE="button" VALUE="Back" onClick="history.go(-1);">
                </div>
        </form>
</body>
</html>