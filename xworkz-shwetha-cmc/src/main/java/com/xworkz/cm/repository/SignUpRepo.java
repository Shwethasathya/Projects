package com.xworkz.cm.repository;

import java.util.Collections;
import java.util.List;

import com.xworkz.cm.entity.SignUpEntity;


public interface SignUpRepo {
	
	boolean save(SignUpEntity entity);

		default Long findByUserId(String userId) {
		return null;
	}
	
	default Long findByEmailId(String email1) {
		return null;
	}

	default Long findByMobileNumber(Long mobile) {
		return null;
	}
	
	default List<SignUpEntity> signIn(String userId, String password){
		return Collections.emptyList();
	}
	

}
