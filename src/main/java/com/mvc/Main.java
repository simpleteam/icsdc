package com.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.EmployeeDao;
import com.dao.OrganizationDao;
import com.dao.StandDao;
import com.entity.Employee;
import com.entity.Organization;
import com.entity.Stand;

@Controller
public class Main {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private StandDao standDao;
	
	@Autowired
	private OrganizationDao organizationDao;
	
	@RequestMapping("/")
	public String main(){		
		return "org";
	}
	
	@RequestMapping("/admin")
	public String admin(){
		return "admin";
	}
	
	
	private Employee addEmployee(String name, String middleName, String surname,Organization organization, String position, List<Stand> stands){
		Employee employee = new Employee();
		employee.setName(name);
		employee.setMiddleName(middleName);
		employee.setSurname(surname);
		employee.setOrganization(organization);
		employee.setPosition(position);
		employee.setStands(stands);
		return employee;
	}
	
	private Stand addStand(String number, String alternativeNumber, long organization_id){
		Stand stand = new Stand();
		stand.setOrganization(organizationDao.get(organization_id));
		stand.setNumber(number);
		stand.setAlternativeNumber(alternativeNumber);
		return stand;
	}
	
	
}
