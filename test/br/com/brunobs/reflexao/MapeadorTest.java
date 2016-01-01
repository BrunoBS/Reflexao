package br.com.brunobs.reflexao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.brunobs.model.Usuario;
import br.com.brunobs.reflexao.Mapeador;

public class MapeadorTest {
	private Mapeador mapeador;

	@Before
	public void load() {
		this.mapeador = new Mapeador("classes.prop");
	}

	@Test
	public void testMapeador() {
		Class<?> classe = mapeador.getImplementacao(List.class);
		assertEquals(classe, ArrayList.class);

	}

	 @Test(expected = RuntimeException.class)
	 public void testGetClassQueNaoExiste() {
	 Class<?> classe =mapeador.carregaClass("br.com.brunobs.model.Usuario1");
	
	 }

	public void testGetClassQueExiste() {
		Class<?> classe = mapeador.carregaClass("br.com.brunobs.model.Usuario");
		assertEquals(classe, Usuario.class);
	}

}
