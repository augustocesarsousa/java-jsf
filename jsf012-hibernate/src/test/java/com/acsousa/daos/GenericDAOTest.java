package com.acsousa.daos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.acsousa.entities.Usuario;

import junit.framework.Assert;

public class GenericDAOTest {

	@Test
	public void salvarNovoUsuario() throws ParseException {
		GenericDAO<Usuario> genericDAO = new GenericDAO<>();
		Usuario usuario = new Usuario();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		usuario.setNome("Teste");
		usuario.setSobrenome("Salvar");
		usuario.setEmail("teste@salvar.com");
		usuario.setTelefone("1144448888");
		usuario.setDataNascimento(simpleDateFormat.parse("01/01/2000"));
		usuario = genericDAO.save(usuario);
		
		Assert.assertTrue(usuario.getId() != null);
	}
	
	@Test
	public void consultarTodosUsuarios() throws ParseException {
		GenericDAO<Usuario> genericDAO = new GenericDAO<>();
		Usuario usuario = new Usuario();
		List<Usuario> usuarios = new ArrayList<>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		usuario.setNome("Teste");
		usuario.setSobrenome("ConsultarTodos");
		usuario.setEmail("teste@consultartodos.com");
		usuario.setTelefone("1144448888");
		usuario.setDataNascimento(simpleDateFormat.parse("01/01/2000"));
		
		genericDAO.save(usuario);
		usuarios.addAll(genericDAO.findAll(Usuario.class));
		
		Assert.assertTrue(usuarios.size() > 0);
	}
}
