package br.com.brunobs.reflexao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.brunobs.model.Usuario;

public class BuscaStringTest {

	@Test
	public void buscaString() {
		Usuario u = new Usuario();
		u.setAtivo(true);
		u.setEmail("usuario");
		u.setLogin("usuario");
		u.setPapel("usuario");
		List<String> lista = BuscaString.find(u, u.getLogin());
		assertEquals(3, lista.size());
		assertTrue(lista.contains("login"));
	}
	

}
