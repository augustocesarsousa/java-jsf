package com.acsousa.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name="pessoaBean")
public class PessoaBean {

	private String nome;
	private List<String> listaNomes = new ArrayList<>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<String> getListaNomes() {
		return listaNomes;
	}
	public void setListaNomes(List<String> listaNomes) {
		this.listaNomes = listaNomes;
	}
	
	public String addNome() {
		listaNomes.add(nome);
		return "";
	}
}
