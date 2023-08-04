package com.acsousa.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="testBean")
public class TestBean {

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
