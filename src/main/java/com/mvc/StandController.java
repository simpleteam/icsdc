package com.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
}
