package petshop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class EmployeeAction extends Action {

	final static Logger logger = Logger.getLogger(EmployeeAction.class); 
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		logger.debug("EmployeeAction.execute");
		
		EmployeeForm employeeForm = (EmployeeForm) form;
		employeeForm.setMessage("Hello World! Struts");		
		
        return mapping.findForward("success");
    }
	 
}
