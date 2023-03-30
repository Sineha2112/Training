package com.project.evotingsystemspring.myexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidMobileNoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static{
		 Logger logger = LoggerFactory.getLogger(InvalidMobileNoException.class);
		logger.info("Invalid phone number!"+"\n"+"Must contain 10 numbers");
	}
}
