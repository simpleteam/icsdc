package com.service;

import java.util.List;

import com.view.EmployeeView;
import com.view.OrganizationView;
import com.view.StandView;

public interface ServerRoomService {
	
	public void addEmployee(EmployeeView employeeView);
	
	public EmployeeView getEmployee(long id);
	
	public List<EmployeeView> getAllEmployees();
	
	public List<EmployeeView> getEmployeesByStand(long id);
	
	public List<EmployeeView> getAllEmployeesByOrganization(long id);
	
	public void updateEmployee(EmployeeView employeeView);
	
	public void deleteEmployee(long id);
	
	
	public void addOrganization(OrganizationView organization);
	
	public OrganizationView getOrganizationById(long id);
	
	public List<OrganizationView> getAllOrganizations();
	
	public void updateOrganization(OrganizationView organizationView);
	
	public void deleteOrganization(long id);
	

	public void addStand(StandView standView);
	
	public StandView getStand(long id);
	
	public List<StandView> getStandsByEmployee(long id);
	
	public List<StandView> getAllStands();
	
	public void updateStand(StandView standView);
	
	public void deleteStand(long id);
	
	
	
}
