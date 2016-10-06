package com.service;

import java.util.List;

import com.entity.Employee;
import com.entity.Stand;
import com.view.EmployeeView;
import com.view.OrganizationView;
import com.view.StandView;

public interface ServerRoomService {

	public List<EmployeeView> getAllEmployees();
	
	public List<Employee> getEmployeesByStand(long id);
	
	public List<StandView> getStandsByEmployee(long id);
	
	public void addOrganization(OrganizationView organization);
	
	public OrganizationView getOrganizationById(long id);
	
	public List<OrganizationView> getAllOrganizations();
	
	public List<EmployeeView> getAllEmployeesByOrganization(long id);
	
	public void updateOrganization(OrganizationView organizationView);
	
	
}
