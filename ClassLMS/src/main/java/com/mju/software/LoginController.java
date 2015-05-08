package com.mju.software;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mju.dao.DataTaker;
import com.mju.model.AdminModel;

@Controller
public class LoginController {

	HashMap<String, String> user;

	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "Login";
	}
	
	@RequestMapping(value = "/dologin", method = RequestMethod.POST)
	public String doLogin(Locale locale, Model model , @ModelAttribute("username") String username , @ModelAttribute("password") String password) {

	
		AdminModel am = new AdminModel();
		am.setUsername(username);
		am.setPassword(password);
		
		if(this.login(am))
			model.addAttribute("username", username );
		else
			model.addAttribute("username", "notright" );
		
		return "doLogin";
	}
	
	
	
	//Functions Area
	
	public boolean login(AdminModel am) {
		DataTaker dt = new DataTaker();
		
		HashMap<String, String> user = dt.getUser(am);
		
		if (user != null){
			this.user = user;
			return true;
		}
		else
			return false;
	}
	
	public HashMap<String, String> getUserInfo() {
		return this.user;
	}

	public boolean logout() {
		DataTaker dt = new DataTaker();
		boolean res = dt.logoutUser();
		this.user = null;
		if (user == null && res)
			return true;
		else
			return false;
	}	
	
}
