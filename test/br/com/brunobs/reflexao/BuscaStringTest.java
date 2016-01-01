package br.com.brunobs.reflexao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import br.com.brunobs.model.Usuario;
import br.com.brunobs.reflexao.BuscaString;

public class BuscaStringTest {

	@Test
	public void buscaString() {
		Usuario u = new Usuario();
		u.ativo=true;
		u.email="usuario";
		u.login="usuario";
		u.papel="usuario";
		List<String> lista = BuscaString.getAtributosNulos(u, u.login);
		assertEquals(3, lista.size());
		assertTrue(lista.contains("login"));
	}
	

}
