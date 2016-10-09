package com.dao.mysqlimpl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Dao;
import com.entity.Employee;

@Repository
@Transactional
public class EmployeeDao extends Dao implements com.dao.EmployeeDao {

	@Override
	public void add(Employee employee) {
		getSession().save(employee);
	}

	@Override
	public Employee get(long id) {
		return getSession().get(Employee.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAll() {
		return getSession().createQuery("from Employee").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllByOrganization(long id) {
		return getSession().createQuery("from Employee e where e.organization.id = :id").setLong("id", id).list();
	}

	@Override
	public void update(Employee employee) {
		getSession().update(employee);
	}

	@Override
	public void delete(Employee employee) {
		getSession().delete(employee);
	}

}
