package com.project.evotingsystemspring.myexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlreadyVotedException extends Exception{

	private static final long serialVersionUID = 1L;
	static{
		 Logger logger = LoggerFactory.getLogger(DuplicationOfMailException.class);
		 logger.info("You  Have Already Voted");
	}

}
