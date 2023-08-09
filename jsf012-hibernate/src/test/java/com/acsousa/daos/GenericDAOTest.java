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
	public void deveSalvarNovoUsuario() throws ParseException {
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
	public void deveConsultarTodosUsuarios() throws ParseException {
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
	
	@Test
	public void deveConsultaUsuarioPorIdQuandoUsuarioExiste() throws ParseException {
		GenericDAO<Usuario> genericDAO = new GenericDAO<>();
		Usuario usuario = new Usuario();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		usuario.setNome("Teste");
		usuario.setSobrenome("ConsultarPorId");
		usuario.setEmail("teste@consultaporid.com");
		usuario.setTelefone("1144448888");
		usuario.setDataNascimento(simpleDateFormat.parse("01/01/2000"));
		
		usuario = genericDAO.save(usuario);
		usuario = genericDAO.findById(Usuario.class, usuario.getId());
		
		Assert.assertTrue(usuario.getSobrenome().equalsIgnoreCase("ConsultarPorId"));
	}
	
	@Test
	public void deveRetornarNullQuandoUsuarioNaoExiste() throws ParseException {
		GenericDAO<Usuario> genericDAO = new GenericDAO<>();
		Usuario usuario = new Usuario();
		usuario = genericDAO.findById(Usuario.class, Long.MAX_VALUE);
		
		Assert.assertTrue(usuario == null);
	}

	@Test
	public void deveAtualizarUsuario() throws ParseException {
		GenericDAO<Usuario> genericDAO = new GenericDAO<>();
		Usuario usuario = new Usuario();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		usuario.setNome("Teste");
		usuario.setSobrenome("");
		usuario.setEmail("teste@update.com");
		usuario.setTelefone("1144448888");
		usuario.setDataNascimento(simpleDateFormat.parse("01/01/2000"));
		
		usuario = genericDAO.save(usuario);	
		usuario.setSobrenome("Update");
		usuario = genericDAO.update(usuario);
		
		Assert.assertTrue(usuario.getSobrenome().equalsIgnoreCase("Update"));
	}
	
	@Test
	public void deveDeletarUsuario() throws ParseException {
		GenericDAO<Usuario> genericDAO = new GenericDAO<>();
		Usuario usuario = new Usuario();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		usuario.setNome("Teste");
		usuario.setSobrenome("Delete");
		usuario.setEmail("teste@delete.com");
		usuario.setTelefone("1144448888");
		usuario.setDataNascimento(simpleDateFormat.parse("01/01/2000"));
		
		usuario = genericDAO.save(usuario);
		genericDAO.delete(Usuario.class, usuario.getId());
		usuario = genericDAO.findById(Usuario.class, usuario.getId());
		
		Assert.assertTrue(usuario == null);
	}
}
