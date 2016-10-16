package com.mvc;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.ServerRoomService;
import com.view.EmployeeView;
import com.view.StandView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	private static final Logger log = Logger.getLogger(EmployeeController.class);
	
	@Autowired
	private ServerRoomService serverRoomService;
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeView> getAllEmployees(Model model){
		log.debug("/getAll httpMethod:GET");
		return serverRoomService.getAllEmployees();
	}
	
	@RequestMapping(value="/getAllByOrganization/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeView> getAllEmployeesByOrganization(@PathVariable("id")long id){
		log.debug("/getAllByOrganization/"+id+"  httpMethod:GET  response:json");
		return serverRoomService.getAllEmployeesByOrganization(id);
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String initCreateEmployee(Model model){
		log.debug("/add  httpMethod:GET");
		EmployeeView employee = new EmployeeView();
		List<String> standsNumbers = new ArrayList<>();
		for(StandView s: serverRoomService.getAllStands()){
			standsNumbers.add(s.getNumber());
		}
		employee.setStandsNumbers(standsNumbers);
		model.addAttribute("employee", employee);
		return "createEmployee";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processCreateEmployee(EmployeeView employeeView, BindingResult bindingResult, Model model){
		log.debug("/  httpMethod:POST");
		if(bindingResult.hasErrors()){
			log.error("error bindingResult");
			model.addAttribute("employee", employeeView);
			return "createEmployee";
		}
		serverRoomService.addEmployee(employeeView);
		return "redirect:/employee/showAll";
	}
	
	@RequestMapping(value="/showAll", method = RequestMethod.GET)
	public String showAllEmployees(Model model){
		log.debug("/showAll  httpMethod:GET");
		List<EmployeeView> employees = serverRoomService.getAllEmployees();
		model.addAttribute("employees", employees);
		return "employeeDetails";
	}
	
	@RequestMapping(value="{id}/update", method = RequestMethod.GET)
	public String initUpdateEmployee(@PathVariable("id")long id, Model model){
		log.debug(id+"/update  httpMethod:GET");
		EmployeeView employeeView = serverRoomService.getEmployee(id);
		model.addAttribute("employee", employeeView);
		return "updateEmployee";
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public String processUpdateEmployee(@PathVariable("id")long id, EmployeeView employeeView, BindingResult bindingResult, Model model){
		log.debug(id+"  httpMethod:PUT");
		if(bindingResult.hasErrors()){
			log.error("error bindingResult");
			model.addAttribute("employee", employeeView);
			return "updateEmployee";
		}
		employeeView.setId(id);
		serverRoomService.updateEmployee(employeeView);
		return "redirect:/employee/showAll";
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public String processDeleteEmployee(@PathVariable("id")long id){
		log.debug(id+"  httpMethod:DELETE");
		serverRoomService.deleteEmployee(id);
		return "redirect:/employee/showAll";
	}
	
	
}
