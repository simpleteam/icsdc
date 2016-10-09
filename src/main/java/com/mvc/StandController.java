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

import com.service.ServerRoomService;
import com.view.StandView;

@Controller
@RequestMapping("/stand")
public class StandController {

	@Autowired
	private ServerRoomService serverRoomService;
	
	@RequestMapping(value="/getAllByEmployee/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<StandView> getStandsByEmployee(@PathVariable("id") long id){
		return serverRoomService.getStandsByEmployee(id);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String initCreateStand(Model model){
			model.addAttribute("stand", new StandView());
			return "createStand";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processCreateStand(StandView standView, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()){
			model.addAttribute("stand",standView);
			return "createStand";
		}
		serverRoomService.addStand(standView);
		return "redirect:/stand/showAll";
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public String getStand(@PathVariable("id")long id, Model model){
		List<StandView> stand = new ArrayList<>();
		stand.add(serverRoomService.getStand(id));
		model.addAttribute("stands", stand);
		return "standDetails";
	}
	
	@RequestMapping(value="/showAll", method = RequestMethod.GET)
	public String showAllStands(Model model){
		List<StandView> stands = serverRoomService.getAllStands();
		model.addAttribute("stands", stands);
		return "standDetails";
	}
	
	@RequestMapping(value="{id}/update", method = RequestMethod.GET)
	public String initUpdateStand(@PathVariable("id")long id, Model model){
		StandView stand = serverRoomService.getStand(id);
		model.addAttribute("stand", stand);
		return "updateStand";
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public String processUpdateStand(@PathVariable("id")long id, StandView standView, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()){
			model.addAttribute("stand", standView);
			return "stand/"+id;
		}
		standView.setId(id);
		serverRoomService.updateStand(standView);
		return "redirect:/stand/showAll";
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public String processDeleteStand(@PathVariable("id")long id){
		serverRoomService.deleteStand(id);
		return "redirect:/stand/showAll";
	}
	
}
