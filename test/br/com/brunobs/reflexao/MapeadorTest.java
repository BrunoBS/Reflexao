package br.com.brunobs.reflexao;

import static org.junit.Assert.assertEquals;

import java.net.InterfaceAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import br.com.brunobs.model.ExampleImp;
import br.com.brunobs.model.ExampleInterface;
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
		Class<?> classe = mapeador
				.carregaClass("br.com.brunobs.model.Usuario1");

	}

	@Test
	public void testGetClassQueExiste() {
		Class<?> classe = mapeador.carregaClass("br.com.brunobs.model.Usuario");
		assertEquals(classe, Usuario.class);
	}

	@Test
	public void InstanciarUmList() {
		List l;
		l = mapeador.getIntanciar(List.class);
		assertEquals(l.getClass(), ArrayList.class);
	}

	@Test
	public void InstanciarUmMap() {
		Map l;
		l = mapeador.getIntanciar(Map.class);
		assertEquals(l.getClass(), HashMap.class);
	}

	@Test
	public void InstanciarObjetoComConstrutorComParametros() {
		ExampleInterface l;
		l = mapeador.getIntanciar(ExampleInterface.class, "Barbosinha");
		assertEquals(l.getClass(), ExampleImp.class);
	}
}
