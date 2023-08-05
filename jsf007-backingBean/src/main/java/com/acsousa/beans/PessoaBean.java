package com.acsousa.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;

@ViewScoped
@ManagedBean(name="pessoaBean")
public class PessoaBean {

	private String nome;
	private List<String> listaNomes = new ArrayList<>();
	private HtmlCommandButton commandButton;
	
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
	
	public HtmlCommandButton getCommandButton() {
		return commandButton;
	}
	public void setCommandButton(HtmlCommandButton commandButton) {
		this.commandButton = commandButton;
	}
	
	public String addNome() {
		listaNomes.add(nome);
		
		if(listaNomes.size() > 3) {
			commandButton.setDisabled(true);
		}
		
		return "";
	}
}
