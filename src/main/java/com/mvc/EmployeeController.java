package com.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.EmployeeDao;
import com.entity.Employee;
import com.service.ServerRoomService;
import com.view.EmployeeView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private ServerRoomService serverRoomService;
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeView> getAllEmployees(Model model){
		return serverRoomService.getAllEmployees();
	}
	
	@RequestMapping(value="/getAllByOrganization/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeView> getAllEmployeesByOrganization(@PathVariable("id")long id){
		return serverRoomService.getAllEmployeesByOrganization(id);
	}
	

}
