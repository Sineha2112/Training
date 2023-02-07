package com.project.evotingsystemspring.myexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DuplicationOfMobileNoException extends Exception {
	
	private static final long serialVersionUID = 1L;

	{
	 Logger logger = LoggerFactory.getLogger(DuplicationOfMobileNoException.class);
	 logger.info("Mobile Number already Exist");
	}

}
