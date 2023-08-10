package com.acsousa.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.acsousa.daos.GenericDAO;
import com.acsousa.daos.LoginDAO;
import com.acsousa.entities.Usuario;

@SessionScoped
@ManagedBean(name = "usuarioBean")
public class UsuarioBean {
	
	private Usuario usuario = new Usuario(); 
	private GenericDAO<Usuario> genericDAO = new GenericDAO<>();	
	private LoginDAO loginDAO = new LoginDAO();
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private FacesContext context = FacesContext.getCurrentInstance();
	private ExternalContext externalContext = context.getExternalContext();
	private String msgLogin;
	
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
	
	public String getMsgLogin() {
		return msgLogin;
	}
	
	public void setMsgLogin(String msgLogin) {
		this.msgLogin = msgLogin;
	}
	
	public String login() {
		Usuario usuarioLogado = loginDAO.login(usuario.getEmail(), usuario.getSenha());
		
		if(usuarioLogado != null) {
			externalContext.getSessionMap().put("usuarioLogado", usuarioLogado);
			findAll();
			setMsgLogin("");
			return "index.xhtml";
		}
		
		setMsgLogin("Usuário ou senha inválido!");		
		return "login.xhtml";
	}
	
	public Boolean permiteAcesso(String perfil) {
		Usuario usuarioLogado = (Usuario) externalContext.getSessionMap().get("usuarioLogado");
		return usuarioLogado.getPerfil().equalsIgnoreCase(perfil);
	}

	public String save() {
		genericDAO.update(usuario);
		usuario = new Usuario();
		return "index?faces-redirect=true";
	}
	
	public void findAll() {
		usuarios = genericDAO.findAll(Usuario.class);
	}
	
	public String delete() {
		genericDAO.delete(Usuario.class, usuario.getId());
		usuario = new Usuario();
		return "index?faces-redirect=true";
	}
	
	public String redirectCadastro() {
		return "cadastro?faces-redirect=true";
	}
	
	public String redirectIndex() {
		usuario = new Usuario();
		return "index?faces-redirect=true";
	}
}
