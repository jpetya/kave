package web.pages.login;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginForm extends ActionForm {

	private static final long serialVersionUID = 2087662062683105570L;
	
	String userName;
	String password;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		if ( (this.userName == null) || (this.password == null) || this.userName.isEmpty() || this.password.isEmpty())
			errors.add("invaliduserpassword", new ActionMessage("err.login.invalid"));
		
		return errors;
		
	}
	
}
