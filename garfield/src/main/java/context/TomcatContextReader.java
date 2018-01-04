package context;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

public class TomcatContextReader implements ContextReader {

	final static Logger logger = Logger.getLogger(TomcatContextReader.class);
	
	private final Context ctx;
	
	private final Boolean DEFAULT_SECURITY_CHECK_TOKEN = true;
	private final String  CONTEXT_ENV_SECURITY_CHECK_TOKEN = "security/checktoken";
	
	public TomcatContextReader() throws NamingException {
		try {
			logger.debug("Initializing Tomcat context...");
			
			ctx = new InitialContext();
			
			logger.debug("Tomcat context initialized");
		} catch (NamingException ex) {
			logger.error("Tomcat initialization error");
			throw ex;			
		}
	}	
	
	@SuppressWarnings("unchecked")
	private <T> T readEnvironment(String name, T defaultvalue) {
		try {
			T lookup = (T) ctx.lookup("java:comp/env/" + name);
			return lookup;
		} catch (NamingException e) {
			logger.error("Missing environment setting: " + name);
			return defaultvalue;
		}
	}
	
	@Override
	public Boolean checkSecurityToken() {
		return readEnvironment(CONTEXT_ENV_SECURITY_CHECK_TOKEN, DEFAULT_SECURITY_CHECK_TOKEN);
	}

}
