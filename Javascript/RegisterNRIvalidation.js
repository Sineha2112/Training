var usernameError = document.getElementById("nameNRI-error");
var fatherNameError = document.getElementById("voterFname-error");
var voterPasswordError = document.getElementById("voterPassword-error");
var voterIdError = document.getElementById("voterIdNRI-error");
var addressError = document.getElementById("voterAddress-error");
var emailIdError = document.getElementById("EmailId-error");
var cityError = document.getElementById("voterCity-error");
var nationalityNRIError = document.getElementById("voterNationality-error");
var text;
function nameValid() {
    var voterName = document.getElementById("name").value;
    var nameValid = '^[A-Za-z]*$';
    if (voterName === 0 || voterName.trim() === "") {
        text = 'Name Cannot Be Empty';
        usernameError.innerHTML = text;
        return false;
    }
    if (voterName.length < 4) {
        text = 'Name Must Contain Greater Than 4 Characters';
        usernameError.innerHTML = text;
        return false;
    }
    if (!voterName.match(nameValid)) {
        text = 'Invalid Name';
        usernameError.innerHTML = text;
        return false;
    }
 	text='';
    usernameError.innerHTML = text;
    return true;
}
function passwordValidation() {
    var voterPassword = document.getElementById('password').value;
    let passwordValidation = /^.[A-Za-z0-9]{1,}[@#$!%^&?><]{1,}.*$/;
    if (voterPassword === null || voterPassword.trim() === "") {
        text = "Password Cannot Be Empty";
        voterPasswordError.innerHTML = text;
        return false;
    }
    if (!voterPassword.match(passwordValidation)) {
        text = "Password Should be more than 6 characters and Must Contain @";
        voterPasswordError.innerHTML = text;
        return false;
    }
 	text='';
    voterPasswordError.innerHTML = text;
    return true;
}
function voterIdValidation() {
    var voterNRIid = document.getElementById("voterId").value;
    let voterIdNRIvalidation ="^[A-Z]{3}[0-9]{7}$";
    if (voterNRIid === 0) {
        text = 'Voter Id Cannot Be Empty';
        voterIdError.innerHTML = text;
        return false;
    }
    if (voterNRIid.length < 10 || voterNRIid.length > 10) {
        text = 'Voter Id Must Conatin 3 Characters and 7 Digits';
        voterIdError.innerHTML = text;
        return false;
    }
    if (!voterNRIid.match(voterIdNRIvalidation)) {
        text = 'Invalid Voter Id';
        voterIdError.innerHTML = text;
        return false;
    }
 	text='';
    voterIdError.innerHTML = text;
    return true;
}
function emailIdValidation() {
    var emailId = document.getElementById("email").value;
    let emailIdValidation = "^(.+){5,50}[a-z,.-A-Z0-9\s]";
    if (emailId === 0) {
        text = ' Email Id Cannot Be Empty';
        emailIdError.innerHTML = text;
        return false;
    }
    if (emailId.length < 5 || emailId.length > 50) {
        text = ' Email Id Conatin minimum 5 and maximum 50 Characters';
        emailIdError.innerHTML = text;
        return false;
    }
    if (!emailId.match(emailIdValidation)) {
        text = 'Invalid Email Id';
        emailIdError.innerHTML = text;
        return false;
    }
 	text='';
    emailIdError.innerHTML = text;
    return true;
}
function addressValidation() {
    var	voterAddress = document.getElementById("address").value;
    let addressValidation = "^(.+){10,500}[a-z,.A-Z0-9s$\]";
    if (voterAddress === 0) {
        text = ' Address Cannot Be Empty and Must Include  ,.-numbers,a-zA-Z ';
        addressError.innerHTML = text;
        return false;
    }
    if (voterAddress.length < 10 || voterAddress.length > 500) {
        text = ' Address  Must Conatin minimum 10 and maximum 500 Characters';
        addressError.innerHTML = text;
        return false;
    }
    if (!voterAddress.match(addressValidation)) {
        text = 'Invalid Address';
        addressError.innerHTML = text;
        return false;
    }
 	text='';
    addressError.innerHTML = text;
    return true;
}
function fatherNameValid() {
    var fName = document.getElementById("fatherName").value;
    var fatherNameValid = '^[A-Za-z]*$';
    if (fName === 0 || fName.trim() === "") {
        text = 'Father Name Cannot Be Empty';
        fatherNameError.innerHTML = text;
        return false;
    }
    if (fName.length < 4) {
        text = 'Father Name Must Contain Greater Than 4 Characters';
        fatherNameError.innerHTML = text;
        return false;
    }
    if (!fName.match(fatherNameValid)) {
        text = 'Invalid Name';
        fatherNameError.innerHTML = text;
        return false;
    }
 	text='';
    fatherNameError.innerHTML = text;
    return true;
}
function cityValid() {
    var voterCity = document.getElementById("city").value;
    var cityValid = '^[A-Za-z]*$';
    if (voterCity === 0 || voterCity.trim() === "") {
        text = 'City Cannot Be Empty';
        cityError.innerHTML = text;
        return false;
    }
    if (!voterCity.match(cityValid)) {
        text = 'Invalid City Name';
        cityError.innerHTML = text;
        return false;
    }
 	text='';
    cityError.innerHTML = text;
    return true;
}
function nationalityValid(){
	var nationality = document.getElementById("nationality").value;
    if (nationality === 0 || nationality.trim() === "") {
        text = 'Nationality Cannot Be Empty';
        nationalityNRIError.innerHTML = text;
        return false;
    }
 	if(nationality !== "Indian"){
		text='You must be an Indian to Register';
		nationalityNRIError.innerHTML = text;
		return false;
}
	text='';
	nationalityNRIError.innerHTML = text;
    return true;
}
