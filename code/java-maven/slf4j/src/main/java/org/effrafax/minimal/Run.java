package org.effrafax.minimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Run {

	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(Run.class);
		logger.debug("logging at level debug");
		logger.info("logging at level info");
		logger.warn("logging at level warn");
		logger.error("logging at level error");
	}
}
