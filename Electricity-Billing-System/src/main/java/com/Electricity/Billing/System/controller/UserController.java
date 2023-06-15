package com.Electricity.Billing.System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Electricity.Billing.System.model.Admin;
import com.Electricity.Billing.System.model.CalculateBill;
import com.Electricity.Billing.System.model.User;
import com.Electricity.Billing.System.service.UserService;

@Controller

public class UserController {

	@Autowired
	UserService service;

	@GetMapping("/")
	public String check() {
		return "login";
	}
	@RequestMapping("/adminlogin")
	public String adminLogin() {
		return "adminlogin";
	}

	@RequestMapping("/loginadmin")
	public ModelAndView loginAdmin(Admin admin) {
		ModelAndView view = new ModelAndView();

		String uname = admin.getName();
		String pass = admin.getPassword();

		if (uname != null && pass != null) {
			System.out.println(uname + " " + pass);
		}

		if (service.getAdmin(admin)) {
			System.out.println("Login Success...");
			view.setViewName("home");

		} else {
			System.out.println("Login Failed...");
			view.setViewName("register");
		}
		view.addObject("isadmin", true);
		return view;
	}

	@RequestMapping("/login")
	public ModelAndView CheckData(User user) {
		ModelAndView view = new ModelAndView();

		String uname = user.getUsername();
		String pass = user.getPassword();

		if (uname != null && pass != null) {
			System.out.println(uname + " " + pass);
		}

		if (service.getUser(user)) {
			System.out.println("Login Success...");
			view.addObject("isadmin", false);
			view.setViewName("home");

		} else {
			System.out.println("Login Failed...");
			view.setViewName("register");
		}
		return view;
	}

	@RequestMapping("/registerr")
	public String RegistrationForm(User cust) {
		System.out.println(service.RegistrationForm(cust));
		ModelAndView view = new ModelAndView();
		view.setViewName("login");
		return "login";
	}

	@RequestMapping("/viewUser")
	public ModelAndView ViewUser() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("Userlist", service.ViewUser());
		mv.setViewName("viewUser");
		return mv;
	}

	@RequestMapping("/calbill")
	public ModelAndView calBill(CalculateBill cb) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("calculatebill");
		mv.addObject("fbill", service.CalBill(cb));
		return mv;
	}

	@RequestMapping("/billreport")
	public ModelAndView BillReport() {
		ModelAndView view = new ModelAndView();
		view.addObject("Bill Report", service.BillReport());
		view.setViewName("billreport");
		return view;
	}

//	@RequestMapping("/adminlogin")
//	public String adminLogin() {
//		return "adminlogin";
//	}

}
