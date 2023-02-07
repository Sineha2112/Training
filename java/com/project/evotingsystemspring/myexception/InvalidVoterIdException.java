package com.project.evotingsystemspring.myexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidVoterIdException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	{
		 Logger logger = LoggerFactory.getLogger(InvalidVoterIdException.class);
		logger.info("Invalid Voter Id number!!"+"\n"+"Must contain 3 characters and number");
	}

}
