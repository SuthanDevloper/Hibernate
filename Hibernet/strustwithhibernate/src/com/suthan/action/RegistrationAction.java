package com.suthan.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.suthan.formbeans.RegistrationActionForm;
import com.suthan.pojo.Employee;
import com.suthan.service.EmployeeService;

public class RegistrationAction extends Action {


	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String status ="";
		
		RegistrationActionForm  actionform=(RegistrationActionForm)form;
		Employee emp = new Employee();
		emp.setEno(actionform.getEno());
		emp.setEname(actionform.getEname());
		emp.setEsal(actionform.getEsal());
		emp.setEaddr(actionform.getEaddr());
		
		EmployeeService empService= new EmployeeService();
		status=empService.registration(emp);
		return mapping.findForward(status);
	}
}
