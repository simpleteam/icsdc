package com.mvc;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.ServerRoomService;
import com.view.OrganizationView;

@Controller
@RequestMapping("/organization")
public class OrganizationController {
	
	private static final Logger log = Logger.getLogger(OrganizationController.class);

	@Autowired
	private ServerRoomService serverRoomServiñe;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public String showOrganization(@PathVariable("id")long id, Model model){
		log.debug(id+"  httpMethod:GET");
		List<OrganizationView> organization = new ArrayList<>();
		organization.add(serverRoomServiñe.getOrganizationById(id));
		model.addAttribute("organizations", organization);
		return "organizationDetails";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String initAddOrganization(Model model){
		log.debug("/add  httpMethod:GET");
		model.addAttribute("organization", new OrganizationView());
		return "createOrganization";	
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processAddOrganization(OrganizationView organization, BindingResult bindingResult, Model model){
		log.debug("/  httpMethod:POST");
		if(bindingResult.hasErrors()){
			log.error("error bindingResult");
			model.addAttribute("organization", organization);
			return "createOrganization";
		}
		serverRoomServiñe.addOrganization(organization);
		return "redirect:/organization/showAll";
	}
	
	@RequestMapping(value = "/showAll", method = RequestMethod.GET)
	public String showAllOrganization(Model model){
		log.debug("/showAll  httpMethod:GET");
		List<OrganizationView> organizations = serverRoomServiñe.getAllOrganizations();
		model.addAttribute("organizations", organizations);
		return "organizationDetails";
	}
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	@ResponseBody
	public List<OrganizationView> getAllOrganizations(Model model){
		log.debug("/getAll httpMethod:GET  response:json");
		return serverRoomServiñe.getAllOrganizations();
	}
	
	@RequestMapping(value="{id}/update")
	public String initProcessOrganization(@PathVariable("id")long id, Model model){
		log.debug(id+"/update  httpMethod:GET");
		OrganizationView organization = serverRoomServiñe.getOrganizationById(id);
		model.addAttribute("organization", organization);
		return "updateOrganization";
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public String processUpdateOrganization(@PathVariable("id")long id, OrganizationView organizationView, BindingResult bindingResult, Model model){
		log.debug(id+"/update  httpMethod:PUT");
		if(bindingResult.hasErrors()){
			log.error("error bindingResult");
			model.addAttribute("organization", organizationView);
			return "updateOrganization";
		}
		organizationView.setId(id);
		serverRoomServiñe.updateOrganization(organizationView);
		return "redirect:/organization/showAll";
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public String processDeleteOrganization(@PathVariable("id")long id){
		log.debug(id+"  httpMethod:DELETE");
		serverRoomServiñe.deleteOrganization(id);
		return "redirect:/organization/showAll";
	}
	
}
