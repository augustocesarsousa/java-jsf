package com.acsousa.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import com.acsousa.utils.JPAUtil;

@SuppressWarnings("unchecked")
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
	
	public E findById(Class<E> entity, Long id) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		E result = null;

		entityTransaction.begin();
		try {
			result = (E) entityManager.createQuery("from " + entity.getName() + " where id = " + id).getSingleResult();			
		} catch (NoResultException e) {
			return null;
		} finally {
			entityTransaction.commit();
			entityManager.close();
		}		
		
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
	
	public void delete(Class<E> entity, Long id) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.createQuery("delete from " + entity.getName() + " where id = " + id).executeUpdate();
		entityTransaction.commit();
		entityManager.close();		
	}
}
