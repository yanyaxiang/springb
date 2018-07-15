package com.yyx.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping("/toLogin.do")
	public String toLogin() {
		return "/pages/login";
	}

	@RequestMapping("/login.do")
	public String login(@RequestParam Map<String, Object> param, Model model, HttpServletRequest request) {
		String um = (String)param.get("um");
		if(!StringUtils.isEmpty(um)) {
			request.getSession().setAttribute("um", um);
		}
		return "redirect:/";
	}

}
