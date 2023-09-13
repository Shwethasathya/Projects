package com.xworkz.cm.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.xworkz.cm.service.SignUpService;

import lombok.extern.slf4j.Slf4j;

@EnableWebMvc
@RestController
@Slf4j
@RequestMapping("/")
public class AjaxController {

	@Autowired
	private SignUpService signUpService;

	public AjaxController() {
		log.info("created " + this.getClass().getSimpleName());
	}

	@GetMapping(value = "/email/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String onEmail(@PathVariable String email) {

		Long emailRef = this.signUpService.findByEmailId(email);
		System.out.println(emailRef);

		if (emailRef == 0) {
			System.out.println("running if equal to 0");
			return "";
		} else {
			return "email id exist";
		}
	}

	@GetMapping(value = "/userId/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String onUser(@PathVariable String userId) {
		Long userRef = this.signUpService.findByUserId(userId);
		System.err.println(userRef);

		if (userRef == 0) {
			System.out.println("running in equals condtion");
			return "";
		} else {
			return "user id exist";
		}
	}

	@GetMapping(value = "mobile/{mobileNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String onMobile(@PathVariable Long mobileNo) {
		Long mobileRef = this.signUpService.findByMobileNumber(mobileNo);
		System.out.println(mobileRef);

		if (mobileRef == 0) {
			System.out.println("running equals in condition");
			return "";
		} else {
			return "Mobile number exist";
		}
	}
}
