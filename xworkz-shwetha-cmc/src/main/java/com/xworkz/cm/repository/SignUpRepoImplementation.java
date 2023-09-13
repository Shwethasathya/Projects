package com.xworkz.cm.repository;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.cm.dto.SignUpDto;
import com.xworkz.cm.entity.SignUpEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class SignUpRepoImplementation implements SignUpRepo {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public boolean save(SignUpEntity entity) {
		log.info("created" + getClass().getSimpleName());
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(entity);
			transaction.commit();
			return false;
		} finally {
			manager.close();
		}

	}

	@Override
	public List<SignUpEntity> signIn(String userId, String password) {
			log.info("running find in repo");

			EntityManager manager = this.entityManagerFactory.createEntityManager();
			try {

				Query query = manager.createNamedQuery("signIn");
				List<SignUpEntity> list = query.getResultList();
				log.info("total lists in repo" + list.size());
				return list;
			} finally {
				manager.close();
			}

		
	}

	@Override
	public Long findByUserId(String userId) {
		log.info("running findByUserId in repo");
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = entityManager.createNamedQuery("findByUserId");
			query.setParameter("userBy", userId);
			Object object = query.getSingleResult();
			Long value = (Long) object;
			System.out.println(value);
			return value;

		} finally {
			entityManager.close();
		}
	}

	@Override
	public Long findByEmailId(String email) {
		log.info("running findByEmailId in repo");
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = entityManager.createNamedQuery("findByEmail");
			query.setParameter("emailBy", email);
			Object object = query.getSingleResult();
			Long value = (Long) object;
			System.out.println(value);
			return value;

		} finally {
			entityManager.close();
		}
	}

	@Override
	public Long findByMobileNumber(Long mobile) {
		log.info("running findByMobileNumber in repo");
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = entityManager.createNamedQuery("findByMobile");
			query.setParameter("mobile", mobile);
			Object object = query.getSingleResult();
			Long value = (Long) object;
			System.out.println(value);
			return value;

		} finally {
			entityManager.close();
		}
	}

}
