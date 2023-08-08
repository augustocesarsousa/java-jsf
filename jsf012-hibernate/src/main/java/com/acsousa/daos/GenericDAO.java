package com.acsousa.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.acsousa.utils.JPAUtil;

public class GenericDAO<E> {

	public E save(E entity) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(entity);
		entityManager.flush();
		entityTransaction.commit();
		entityManager.close();
		
		return entity;
	}
}
