package com.xworkz.cm.controller;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.cm.dto.SignUpDto;
import com.xworkz.cm.service.SignUpService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class SignController {

	@Autowired
	private SignUpService signUpService;

	public SignController() {
		log.info("created" + getClass().getSimpleName());
	}

	@PostMapping("/signUp")
	public String onSign(Model model, SignUpDto signUpDto) {
		Set<ConstraintViolation<SignUpDto>> violations = this.signUpService.validateAndSave(signUpDto);
		if (violations.isEmpty()) {
			model.addAttribute("save", "data saved");

			log.info(" " + signUpDto);
			return "index";
		} else {
			model.addAttribute("errors", violations);
			model.addAttribute("message", "data not saved");
		}
		return "index";

	}
	
	@PostMapping("/signIn")
	public String onSignIn(@RequestParam String userId, @RequestParam String password, Model model) {
		log.info("running onSignIn page");
		List<SignUpDto> list = this.signUpService.singIn(userId, password);
		if (!list.isEmpty()) {
			log.info("matching userId and password");
			model.addAttribute("list", list);
			return "SignIn";
		}
		model.addAttribute("message", "userId or password is not matching");
		return "SignIn";

	}
}