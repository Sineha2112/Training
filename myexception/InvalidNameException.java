package com.project.evotingsystemspring.myexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidNameException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static{
		 Logger logger = LoggerFactory.getLogger(InvalidNameException.class);
		 logger.info("Invalid name!"+"\n"+"Use only alphabets");
	}
}
