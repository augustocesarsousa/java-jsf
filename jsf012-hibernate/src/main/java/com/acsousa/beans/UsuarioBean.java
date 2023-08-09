package com.acsousa.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.acsousa.daos.GenericDAO;
import com.acsousa.entities.Usuario;

@SessionScoped
@ManagedBean(name = "usuarioBean")
public class UsuarioBean {
	
	private Usuario usuario = new Usuario(); 
	private GenericDAO<Usuario> genericDAO = new GenericDAO<>();	
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String save() {
		genericDAO.save(usuario);
		return "index";
	}
	
	public void findAll() {
		usuarios = genericDAO.findAll(Usuario.class);
	}
	
	public String redirectCadastro() {
		return "cadastro?faces-redirect=true";
	}
}
