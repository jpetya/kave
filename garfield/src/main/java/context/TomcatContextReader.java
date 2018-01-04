package context;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

public class TomcatContextReader implements ContextReader {

	final static Logger logger = Logger.getLogger(TomcatContextReader.class);
	
	private final Context ctx;
	
	private final Boolean DEFAULT_SECURITY_CHECK_TOKEN = true;
	private final String  CONTEXT_ENV_SECURITY_CHECK_TOKEN = "env/security/checktoken";
	
	public TomcatContextReader() throws NamingException {
		ctx = new InitialContext();
	}	
	
	@Override
	public Boolean checkSecurityToken() {
		try {
			return (Boolean)ctx.lookup("java:comp/" + CONTEXT_ENV_SECURITY_CHECK_TOKEN);
		} catch (NamingException e) {
			logger.error("Missing environment setting: " + CONTEXT_ENV_SECURITY_CHECK_TOKEN);
			return DEFAULT_SECURITY_CHECK_TOKEN;
		}
	}

}
