package com.acsousa;

import javax.persistence.Persistence;

public class TestJPA {
	
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("jsf012-hibernate");
	}

}
