package com.dao.mysqlimpl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Dao;
import com.entity.Organization;

@Repository
@Transactional
public class OrganizationDao extends Dao implements com.dao.OrganizationDao {

	@Override
	public void add(Organization organization) {
		getSession().save(organization);
	}

	@Override
	public Organization get(long id) {
		return getSession().get(Organization.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Organization> getAll() {
		return getSession().createQuery("from Organization").list();
	}

	@Override
	public void update(Organization organization) {
		getSession().update(organization);
	}

	@Override
	public void delete(Organization organization) {
		getSession().delete(organization);
	}

}
