package com.dao.mysqlimpl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Dao;
import com.entity.Employee;
import com.entity.Stand;

@Repository
@Transactional
public class StandDao extends Dao implements com.dao.StandDao {

	@Override
	public void add(Stand stand) {
		getSession().save(stand);
	}

	@Override
	public Stand get(long id) {
		return getSession().get(Stand.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Stand> getAllByEmployee(long id) {
		Employee e = getSession().get(Employee.class, id);
		List<Stand> stands = e.getStands();
		return stands;
	}

	@Override
	public void update(Stand stand) {
		getSession().update(stand);
	}

	@Override
	public void delete(Stand stand) {
		getSession().delete(stand);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Stand> getAll() {
		return getSession().createQuery("from Stand").list();
	}

	@Override
	public Stand getByNumber(String number) {
		return (Stand) getSession().createQuery("from Stand s where s.number = :number")
				.setString("number", number)
				.uniqueResult();
	}

}
