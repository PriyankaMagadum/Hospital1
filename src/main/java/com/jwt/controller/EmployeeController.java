package com.jwt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.AssertionFailure;
import org.hibernate.exception.ConstraintViolationException;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.jwt.model.Employee;
import com.jwt.model.PatientDetails;
import com.jwt.model.Patients;
import com.jwt.service.EmployeeService;
import com.jwt.service.PatientDetailsService;
import com.jwt.service.PatientService;

@Controller

public class EmployeeController {

	private static final Logger logger = Logger
			.getLogger(EmployeeController.class);

	public EmployeeController() {
		System.out.println("EmployeeController()");
	}

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
    private PatientService patientService;
	
	@Autowired
	private PatientDetailsService PatientDetailsService;

	@RequestMapping(value = "/")
	public ModelAndView listEmployee(ModelAndView model) throws IOException {
		List<Employee> listEmployee = employeeService.getAllEmployees();
		model.addObject("listEmployee", listEmployee);
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Employee employee = new Employee();
		model.addObject("employee", employee);
		model.setViewName("EmployeeForm");
		return model;
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		if (employee.getId() == 0) { // if employee id is 0 then creating the
			// employee other updating the employee
			employeeService.addEmployee(employee);
		} else {
			employeeService.updateEmployee(employee);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		employeeService.deleteEmployee(employeeId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		Employee employee = employeeService.getEmployee(employeeId);
		ModelAndView model = new ModelAndView("EmployeeForm");
		model.addObject("employee", employee);

		return model;
	}

	
	/*@RequestMapping(value="/Patients", method = RequestMethod.POST)
	public ModelAndView savePatients(@ModelAttribute Patients patients)
	{
		System.out.println("name="+patients.getRegistrationNo());
		//Patients p=patientService.addPatients(patients);
		
		return new ModelAndView("Patients");
		
		//return "Patients";
		
	}*/
	

	@RequestMapping(value="/Patients/fromNewPatients", method = RequestMethod.POST)
	public ModelAndView savePatients(@RequestParam("regiNo") String registrationNo,@RequestParam("pName") String patientName, Model model )
	{
	
		System.out.println("name="+patientName);
		System.out.println("rgistration no="+registrationNo);
		Patients patients=new Patients(registrationNo, patientName);
		String abc=null;
		
		try{
			
		 abc=patientService.addPatients(patients);
		 System.out.println("Patient details="+abc);
		
		}
		catch(Exception e){
			System.out.println("String="+abc);
			abc="exception";
			
		}
		
		 if(abc.equals("Ok"))
		 {
			 //return "Patients";
			 ModelAndView modelNew=new ModelAndView("Patients");
			
			 List<Patients> listPatients=new ArrayList<Patients>();
				listPatients=patientService.getAllPatients();
					modelNew.addObject("listPatients", listPatients);
				modelNew.setViewName("Patients");
				return modelNew;
		
			 
		 }
		 else{
			 ModelAndView modelNew1=new ModelAndView("AddPatient");
			 System.out.println("not ok");
			 model.addAttribute("msg", abc);
			 modelNew1.setViewName("AddPatient");
			 return modelNew1;
		 }
		
	
	}
	
	
	@RequestMapping(value="/addPatient", method=RequestMethod.GET)
	public String addPatients(ModelAndView model, HttpServletRequest request)
	{
		if(request.getParameter("msg") == "msg"){
			System.out.println("idkjhfisudg");
		}
		System.out.println("msg="+request.getParameter("msg"));
		System.out.println(request.getAttribute("msg"));
		Patients patients=new Patients();
		model.addObject("patients",patients);
		System.out.println("in addpatients controller");
	//	model.setViewName("AddPatient");
		
		return "AddPatient";
		
		//return "AddPatient";
	}
	
	@RequestMapping(value="/Patients", method=RequestMethod.GET)
	public ModelAndView listPatients(ModelAndView model) throws IOException {
	
		List<Patients> listPatients=new ArrayList<Patients>();
		listPatients=patientService.getAllPatients();
		
		if(listPatients.size()!=0)
		{
		model.addObject("listPatients", listPatients);
		for(Patients p:listPatients)
		{
			System.out.println(p.getPatientName());
		}
		}
		model.setViewName("Patients");
	return model;	
		
	}
		
		
		
	
		
	@RequestMapping(value="PatientDetails/Patients/details", method = RequestMethod.POST)
	public String savePatientsDetails(HttpServletRequest request, Model model )
	{	
		System.out.println("error");
		
		String registrationNo=request.getParameter("regino");
		String opd=request.getParameter("patientName");
		String complaint=request.getParameter("complaint");
		String complaintAnalysys=request.getParameter("complaintAnalysys");
		
		
		
		Date date=new Date();
	Patients p=new Patients();
	p.setRegistrationNo(registrationNo);
		PatientDetails patientDetails=new PatientDetails(registrationNo, opd, complaint, complaintAnalysys, date);
		PatientDetailsService.savePatirntDetails(patientDetails);
		
		System.out.println("error");
		return "Patients";
	}
		
		
		
		
		
		
	
	@RequestMapping("/PatientDetails/{id}")
	public String addPatientsDetails(@PathVariable("id") String registrationNo,Model model)
	{
		System.out.println("regino0="+registrationNo);
		Patients patients=patientService.getByRegistartionNo(registrationNo);
		model.addAttribute("patients", patients);
		System.out.println("name="+patients.getPatientName());
		return "PatientDetails";
	}
	
	@RequestMapping("/xyz")
	public String xyz()
	{
		return "xyz";
	}
	
}