package com.acsousa;

import javax.persistence.Persistence;

import org.junit.Test;

public class TestJPA {
	
	@Test
	public void testJPA() {
		Persistence.createEntityManagerFactory("jsf012-hibernate");
	}

}
