package com.freshvotes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//The following annotation tells spring that indeed, this class is a controller
@Controller
public class DashboardController {
	
	//the '/' is the root of the application so we are pointong the app out
	//To return the "index on the root of the app"
	//@Autowired
	//private PasswordEncoder passwordEncoder;
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String rootView () {
		return "index";
	}
	@RequestMapping(value="/dashboard",method=RequestMethod.GET)
	public String dashboard () {
		return "dashboard";
	}
}
