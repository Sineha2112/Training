package com.project.evotingsystemspring.myexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidEmailIdException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	{
		 Logger logger = LoggerFactory.getLogger(InvalidEmailIdException.class);
		logger.info("Invalid email id!!"+"\n"+"Mail id should be in characters with one @symbol");
	}
}
