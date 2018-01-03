package filter;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthServletFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		try {
			Context ctx = new InitialContext();

			Boolean checktoken = (Boolean)ctx.lookup("java:comp/env/security/checktoken");
			
			chain.doFilter(request, response);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}

}
