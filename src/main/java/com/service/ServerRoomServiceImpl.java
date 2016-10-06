package com.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.lang.jstl.EmptyOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class ServerRoomServiceImpl implements ServerRoomService {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private StandDao standDao;

	@Autowired
	private OrganizationDao organizationDao;

	@Override
	public List<Employee> getEmployeesByStand(long id) {
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

}
