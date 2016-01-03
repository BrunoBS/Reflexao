package br.com.brunobs.reflexao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.com.brunobs.model.NotaFiscal;
import br.com.brunobs.model.Produto;
import br.com.brunobs.model.Usuario;
import br.com.brunobs.reflexao.ValidadorDeNulo;

public class ValidadorDeNuloTest {

	@Test
	public void testUsuario() {
		Usuario u = new Usuario();
		u.setAtivo(true);
		u.setEmail("usurio@email.com");
		u.setLogin("master");
		u.setPapel("admin");
		List<String> lista = ValidadorDeNulo.getAtributosNulos(u);
		assertEquals(1, lista.size());
		assertTrue(lista.contains("senha"));
	}
	
	@Test
	public void testProduto() {
		Produto p = new Produto();
		p.codigo="1";
		p.descricao="tv";
		p.fornecedor="LG";
		p.preco=1400.00f;
		
		List<String> lista = ValidadorDeNulo.getAtributosNulos(p);
		assertEquals(1, lista.size());
		assertTrue(lista.contains("nome"));
	}
	
	@Test
	public void testNotaFiscal() {
		NotaFiscal p = new NotaFiscal();
		p.talao="3";
		p.sequencia="123";
			
		List<String> lista = ValidadorDeNulo.getAtributosNulos(p);
		assertEquals(3, lista.size());
		assertTrue(lista.contains("cnpj"));
		assertTrue(lista.contains("data"));
		assertTrue(lista.contains("endereco"));
	}


}
