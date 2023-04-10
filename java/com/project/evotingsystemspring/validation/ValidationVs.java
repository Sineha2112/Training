package com.project.evotingsystemspring.validation;

import java.sql.Date;
import java.time.LocalDate;
import java.util.regex.Matcher;

import java.util.regex.Pattern;

import org.springframework.ui.Model;


public class ValidationVs {
	
	String nameRegex="[A-Za-z]+";
	public  boolean nameValidation(String name,Model model) {
		
		Pattern p=Pattern.compile(nameRegex);
		Matcher m=p.matcher(name);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else {
			String errorMessage = "Name should contains only letters ";
			model.addAttribute("errorMessage1", errorMessage);
			return false;
		}
	}
	
	public  boolean emailValidation(String email,Model model)   {
		String regex="^[a-zA-Z0-9+.-]+@[a-zA-Z+.-]+$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(email);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else {
			String errorMessage = "Email should contains only letters ";
			model.addAttribute("errorMessage2", errorMessage);
			return false;
		}
	}
	
	public  boolean phoneNoValidation(Long mobileNumber,Model model) {
		String regex="\\d{10}";
		String phoneNo1=Long.toString(mobileNumber);
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(phoneNo1);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else {
			String errorMessage = "Mobile Number must contain 10 numbers ";
			model.addAttribute("errorMessage3", errorMessage);
			return false;
		}
			
	}
	
	public boolean voterIdValidation(String voterId,Model model)  {
		String regex="^[A-Z]{3}\\d{7}$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(voterId);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else {
			String errorMessage = "Gender must be within this option ";
			model.addAttribute("errorMessage4", errorMessage);
			return false;
		}
			
	}
	
	public boolean dateOfBirthValidation(Date dob,Model model){
		String regex="([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
		String dob1=dob.toString();
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher( dob1);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else {
			String errorMessage = "Date of birth should be in 'dd/mm/yyyy' format";
			model.addAttribute("errorMessage5", errorMessage);
			return false;
		}	
	}
	
	public int ageCalculator(Date dob){
		LocalDate today=LocalDate.now();
		String dob1=dob.toString();
		LocalDate birthday=LocalDate.parse( dob1);
		return today.compareTo(birthday);
	}
	
	public boolean ageValidation(Integer age,Model model) {
		if (age>=18) {
			return true;
		}
		else {
			String errorMessage = "Age should be greater than 18 to register ";
			model.addAttribute("errorMessage6", errorMessage);
			return false;
		}
	}
	
	public boolean passwordValidation(String password,Model model)  {
		String regex="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(password);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else {
			String errorMessage = "Password must contain atleast 8 characters and have one uppercase,one lowercase and a special character";
			model.addAttribute("errorMessage7", errorMessage);
			return false;
		}
	}
	
	public boolean addressValidation(String address,Model model)  {
		String regex="^[0-9a-zA-Z\\s,-]+$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(address);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else {
			String errorMessage = "Invalid address!!"+"\n"+"must contain door number and Valid street name ";
			model.addAttribute("errorMessage8", errorMessage);
			return false;
		}
			
	}
	
	public boolean genderValidation(String gender,Model model) {
		String regex="^([M|m]ale|[F|f]emale|[P|p]refer not to say)$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(gender);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else {
			String errorMessage = "Gender must be within this option ";
			model.addAttribute("errorMessage9", errorMessage);
			return false;
		}
			
	}
	
	public boolean cityValidation(String city,Model model)  {
		String regex="([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(city);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else {
			String errorMessage = "City name should contains only letters";
			model.addAttribute("errorMessage10", errorMessage);
			return false;
		}
			
	}
	
	public boolean nationalityValidation(String nationality,Model model) {
		if(nationality.equals("Indian")) {
			return true;
		}
		else {
			String errorMessage = "You must be an Indian to register";
			model.addAttribute("errorMessage11", errorMessage);
			return false;
		}
			
	}
	
	public boolean fatherNameValidation(String name1,Model model) {
		
		Pattern p=Pattern.compile(nameRegex);
		Matcher m=p.matcher(name1);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else {
			String errorMessage = "Father Name contains only letters ";
			model.addAttribute("errorMessage12", errorMessage);
			return false;
		}
	}
	
	public boolean cNameValidation(String candidateName,Model model)  {
		
		Pattern p=Pattern.compile(nameRegex);
		Matcher m=p.matcher(candidateName);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else {
			String errorMessage = " Name should have letters only ";
			model.addAttribute("errorMessage13", errorMessage);
			return false;
		}
			
	}
	
	public boolean stateValidation(String state,Model model)  {
		String regex="([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)" ; 
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(state);
		Boolean b=m.matches();
		if(Boolean.TRUE.equals(b)) {
			return true;
		}
		else {
			String errorMessage = "State Name must have only letters ";
			model.addAttribute("errorMessage14", errorMessage);
			return false;
		}
	}
	
	public boolean candidateAgeValidation(Integer age,Model model) {
		if (age>=25) {
			return true;
		}
		else {
			String errorMessage = "Age should be greater than 25 to participate in the election ";
			model.addAttribute("errorMessage15", errorMessage);
			return false;
		}
	}
	
	
}
