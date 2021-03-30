package com.psa.Repeat.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psa.Repeat.Entity.User;
import com.psa.Repeat.Repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	UserRepository userrepo;
	
	@RequestMapping("/showlist")
	public String Newentry() {
		return"index";
		
	}
	
	@RequestMapping("/NewUser")
	public String NewUser() {
		return "newentry";
		
	}
	
	@RequestMapping("/updateUser")
    public String updateUser(@ModelAttribute()User user,ModelMap modelmap) {
		userrepo.save(user);
		modelmap.addAttribute("msg", "You created a newuser");
		return "index";
	}
	@RequestMapping("/ExistingUser")
	public String ExistingUser() {
		return"Flights";
	}
	
	@RequestMapping("/userlogin")
	public String userlogin(@RequestParam()String email,@RequestParam()String password,ModelMap modelmap) {
		User user = userrepo.findByEmail(email);
		 if(user.getEmail().equals(email)&& user.getPassword().equals(password)) {
			 return"Booking"; 
		 }else {
			 modelmap.addAttribute("mgg", "Invalid Username and Password");
			 return"index"; 
		 }
		
	}
}
