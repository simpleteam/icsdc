package com.dao.mysqlimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Dao;
import com.entity.Employee;

@Repository
@Transactional
public class EmployeeDao extends Dao implements com.dao.EmployeeDao {

	private static final Logger log = Logger.getLogger(EmployeeDao.class);
	
	@Override
	public void add(Employee employee) {
		log.debug("saving employee");
		getSession().save(employee);
	}

	@Override
	public Employee get(long id) {
		log.debug("getting employee");
		return getSession().get(Employee.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAll() {
		log.debug("getting all employee");
		return getSession().createQuery("from Employee").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllByOrganization(long id) {
		log.debug("getting all employee by organization");
		return getSession().createQuery("from Employee e where e.organization.id = :id").setLong("id", id).list();
	}

	@Override
	public void update(Employee employee) {
		log.debug("updating employee");
		getSession().update(employee);
	}

	@Override
	public void delete(Employee employee) {
		log.debug("deleting employee");
		getSession().delete(employee);
	}

}
