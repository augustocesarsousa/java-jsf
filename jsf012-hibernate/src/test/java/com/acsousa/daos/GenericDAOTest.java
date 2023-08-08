package com.acsousa.daos;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.acsousa.entities.Usuario;

import junit.framework.Assert;

public class GenericDAOTest {

	@Test
	public void salvarNovoUsuario() throws ParseException {
		GenericDAO<Usuario> genericDAO = new GenericDAO<>();
		Usuario usuario = new Usuario();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		usuario.setNome("Augusto");
		usuario.setSobrenome("Sousa");
		usuario.setIdade(31);
		usuario.setDataNascimento(simpleDateFormat.parse("11/06/1992"));
		usuario = genericDAO.save(usuario);
		
		Assert.assertTrue(usuario.getId() != null);
	}
}
