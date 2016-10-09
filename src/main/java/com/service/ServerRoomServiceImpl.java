package com.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.lang.jstl.EmptyOperator;
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

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private StandDao standDao;

	@Autowired
	private OrganizationDao organizationDao;

	@Override
	public List<EmployeeView> getEmployeesByStand(long id) {
		return null;
	}

	@Override
	public List<StandView> getStandsByEmployee(long id) {
		List<StandView> view = new ArrayList<>();
		for (Stand s : standDao.getAllByEmployee(id)) {
			view.add(new StandView(s.getId(), s.getNumber(), s.getAlternativeNumber()));
		}
		return view;
	}

	@Override
	public List<EmployeeView> getAllEmployees() {
		return entityToViewEmployees(employeeDao.getAll());
	}

	private List<EmployeeView> entityToViewEmployees(List<Employee> employees) {
		List<EmployeeView> view = new ArrayList<>();

		for (Employee e : employees) {
			System.out.println(e.getMiddleName());
			view.add(new EmployeeView(e.getId(), e.getName(), e.getMiddleName(), e.getSurname()));
		}

		return view;
	}

	private List<OrganizationView> entityToViewOrganizations(List<Organization> organizations) {
		List<OrganizationView> view = new ArrayList<>();
		for (Organization o : organizations) {
			view.add(new OrganizationView(o));
		}
		return view;
	}
	
	private List<StandView> entityToViewStands(List<Stand> stands){
		List<StandView> view = new ArrayList<>();
		for (Stand s : stands){
			view.add(new StandView(s));
		}
		return view;
	}
	

	@Override
	public void addOrganization(OrganizationView organizationView) {
		Organization organization = new Organization();
		organization.setName(organizationView.getName());
		organizationDao.add(organization);
	}

	@Override
	public OrganizationView getOrganizationById(long id) {
		return new OrganizationView(organizationDao.get(id));
	}

	@Override
	public List<OrganizationView> getAllOrganizations() {
		return entityToViewOrganizations(organizationDao.getAll());
	}

	@Override
	public List<EmployeeView> getAllEmployeesByOrganization(long id) {
		return entityToViewEmployees(employeeDao.getAllByOrganization(id));
	}

	@Override
	public void updateOrganization(OrganizationView organizationView) {
		organizationDao.update(new Organization(organizationView));
	}

	public void deleteOrganization(OrganizationView organizationView) {
		organizationDao.delete(new Organization(organizationView));
	}

	@Override
	public void deleteOrganization(long id) {
		organizationDao.delete(organizationDao.get(id));
	}

	@Override
	public void updateStand(StandView standView) {
		standDao.update(new Stand(standView));	
	}

	@Override
	public void deleteStand(long id) {
		standDao.delete(standDao.get(id));	
	}

	@Override
	public StandView getStand(long id) {
		return new StandView(standDao.get(id));
	}

	@Override
	public List<StandView> getAllStands() {
		return entityToViewStands(standDao.getAll());
	}

	@Override
	public void addStand(StandView standView) {
		standDao.add(new Stand(standView));
	}

	@Override
	public void addEmployee(EmployeeView employeeView) {
		employeeDao.add(new Employee(employeeView));
	}

	@Override
	public void updateEmployee(EmployeeView employeeView) {
		employeeDao.update(new Employee(employeeView));
	}

	@Override
	public EmployeeView getEmployee(long id) {
		return new EmployeeView(employeeDao.get(id));
	}

	@Override
	public void deleteEmployee(long id) {
		employeeDao.delete(employeeDao.get(id));
	}

}
