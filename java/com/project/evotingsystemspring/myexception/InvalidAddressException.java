package com.project.evotingsystemspring.myexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidAddressException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	{
		 Logger logger = LoggerFactory.getLogger(InvalidAddressException.class);
		 logger.info("Invalid address!!"+"\n"+"must use # with door number and Valid street name");
	}
}
