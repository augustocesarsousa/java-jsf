package com.acsousa;

import javax.persistence.EntityManager;

import com.acsousa.utils.JPAUtil;

public class App {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
	}

}
