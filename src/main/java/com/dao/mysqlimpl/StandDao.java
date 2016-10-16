package com.dao.mysqlimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Dao;
import com.entity.Employee;
import com.entity.Stand;

@Repository
@Transactional
public class StandDao extends Dao implements com.dao.StandDao {

	private static final Logger log = Logger.getLogger(StandDao.class);
	
	@Override
	public void add(Stand stand) {
		log.debug("saving stand");
		getSession().save(stand);
	}

	@Override
	public Stand get(long id) {
		log.debug("getting stand by id");
		return getSession().get(Stand.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Stand> getAllByEmployee(long id) {
		log.debug("getting all stands");
		Employee e = getSession().get(Employee.class, id);
		List<Stand> stands = e.getStands();
		return stands;
	}

	@Override
	public void update(Stand stand) {
		log.debug("updating stand");
		getSession().update(stand);
	}

	@Override
	public void delete(Stand stand) {
		log.debug("deleting stand");
		getSession().delete(stand);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Stand> getAll() {
		log.debug("getting all stands");
		return getSession().createQuery("from Stand").list();
	}

	@Override
	public Stand getByNumber(String number) {
		log.debug("getting stands by number");
		return (Stand) getSession().createQuery("from Stand s where s.number = :number")
				.setString("number", number)
				.uniqueResult();
	}

}
