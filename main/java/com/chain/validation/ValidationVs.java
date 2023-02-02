package com.chain.validation;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.regex.Matcher;

import java.util.regex.Pattern;
import com.chain.myexception.InvalidAddressException;
import com.chain.myexception.InvalidAgeException;
import com.chain.myexception.InvalidCityException;
import com.chain.myexception.InvalidDobException;
import com.chain.myexception.InvalidEmailIdException;
import com.chain.myexception.InvalidGenderException;
import com.chain.myexception.InvalidIdException;
import com.chain.myexception.InvalidMobileNoException;
import com.chain.myexception.InvalidNameException;
import com.chain.myexception.InvalidNationalityException;
import com.chain.myexception.InvalidPasswordException;
import com.chain.myexception.InvalidVoterIdException;

public class ValidationVs {
	public  boolean nameValidation(String name) throws InvalidNameException {
		String regex="[A-Za-z]+";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(name);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else
			throw new InvalidNameException();
	}
	public  boolean emailValidation(String email) throws InvalidEmailIdException   {
		String regex="^[a-zA-Z0-9+.-]+@[a-zA-Z+.-]+$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(email);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else
			throw new InvalidEmailIdException();
	}
	public  boolean phoneNoValidation(Long mobileNumber) throws InvalidMobileNoException {
		String regex="\\d{10}";
		String phoneNo1=Long.toString(mobileNumber);
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(phoneNo1);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else
			throw new InvalidMobileNoException();
	}
	/*public int ageValidation(String dob) throws InvalidAgeException {
		LocalDate today=LocalDate.now();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		dtf.format(dob);
		String format=dtf.format(dob);
		LocalDate birthday=LocalDate.parse(dob);
		int i=today.compareTo(birthday);
		if (i>18) {
			return i;
		}
		else {
			throw new InvalidAgeException();
		}
	}*/
	
	public boolean voterIdValidation(String voterId) throws InvalidVoterIdException {
		String regex="^[A-Z]{3}[0-9]{7}$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(voterId);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else
			throw new InvalidVoterIdException();
	}
	public int ageValidation(String dob) throws InvalidAgeException {
		LocalDate today=LocalDate.now();
		LocalDate birthday=LocalDate.parse(dob);
		int i=today.compareTo(birthday); 
		if (i>=18) {
			return i;
		}
		else {
			throw new InvalidAgeException();
		}
	}
	public boolean dateOfBirthValidation(String dob) throws InvalidDobException {
		//String regex="^(0?[1-9]|[12]\\d|3[01])[\\/\\-](0?[1-9]|1[012])[\/\-]\\d{4}$";
//String regex="^(?:0[1-9]|[12][0-9]|3[01])[-/.](?:0[1-9]|1[012])[-/.](?:19\\d{2}|20[01][0-9]|2023)\\b";
		String regex="([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(dob);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else
			throw new InvalidDobException();
	}
	public boolean passwordValidation(String password) throws InvalidPasswordException {
		String regex="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(password);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else
			throw new InvalidPasswordException();
	}
	public boolean addressValidation(String address) throws InvalidAddressException {
		String regex="^[0-9a-zA-Z\\s,-]+$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(address);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else
			throw new InvalidAddressException();
	}
	public boolean genderValidation(String gender) throws InvalidGenderException{
		String regex="^([M|m]ale|[F|f]emale|[T|t]ransgender)$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(gender);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else
			throw new InvalidGenderException();
	}
	public boolean cityValidation(String city) throws InvalidCityException {
		String regex="^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(city);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else
			throw new InvalidCityException();
	}
	public boolean nationalityValidation(String nationality) throws InvalidNationalityException {
		if(nationality.equals("Indian")) {
			return true;
		}
		else
			throw new InvalidNationalityException();
	}
	public boolean fatherNameValidation(String name1) throws InvalidNameException {
		String regex="[A-Za-z]+";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(name1);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else
			throw new InvalidNameException();
	}
	public boolean cNameValidation(String candidateName) throws InvalidNameException {
		String regex="[A-Za-z]+";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(candidateName);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else
			throw new InvalidNameException();
	}
	public boolean stateValidation(String state) throws InvalidNameException {
		String regex="[A-Za-z]+";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(state);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else
			throw new InvalidNameException();
	}
	public boolean idValidation(Integer id) throws InvalidIdException {
		String regex="\\d{3}";
		String id1=Long.toString(id);
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(id1);
		Boolean b=m.matches();
		if(b) {
			return true;
		}
		else
			throw new InvalidIdException();
	}
}
