package com.acsousa.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import com.acsousa.entities.Usuario;
import com.acsousa.utils.JPAUtil;

public class LoginDAO {

	public Usuario login(String email, String senha) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Usuario usuario = null;

		entityTransaction.begin();
		try {
			usuario = (Usuario) entityManager.createQuery("from Usuario where email = '" + email + "' and senha = '" + senha + "'").getSingleResult();			
		} catch (NoResultException e) {
			return null;
		} finally {
			entityTransaction.commit();
			entityManager.close();
		}		
		
		return usuario;
	}
}
