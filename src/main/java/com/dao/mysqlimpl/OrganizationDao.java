package com.dao.mysqlimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Dao;
import com.entity.Organization;

@Repository
@Transactional
public class OrganizationDao extends Dao implements com.dao.OrganizationDao {

	private static final Logger log = Logger.getLogger(OrganizationDao.class);
	
	@Override
	public void add(Organization organization) {
		log.debug("saving organization");
		getSession().save(organization);
	}

	@Override
	public Organization get(long id) {
		log.debug("getting organization by id");
		return getSession().get(Organization.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Organization> getAll() {
		log.debug("getting all organization");
		return getSession().createQuery("from Organization").list();
	}

	@Override
	public void update(Organization organization) {
		log.debug("updating organization");
		getSession().update(organization);
	}

	@Override
	public void delete(Organization organization) {
		log.debug("deleting organization");
		getSession().delete(organization);
	}

}
