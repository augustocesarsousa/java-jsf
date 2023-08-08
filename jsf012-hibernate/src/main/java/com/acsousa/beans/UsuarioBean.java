package com.acsousa.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.acsousa.daos.GenericDAO;
import com.acsousa.entities.Usuario;

@ViewScoped
@ManagedBean(name = "usuarioBean")
public class UsuarioBean {
	
	private Usuario usuario = new Usuario(); 
	private GenericDAO<Usuario> genericDAO = new GenericDAO<>();	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String save() {
		genericDAO.save(usuario);
		return "index";
	}
}
