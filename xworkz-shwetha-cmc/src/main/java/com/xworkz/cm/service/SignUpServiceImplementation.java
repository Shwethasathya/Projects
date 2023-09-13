package com.xworkz.cm.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.cm.dto.SignUpDto;
import com.xworkz.cm.entity.SignUpEntity;
import com.xworkz.cm.repository.SignUpRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SignUpServiceImplementation implements SignUpService {

	@Autowired
	private SignUpRepo signUpRepo;

	@Override
	public Set<ConstraintViolation<SignUpDto>> validateAndSave(SignUpDto dto) {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<SignUpDto>> violations = validator.validate(dto);
		if (violations != null && !violations.isEmpty()) {
			log.info("violations " + dto);
			return violations;
		} else {

			log.info("no violations can save the data");
			SignUpEntity entity = new SignUpEntity();
			entity.setId(dto.getId());
			entity.setUserId(dto.getUserId());
			entity.setEmail(dto.getEmail());
			entity.setMobileNo(dto.getMobileNo());
			entity.setPassword(dto.getPassword());
			entity.setConfirmPassword(dto.getConfirmPassword());
			entity.setCreatedby(dto.getUserId());
			entity.setCreateddate(LocalDateTime.now());

			boolean saved = this.signUpRepo.save(entity);
			log.info("saved " + saved);
			return Collections.emptySet();
		}

	}

	@Override
	public Long findByUserId(String userId) {
		Long user = this.signUpRepo.findByUserId(userId);
		return user;
	}

	@Override
	public Long findByEmailId(String email) {
		Long emailId = this.signUpRepo.findByEmailId(email);
		return emailId;
	}

	@Override
	public Long findByMobileNumber(Long mobile) {
		Long mobileNumber = this.signUpRepo.findByMobileNumber(mobile);
		return mobileNumber;
	}

	@Override
	public List<SignUpDto> singIn(String userId, String password) {
		List<SignUpEntity> entities = this.signUpRepo.signIn(userId, password);
		List<SignUpDto> listOfDto = new ArrayList<SignUpDto>();
		for (SignUpEntity entity : entities) {
			SignUpDto dto = new SignUpDto();
			BeanUtils.copyProperties(entity, dto);
			listOfDto.add(dto);
		}
		return listOfDto;

	}
}

/*
 * @Override public boolean sendMail(String toMail) { String portNumber = "567";
 * String hostName = "smtp.gmail.com"; final String mailFrom =
 * "sshwetha.xworkz@gmail.com"; final String password = "Sasushsh"; String to =
 * toMail;
 * 
 * Properties properties = new Properties();
 * 
 * properties.put("mail.smtp.host", hostName); properties.put("mail.smtp.prop",
 * portNumber); properties.put("mail.smtp.starttls.enable", true);
 * properties.put("mail.debug", true); properties.put("mail.smtp.auth", true);
 * properties.put("mail.transport.protocol", "smtp");
 * 
 * Session session = Session.getInstance(properties, new Authenticator() {
 * 
 * @Override protected PasswordAuthentication getPasswordAuthentication() {
 * 
 * return new PasswordAuthentication(mailFrom, password); } });
 * 
 * MimeMessage message = new MimeMessage(session);
 * 
 * try { message.setSubject("completed registeration");
 * message.setText("thanks for registering");
 * message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
 * Transport.send(message); log.info("mail sent successfully");
 * 
 * } catch (MessagingException e) { e.printStackTrace(); }
 * 
 * return true; }
 */