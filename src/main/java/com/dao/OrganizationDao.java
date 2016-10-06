package com.dao;

import java.util.List;

import com.entity.Organization;

public interface OrganizationDao {

	public void add(Organization organization);
	
	public Organization get(long id);
	
	public List<Organization> getAll();
	
	public void update(Organization organization);
	
	public void delete(Organization organization);
	
}
