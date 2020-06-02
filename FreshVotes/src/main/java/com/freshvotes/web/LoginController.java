package com.freshvotes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.freshvotes.domain.User;
import com.freshvotes.service.UserService;

@Controller
public class LoginController {
	
	//Here we invoke the service we created to save the user in DB
	//so we create the instace of the object to be used
	@Autowired
	private UserService userService;
	//@RequestMapping(value="/login", method=RequestMethod.GET)
	//The GetMapping annoptation makes the same than the las line annotation
	@GetMapping(value="/login")
	public String login() {
		
		return "login";
	}

	@GetMapping(value="/register")
	public String register(ModelMap model) {
		//Here we have to create a model so that the front end can pass the data into
		//When mapping the fields of the front side
		model.put("user", new User());
		return "register";
	}
	
	//We pass user because if we go to the register.html these fields that are being
	//passed belong to a user that has already been declared in the user class
	//This is databinding, that is take the data from the html and transform it into a java object
	@PostMapping(value="/register")
	public String registerPost(@ModelAttribute User user) {
		System.out.println(user);
		//Now we need to persist the object into the DB using the UserService
		User savedUser = userService.saveUser(user);
		System.out.println("Non saved user: " + user);
		System.out.println("saved user: " + savedUser);
		
		//We use the redirect because we are using the post method
		//If we dont redirect we can just double send the form, like twice
		return "redirect:/login";
	}
}
