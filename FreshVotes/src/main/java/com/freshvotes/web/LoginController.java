package com.freshvotes.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	//@RequestMapping(value="/login", method=RequestMethod.GET)
	//The GetMapping annoptation makes the same than the las line annotation
	@GetMapping(value="/login")
	public String login() {
		
		return "login";
	}

}
