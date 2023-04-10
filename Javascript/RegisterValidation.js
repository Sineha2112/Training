var nameError = document.getElementById("name-error");
var fnameError = document.getElementById("fname-error");
var passwordError = document.getElementById("password-error");
var mobileNoError = document.getElementById("mobileNo-error");
var voterIdError = document.getElementById("voterId-error");
var addressError = document.getElementById("address-error");
var mailIdError = document.getElementById("mailId-error");
var cityError = document.getElementById("city-error");
var nationalityError = document.getElementById("nationality-error");
var text;
function nameValid() {
	var userName = document.getElementById("name").value;
	var nameValid = '^[A-Za-z]*$';
	if (userName === 0 || userName.trim() === "") {
		text = 'Name Cannot Be Empty';
		nameError.innerHTML = text;
		return false;
	}
	if (userName.length < 4) {
		text = 'Name Must Contain Greater Than 4 Characters';
		nameError.innerHTML = text;
		return false;
	}
	if (!userName.match(nameValid)) {
		text = 'Invalid Name';
		nameError.innerHTML = text;
		return false;
	}
	text = '';
	nameError.innerHTML = text;
	return true;
}
function passwordValidation() {
	var password = document.getElementById('password').value;
	let passwordValidation = /^.[A-Za-z0-9]{1,}[@#$!%^&?><]{1,}.*$/;
	if (password === null || password.trim() === "") {
		text = "Password Cannot Be Empty";
		passwordError.innerHTML = text;
		return false;
	}
	if (!password.match(passwordValidation)) {
		text = "Password Should be more than 6 characters and Must Contain @";
		passwordError.innerHTML = text;
		return false;
	}
	text = '';
	passwordError.innerHTML = text;
	return true;
}
function mobileNoValidation1() {
	var mobileNo = document.getElementById("mobileNumber").value;
	let mobileNoValidation1 = "[6-9][0-9]{9}";
	if (mobileNo === 0) {
		text = 'Mobile Number Cannot Be Empty';
		mobileNoError.innerHTML = text;
		return false;
	}
	if (mobileNo.length < 10 || mobileNo.length > 10) {
		text = 'Mobile Number Must Conatin 10 Digits';
		mobileNoError.innerHTML = text;
		return false;
	}
	if (!mobileNo.match(mobileNoValidation1)) {
		text = 'Invalid Mobile Number';
		mobileNoError.innerHTML = text;
		return false;
	}
	text = '';
	mobileNoError.innerHTML = text;
	return true;
}
function voterIdValidation() {
	var voterId = document.getElementById("voterId").value;
	let voterIdValidation = "^[A-Z]{3}[0-9]{7}$";
	if (voterId === 0) {
		text = 'Voter Id Cannot Be Empty';
		voterIdError.innerHTML = text;
		return false;
	}
	if (voterId.length < 10 || voterId.length > 10) {
		text = 'Voter Id Must Conatin 3 Characters and 7 Digits';
		voterIdError.innerHTML = text;
		return false;
	}
	if (!voterId.match(voterIdValidation)) {
		text = 'Invalid Voter Id';
		voterIdError.innerHTML = text;
		return false;
	}
	text = '';
	voterIdError.innerHTML = text;
	return true;
}
function mailIdValidation() {
	var mailId = document.getElementById("email").value;
	let mailIdValidation = "^(.+){5,50}[a-z,.-A-Z0-9\s]";
	if (mailId === 0) {
		text = ' Email Id Cannot Be Empty';
		mailIdError.innerHTML = text;
		return false;
	}
	if (mailId.length < 5 || mailId.length > 50) {
		text = ' Email Id Conatin minimum 5 and maximum 50 Characters';
		mailIdError.innerHTML = text;
		return false;
	}
	if (!mailId.match(mailIdValidation)) {
		text = 'Invalid Email Id';
		mailIdError.innerHTML = text;
		return false;
	}
	text = '';
	mailIdError.innerHTML = text;
	return true;
}
function addressValidation() {
	var address = document.getElementById("address").value;
	let addressValidation1 = "^(.+){10,500}[a-z,.A-Z0-9s$\]";
	if (address === 0) {
		text = ' Address Cannot Be Empty and Must Include  ,.-numbers,a-zA-Z ';
		addressError.innerHTML = text;
		return false;
	}
	if (address.length < 10 || address.length > 500) {
		text = ' Address  Must Conatin minimum 10 and maximum 500 Characters';
		addressError.innerHTML = text;
		return false;
	}
	if (!address.match(addressValidation1)) {
		text = 'Invalid Address';
		addressError.innerHTML = text;
		return false;
	}
	text = '';
	addressError.innerHTML = text;
	return true;
}
function fatherNameValid() {
	var fatherName = document.getElementById("fatherName").value;
	var fNameValid = '^[A-Za-z]*$';
	if (fatherName === 0 || fatherName.trim() === "") {
		text = 'Father Name Cannot Be Empty';
		fnameError.innerHTML = text;
		return false;
	}
	if (fatherName.length < 4) {
		text = 'Father Name Must Contain Greater Than 4 Characters';
		fnameError.innerHTML = text;
		return false;
	}
	if (!fatherName.match(fNameValid)) {
		text = 'Invalid Name';
		fnameError.innerHTML = text;
		return false;
	}
	text = '';
	fnameError.innerHTML = text;
	return true;
}
function cityValid() {
	var city = document.getElementById("city").value;
	var cityValid = '^[A-Za-z]*$';
	if (city === 0 || city.trim() === "") {
		text = 'City Cannot Be Empty';
		cityError.innerHTML = text;
		return false;
	}
	if (!city.match(cityValid)) {
		text = 'Invalid City Name';
		cityError.innerHTML = text;
		return false;
	}
	text = '';
	cityError.innerHTML = text;
	return true;
}
function nationalityValid() {
	var nationality = document.getElementById("nationality").value;
	if (nationality === 0 || nationality.trim() === "") {
		text = 'Nationality Cannot Be Empty';
		nationalityError.innerHTML = text;
		return false;
	}
	if (nationality !== "Indian") {
		text = 'You must be an Indian to Register';
		nationalityError.innerHTML = text;
		return false;
	}
	text = '';
	nationalityError.innerHTML = text;
	return true;
}
function formValidate() {
	if (!nameValid() || !mobileNoValidation1() || !voterIdValidation() || !mailIdValidation() || !passwordValidation()
		|| !nationalityValid() || !addressValidation() || !fatherNameValid() || !cityValid()) {
		submitError.style.display = 'block';
		submitError.innerHTML = 'Please Fix Above Error To Submit! ';
		setTimeout(function() { submitError.style.display = 'none'; }, 3000)
		return false;
	}
	alert('Registration Successfull');
	return true;

}
