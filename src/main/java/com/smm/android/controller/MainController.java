package com.smm.android.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/")
	@ResponseBody
	public String home() {
		System.out.println("This is home page ");
		return "Home Page";
	}
	
	@RequestMapping("/contact")
	@ResponseBody
	public String contact() {
		System.out.println("This is contact page ");
		return "Contact Page Testing <h1>Ankush</h1>";
	}
}
