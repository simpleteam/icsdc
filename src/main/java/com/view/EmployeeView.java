package com.view;

import com.entity.Employee;

public class EmployeeView {

	private long id;
	private String name;
	private String middleName;
	private String surname;

	public EmployeeView() {

	}

	public EmployeeView(Employee employee) {
		this.id = employee.getId();
		this.name = employee.getName();
		this.middleName = employee.getMiddleName();
		this.surname = employee.getSurname();
	}

	public EmployeeView(long id, String name, String middleName, String surname) {
		this.id = id;
		this.name = name;
		this.middleName = middleName;
		this.surname = surname;
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

}
