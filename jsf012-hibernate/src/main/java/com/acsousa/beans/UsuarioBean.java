package com.acsousa.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
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
	private Logger logger = Logger.getLogger(UsuarioBean.class.getName());
	
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
	
	public String login() {
		Usuario usuarioLogado = loginDAO.login(usuario.getEmail(), usuario.getSenha());
		
		if(usuarioLogado != null) {
			externalContext.getSessionMap().put("usuarioLogado", usuarioLogado);
			findAll();
			return "index.xhtml";
		}
			
		mostrarMsg("Usuário ou senha inválido!");	
		return "login.xhtml";
	}
	
	public String logout() {
		externalContext.getSessionMap().remove("usuarioLogado");
		return "login?faces-redirect=true";
	}
	
	public Boolean permiteAcesso(String perfil) {
		Usuario usuarioLogado = (Usuario) externalContext.getSessionMap().get("usuarioLogado");
		return usuarioLogado.getPerfil().equalsIgnoreCase(perfil);
	}

	public String save() {
		genericDAO.update(usuario);
		usuario = new Usuario();
		mostrarMsg("Usuário salvo com sucesso!");
		return "index?faces-redirect=true";
	}
	
	public void findAll() {
		usuarios = genericDAO.findAll(Usuario.class);
	}
	
	public String delete() {
		genericDAO.delete(Usuario.class, usuario.getId());
		usuario = new Usuario();
		mostrarMsg("Usuário deletado com sucesso!");
		return "index?faces-redirect=true";
	}
	
	public String redirectCadastro() {
		return "cadastro?faces-redirect=true";
	}
	
	public String redirectIndex() {
		usuario = new Usuario();
		return "index?faces-redirect=true";
	}
	
	private void mostrarMsg(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(msg);
		context.addMessage(null, message);
	}
	
	public void log() {
		logger.log(Level.INFO, "Evento de ActionListener");
	}
}
