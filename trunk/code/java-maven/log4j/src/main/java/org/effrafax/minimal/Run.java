package org.effrafax.minimal;

import org.apache.log4j.Logger;

public class Run
{
	public static void main(String[] args)
	{
		Logger logger = Logger.getLogger(Run.class);
		logger.debug("logging at level debug");
		logger.info("logging at level info");
		logger.warn("logging at level warn");
		logger.error("logging at level error");
		logger.fatal("logging at level fatal");
	}
}
