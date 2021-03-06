package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.GenericFilterBean;

import context.ContextReader;

public class AuthServletFilter extends GenericFilterBean{

	public final static String HTTP_HEADER_SECURITY_TOKEN = "Security-Token";
	
	private boolean isWadlQuery(HttpServletRequest request) {
		String  query  = request.getQueryString();
		
		return (query != null) && query.equals("_wadl");
	}
	
	private boolean isSecurityTokenOK(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		boolean mustcheck = contextReader.checkSecurityToken(); 
		
		if (mustcheck) {
			String token = request.getHeader(HTTP_HEADER_SECURITY_TOKEN);
			
			if (token == null) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Security token is missing");
				return false;
			}
			else if (token.isEmpty()) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Security token is empty");
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest  servletRequest  = (HttpServletRequest)  request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		
		if (isWadlQuery(servletRequest)) 
			chain.doFilter(request, response);
		else
		if (isSecurityTokenOK(servletRequest, servletResponse))
			chain.doFilter(request, response);
	}
	
	@Autowired
	private ContextReader contextReader;

}
