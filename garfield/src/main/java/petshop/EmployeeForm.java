package petshop;

import org.apache.struts.action.ActionForm;

public class EmployeeForm extends ActionForm {
	
	private static final long serialVersionUID = 493735790379355740L;

	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
