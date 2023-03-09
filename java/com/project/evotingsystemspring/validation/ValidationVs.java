package com.project.evotingsystemspring.validation;

import java.sql.Date;
import java.time.LocalDate;
import java.util.regex.Matcher;

import java.util.regex.Pattern;

import com.project.evotingsystemspring.myexception.InvalidAddressException;
import com.project.evotingsystemspring.myexception.InvalidAgeException;
import com.project.evotingsystemspring.myexception.InvalidCityException;
import com.project.evotingsystemspring.myexception.InvalidDobException;
import com.project.evotingsystemspring.myexception.InvalidEmailIdException;
import com.project.evotingsystemspring.myexception.InvalidGenderException;
import com.project.evotingsystemspring.myexception.InvalidMobileNoException;
import com.project.evotingsystemspring.myexception.InvalidNameException;
import com.project.evotingsystemspring.myexception.InvalidNationalityException;
import com.project.evotingsystemspring.myexception.InvalidPasswordException;
import com.project.evotingsystemspring.myexception.InvalidVoterIdException;

public class ValidationVs {
	
	String nameRegex="[A-Za-z]+";
	public  boolean nameValidation(String name) throws InvalidNameException {
		
		Pattern p=Pattern.compile(nameRegex);
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
	
	public boolean voterIdValidation(String voterId) throws InvalidVoterIdException {
		String regex="^[A-Z]{3}\\d{7}$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(voterId);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else
			throw new InvalidVoterIdException();
	}
	
	public int ageValidation(Date dob) throws InvalidAgeException {
		LocalDate today=LocalDate.now();
		String dob1=dob.toString();
		LocalDate birthday=LocalDate.parse( dob1);
		int i=today.compareTo(birthday); 
		if (i>=18) {
			return i;
		}
		else {
			throw new InvalidAgeException();
		}
	}
	
	public boolean dateOfBirthValidation(Date dob) throws InvalidDobException {
		String regex="([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
		String dob1=dob.toString();
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher( dob1);
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
		String regex="([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)";
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
		
		Pattern p=Pattern.compile(nameRegex);
		Matcher m=p.matcher(name1);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else
			throw new InvalidNameException();
	}
	
	public boolean cNameValidation(String candidateName) throws InvalidNameException {
		
		Pattern p=Pattern.compile(nameRegex);
		Matcher m=p.matcher(candidateName);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else
			throw new InvalidNameException();
	}
	
	public boolean stateValidation(String state) throws InvalidNameException {
		String regex="([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)" ; 
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(state);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else
			throw new InvalidNameException();
	}
	
	
}
