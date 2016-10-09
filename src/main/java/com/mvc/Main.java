package com.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Main {
	
	@RequestMapping("/")
	public String main(){		
		return "index";
	}
	
	@RequestMapping("/admin")
	public String admin(){
		return "admin";
	}
	
}
