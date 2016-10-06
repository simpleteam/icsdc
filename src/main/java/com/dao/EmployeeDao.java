package com.dao;

import java.util.List;

import com.entity.Employee;

public interface EmployeeDao {

	public void add(Employee employee);

	public Employee get(long id);
	
	public List<Employee> getAll();
	
	public List<Employee> getAllByOrganization(long id);

}
