package com.xworkz.cm.service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.cm.dto.SignUpDto;

public interface SignUpService {
	
	Set<ConstraintViolation<SignUpDto>> validateAndSave(SignUpDto dto);

	default List<SignUpDto> find(){
		return Collections.emptyList();
	}
	
	
	default List<SignUpDto> singIn(String userId, String password){
		return Collections.emptyList();
	}
	
	default Long findByUserId(String userId) {
		return null;
	}
	
	default Long findByEmailId(String email) {
		return null;
	}

	default Long findByMobileNumber(Long mobile) {
		return null;
	}
	
//	boolean sendMail(String toMail);
}
