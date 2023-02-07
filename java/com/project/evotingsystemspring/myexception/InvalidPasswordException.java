package com.project.evotingsystemspring.myexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidPasswordException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	{
		 Logger logger = LoggerFactory.getLogger(InvalidPasswordException.class);
		logger.info("Use strong password!!"+"\n"+"Must contain one lowercase,digit and one special character");
	}
}