package com.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.EmployeeDao;
import com.dao.OrganizationDao;
import com.dao.StandDao;
import com.entity.Employee;
import com.entity.Organization;
import com.entity.Stand;
import com.view.EmployeeView;
import com.view.OrganizationView;
import com.view.StandView;

@Service
@Transactional
public class ServerRoomServiceImpl implements ServerRoomService {

	private static final Logger log = Logger.getLogger(ServerRoomServiceImpl.class);

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private StandDao standDao;

	@Autowired
	private OrganizationDao organizationDao;

	@Override
	public void addEmployee(EmployeeView employeeView) {
		log.debug("saving employee");
		Employee employee = new Employee(employeeView);
		List<Stand> stands = new ArrayList<>();
		for (String number : employeeView.getStandsNumbers()) {
			stands.add(standDao.getByNumber(number));
		}
		employee.setStands(stands);
		employeeDao.add(employee);
	}
	
	@Override
	public EmployeeView getEmployee(long id) {
		log.debug("getting employee");
		return new EmployeeView(employeeDao.get(id));
	}
	
	@Override
	public List<EmployeeView> getAllEmployees() {
		log.debug("getting all employees");
		return entityToViewEmployees(employeeDao.getAll());
	}

	@Override
	public List<EmployeeView> getAllEmployeesByOrganization(long id) {
		log.debug("getting all employees by organization");
		return entityToViewEmployees(employeeDao.getAllByOrganization(id));
	}
	
	@Override
	public void updateEmployee(EmployeeView employeeView) {
		log.debug("updationg employee");
		employeeDao.update(new Employee(employeeView));
	}

	@Override
	public void deleteEmployee(long id) {
		log.debug("deleting employee");
		employeeDao.delete(employeeDao.get(id));
	}
	
	
	
	@Override
	public void addOrganization(OrganizationView organizationView) {
		log.debug("saving organization");
		Organization organization = new Organization();
		organization.setName(organizationView.getName());
		organizationDao.add(organization);
	}

	@Override
	public OrganizationView getOrganizationById(long id) {
		log.debug("getting organization by id");
		return new OrganizationView(organizationDao.get(id));
	}

	@Override
	public List<OrganizationView> getAllOrganizations() {
		log.debug("getting all organization");
		return entityToViewOrganizations(organizationDao.getAll());
	}

	@Override
	public void updateOrganization(OrganizationView organizationView) {
		log.debug("updating organization");
		organizationDao.update(new Organization(organizationView));
	}
	
	@Override
	public void deleteOrganization(long id) {
		log.debug("deleting organization");
		organizationDao.delete(organizationDao.get(id));
	}
	
	
	
	@Override
	public void addStand(StandView standView) {
		log.debug("saving stand");
		standDao.add(new Stand(standView));
	}
	
	@Override
	public StandView getStand(long id) {
		log.debug("getting stand by id");
		return new StandView(standDao.get(id));
	}

	@Override
	public List<StandView> getAllStands() {
		log.debug("getting all stands");
		return entityToViewStands(standDao.getAll());
	}
	
	@Override
	public List<StandView> getStandsByEmployee(long id) {
		log.debug("getting stands by employee");
		List<StandView> view = new ArrayList<>();
		for (Stand s : standDao.getAllByEmployee(id)) {
			view.add(new StandView(s.getId(), s.getNumber(), s.getAlternativeNumber()));
		}
		return view;
	}

	@Override
	public void updateStand(StandView standView) {
		log.debug("updating stand");
		standDao.update(new Stand(standView));
	}

	@Override
	public void deleteStand(long id) {
		log.debug("deleting stand");
		standDao.delete(standDao.get(id));
	}


	
	private List<EmployeeView> entityToViewEmployees(List<Employee> employees) {
		log.debug("converting list of Employee to list of EmployeeView");
		List<EmployeeView> view = new ArrayList<>();
		for (Employee e : employees) {
			view.add(new EmployeeView(e));
		}
		return view;
	}

	private List<OrganizationView> entityToViewOrganizations(List<Organization> organizations) {
		log.debug("converting list of Organization to list of OrganizationView");
		List<OrganizationView> view = new ArrayList<>();
		for (Organization o : organizations) {
			view.add(new OrganizationView(o));
		}
		return view;
	}

	private List<StandView> entityToViewStands(List<Stand> stands) {
		log.debug("converting list of Stand to list of StandView");
		List<StandView> view = new ArrayList<>();
		for (Stand s : stands) {
			view.add(new StandView(s));
		}
		return view;
	}

}
