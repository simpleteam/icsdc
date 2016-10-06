package com.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.OrganizationDao;
import com.entity.Organization;
import com.service.ServerRoomService;
import com.view.EmployeeView;
import com.view.OrganizationView;

@Controller
@RequestMapping("/organization")
public class OrganizationController {

	@Autowired
	private ServerRoomService serverRoomServi�e;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public String showOrganization(@PathVariable("id")long id, Model model){
		List<OrganizationView> organization = new ArrayList<>();
		organization.add(serverRoomServi�e.getOrganizationById(id));
		model.addAttribute("organizations", organization);
		return "organizationDetails";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String initAddOrganization(Model model){
		model.addAttribute("organization", new OrganizationView());
		return "createOrganization";	
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processAddOrganization(OrganizationView organization, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "createOrganization";
		}
		serverRoomServi�e.addOrganization(organization);
		return "redirect:/organization/showAll";
	}
	
	@RequestMapping(value = "/showAll", method = RequestMethod.GET)
	public String showAllOrganization(Model model){
		List<OrganizationView> organizations = serverRoomServi�e.getAllOrganizations();
		model.addAttribute("organizations", organizations);
		return "organizationDetails";
	}
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	@ResponseBody
	public List<OrganizationView> getAllOrganizations(Model model){
		return serverRoomServi�e.getAllOrganizations();
	}
	
	@RequestMapping(value="{id}/update")
	public String initProcessOrganization(@PathVariable("id")long id, Model model){
		OrganizationView organization = serverRoomServi�e.getOrganizationById(id);
		model.addAttribute("organization", organization);
		return "updateOrganization";
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public String processUpdateOrganization(OrganizationView organizationView, BindingResult bindingResult){
		serverRoomServi�e.updateOrganization(organizationView);
		return "redirect:/organization/showAll";
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public String processDeleteOrganization(@PathVariable("id")long id){
		serverRoomServi�e.deleteOrganization(id);
		return "redirect:/organization/showAll";
	}
	
}
