package com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.view.EmployeeView;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "middleName")
	private String middleName;
	@Column(name = "surname")
	private String surname;
	@Column(name = "position")
	private String position;
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinColumn(name = "organization_id")
	private Organization organization;
	@ManyToMany
	@JoinTable(name = "stand_employee", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "stand_id"))
	private List<Stand> stands;

	public Employee(){
		
	}
	
	public Employee(EmployeeView employeeView){
		this.id = employeeView.getId();
		this.name = employeeView.getName();
		this.middleName = employeeView.getMiddleName();
		this.surname = employeeView.getSurname();
		Organization organization = new Organization();
		organization.setId(employeeView.getOrganizationId());
		this.organization = organization;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public List<Stand> getStands() {
		return stands;
	}

	public void setStands(List<Stand> stands) {
		this.stands = stands;
	}

}
