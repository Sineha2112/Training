package com.project.evotingsystemspring.myexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidNationalityException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	{
		 Logger logger = LoggerFactory.getLogger(InvalidNationalityException.class);
		logger.info("Sorry!!you are not an Indian");
	}
}
