package com.view;

import java.util.ArrayList;
import java.util.List;

import com.entity.Employee;

public class EmployeeView {

	private long id;
	private String name;
	private String middleName;
	private String surname;
	private long organizationId;
	private List<String> standsNumbers = new ArrayList<>();

	public EmployeeView() {

	}

	public EmployeeView(Employee employee) {
		this.id = employee.getId();
		this.name = employee.getName();
		this.middleName = employee.getMiddleName();
		this.surname = employee.getSurname();
		this.organizationId = employee.getOrganization().getId();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}

	public List<String> getStandsNumbers() {
		return standsNumbers;
	}

	public void setStandsNumbers(List<String> standsNumbers) {
		this.standsNumbers = standsNumbers;
	}

}
