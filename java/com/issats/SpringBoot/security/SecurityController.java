package com.issats.SpringBoot.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/")
	public String home() {
		return "redirect:/operations";
	}

	@RequestMapping("/403")
	public String accessDenied() {
		return "403";
	}
}
