package petshop.login;

import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	
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
	
}
