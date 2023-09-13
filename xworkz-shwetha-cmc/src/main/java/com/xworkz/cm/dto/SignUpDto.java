package com.xworkz.cm.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class SignUpDto {
	
	@NotNull
	private int id;
	@Size(min = 3, max = 20, message = "user id cannot be less than 3 or greater than 20")
	private String userId;
	@Size(min = 3, max = 20, message = "mail must contain more than 3 characters")
	private String email;
	@NotNull
	private Long mobileNo;
	@Size(min = 8, max = 20, message = "password must not contain less than 8 characters")
	private String password;
	//@Size(min = 8, max = 20, message = "password must not contain less than 8 characters")
	private String confirmPassword;
	
	private String acceptAgreement;

}
