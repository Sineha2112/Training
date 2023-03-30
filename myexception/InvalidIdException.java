package com.project.evotingsystemspring.myexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidIdException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static{
		 Logger logger = LoggerFactory.getLogger(InvalidIdException.class);
		logger.info("Invalid ID!"+"\n"+"must contain positive numbers only");
	}
}
