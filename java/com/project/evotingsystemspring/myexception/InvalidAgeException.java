package com.project.evotingsystemspring.myexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidAgeException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	{
		 Logger logger = LoggerFactory.getLogger(InvalidAgeException.class);
		logger.info("Sorry!!Your age is less than 18.You can't vote");
	}
}
