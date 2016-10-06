package com.view;

import com.entity.Organization;

public class OrganizationView {

	private long id;
	private String name;

	public OrganizationView() {
		super();
	}

	public OrganizationView(Organization organization) {
		this.id = organization.getId();
		this.name = organization.getName();
	}

	public OrganizationView(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

}
