package com.acsousa.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name="nagevarBean")
public class NavegarBean {
	
	private Integer numero;

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public String navegar() {
		if(numero % 2 == 0) {
			return "paginaPar?faces-redirect=true";
		} else {
			return "paginaImpar?faces-redirect=true";
		}
	}
}
