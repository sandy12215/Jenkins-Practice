package Demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo {
	static Logger logger= LogManager.getLogger(Demo.class.getName());
	public static void log4jMethod(Integer i) {
		if(i==1) {
			logger.trace("tracking");
		}
		else if(i==2) {
			logger.info("started the test");
		}
		else if(i==3) {
			logger.info("validation");
		}
		else if(i==4) {
			logger.error("Error");
		}
		else if(i==5) {
			logger.warn("Warning");
		}
		else if(i==6) {
			logger.info("Stopping the test");
		}
	}
}
