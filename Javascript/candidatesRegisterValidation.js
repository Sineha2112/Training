var candidateNameError = document.getElementById("candidateName-error");
var partyNameError = document.getElementById("partyName-error");
var partySymbolError = document.getElementById("partySymbol-error");
var candidateMobileNoError = document.getElementById("candidateMobileNo-error");
var ageError = document.getElementById("age-error");
var candidateAddressError = document.getElementById("candidateAddress-error");
var candidateEmailIdError = document.getElementById("candidateEmailId-error");
var candidateCityError = document.getElementById("candidateCity-error");
var nationalityIError = document.getElementById("candidateNationality-error");
var text;
function candidateNameValid() {
	var candidateName = document.getElementById("name").value;
	var nameValid = '^[A-Za-z]*$';
	if (candidateName === 0 || candidateName.trim() === "") {
		text = 'Name Cannot Be Empty';
		candidateNameError.innerHTML = text;
		return false;
	}
	if (candidateName.length < 2) {
		text = 'Name Must Contain Greater Than 2 Characters';
		candidateNameError.innerHTML = text;
		return false;
	}
	if (!candidateName.match(nameValid)) {
		text = 'Invalid Name';
		candidateNameError.innerHTML = text;
		return false;
	}
	text = '';
	candidateName.innerHTML = text;
	return true;
}
function ageValidation() {
	var age = document.getElementById("age").value;
	if (age === 0 || age.trim() === "") {
		text = 'Age cannot be empty';
		ageError.innerHTML = text;
		return false;
	}
	text = '';
	ageError.innerHTML = text;
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
	text = '';
	voterPasswordError.innerHTML = text;
	return true;
}
function partySymbolValidation() {
	var partySymbol = document.getElementById("partySymbol").value;
	let symbolValidation = "^[A-Z a-z]*$";
	if (partySymbol === 0) {
		text = 'Party Symbol Cannot Be Empty';
		partySymbolError.innerHTML = text;
		return false;
	}
	if (partySymbol.length < 2) {
		text = 'Party Symbol must be greater than 2 characters';
		partySymbolError.innerHTML = text;
		return false;
	}
	if (!partySymbol.match(symbolValidation)) {
		text = 'Invalid Party Symbol Name';
		partySymbolError.innerHTML = text;
		return false;
	}
	text = '';
	partySymbolError.innerHTML = text;
	return true;
}
function emailIdValidation() {
	var candidateEmailId = document.getElementById("email").value;
	let emailIdValidation = "^(.+){5,50}[a-z,.-A-Z0-9\s]";
	if (candidateEmailId === 0) {
		text = ' Email Id Cannot Be Empty';
		candidateEmailIdError.innerHTML = text;
		return false;
	}
	if (candidateEmailId.length < 5 || candidateEmailId.length > 50) {
		text = ' Email Id Conatin minimum 5 and maximum 50 Characters';
		candidateEmailIdError.innerHTML = text;
		return false;
	}
	if (!candidateEmailId.match(emailIdValidation)) {
		text = 'Invalid Email Id';
		candidateEmailIdError.innerHTML = text;
		return false;
	}
	text = '';
	candidateEmailIdError.innerHTML = text;
	return true;
}
function candidateAddressValidation() {
	var candidateAddress = document.getElementById("address").value;
	let addressValidation1 = "^(.+){10,500}[a-z,.A-Z0-9s$\]";
	if (candidateAddress === 0) {
		text = ' Address Cannot Be Empty and Must Include  ,.-numbers,a-zA-Z ';
		candidateAddressError.innerHTML = text;
		return false;
	}
	if (candidateAddress.length < 10 || candidateAddress.length > 500) {
		text = ' Address  Must Conatin minimum 10 and maximum 500 Characters';
		candidateAddressError.innerHTML = text;
		return false;
	}
	if (!candidateAddress.match(addressValidation1)) {
		text = 'Invalid Address';
		candidateAddressError.innerHTML = text;
		return false;
	}
	text = '';
	candidateAddressError.innerHTML = text;
	return true;
}
function partyNameValid() {
	var partyName = document.getElementById("partyName").value;
	var pNameValid = '^[A-Z]*$';
	if (partyName === 0 || partyName.trim() === "") {
		text = 'Party Name Cannot Be Empty';
		partyNameError.innerHTML = text;
		return false;
	}
	if (partyName.length < 2) {
		text = 'Party Name Must Contain Greater Than 2 Characters';
		partyNameError.innerHTML = text;
		return false;
	}
	if (!partyName.match(pNameValid)) {
		text = 'Invalid Party Name';
		partyNameError.innerHTML = text;
		return false;
	}
	text = '';
	partyNameError.innerHTML = text;
	return true;
}
function candidateCityValid() {
	var candidateCity = document.getElementById("city").value;
	var cityValid = '^[A-Za-z]*$';
	if (candidateCity === 0 || candidateCity.trim() === "") {
		text = 'City Cannot Be Empty';
		candidateCityError.innerHTML = text;
		return false;
	}
	if (!candidateCity.match(cityValid)) {
		text = 'Invalid City Name';
		candidateCityError.innerHTML = text;
		return false;
	}
	text = '';
	candidateCityError.innerHTML = text;
	return true;
}
function nationalityValid() {
	var candidateNationality = document.getElementById("nationality").value;
	if (candidateNationality === 0 || candidateNationality.trim() === "") {
		text = 'Nationality Cannot Be Empty';
		nationalityIError.innerHTML = text;
		return false;
	}
	if (candidateNationality !== "Indian") {
		text = 'You must be an Indian to Register';
		nationalityIError.innerHTML = text;
		return false;
	}
	text = '';
	nationalityIError.innerHTML = text;
	return true;
}
function mobileNoValidation1() {
	var candidateMobileNo = document.getElementById("mobileNumber").value;
	let mobileNoValidation1 = "[6-9][0-9]{9}";
	if (candidateMobileNo === 0) {
		text = 'Mobile Number Cannot Be Empty';
		candidateMobileNoError.innerHTML = text;
		return false;
	}
	if (candidateMobileNo.length < 10 || candidateMobileNo.length > 10) {
		text = 'Mobile Number Must Conatin 10 Digits';
		candidateMobileNoError.innerHTML = text;
		return false;
	}
	if (!candidateMobileNo.match(mobileNoValidation1)) {
		text = 'Invalid Mobile Number';
		candidateMobileNoError.innerHTML = text;
		return false;
	}
	text = '';
	candidateMobileNoError.innerHTML = text;
	return true;
}
