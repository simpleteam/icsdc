package com.mvc;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Main {
	
	private static final Logger log = Logger.getLogger(Main.class);
	
	@RequestMapping("/")
	public String main(){
		log.debug("/  httpMethod:GET");
		return "index";
	}
	
	@RequestMapping("/admin")
	public String admin(){
		log.debug("/admin  httpMethod:GET");
		return "admin";
	}
	
}
