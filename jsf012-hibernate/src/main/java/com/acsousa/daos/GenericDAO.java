package com.acsousa.daos;

import java.util.List;

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
	
	public List<E> findAll(Class<E> entity) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		List<E> result = entityManager.createQuery("from " + entity.getName()).getResultList();
		entityTransaction.commit();
		entityManager.close();		
		
		return result;
	}

	public E update(E entity) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entity = entityManager.merge(entity);
		entityTransaction.commit();
		entityManager.close();
		
		return entity;
	}
}
