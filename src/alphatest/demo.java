package alphatest;

import org.apache.logging.log4j.*;

public class demo {

	// Creating object log. Ti initialize log object we need to call getlogger of
	// logmanager function.
	// Logmanager is an API and getlogger is a function of it.
	// Getlogger accepts the class arguments demo. 'Demo.class.getName()' will gets
	// the entire path of the Demo classs
	// and then we are throwing all these thing to log object and with that obj
	// logging our stuffs

	private static Logger log = LogManager.getLogger(demo.class.getName());

	public static void main(String[] args) {

		log.debug("Am debugging");

		log.info("Object is present");
		log.error("Object is no present");
		log.fatal("This is fatal");

	}

}
