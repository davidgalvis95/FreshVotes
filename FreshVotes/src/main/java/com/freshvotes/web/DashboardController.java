package com.freshvotes.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//The following annotation tells spring that indeed, this class is a controller
@Controller
public class DashboardController {
	
	//the '/' is the root of the application so we are pointong the app out
	//To return the "index on the root of the app"
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String rootView () {
		return "index";
	}
}
