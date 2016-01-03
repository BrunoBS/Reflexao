package br.com.brunobs.reflexao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.brunobs.model.Usuario;

public class ValidadorTest {
	
   private Usuario usuario= new Usuario();
	   
	   @Before
	   public void preencheUsuario(){
		   usuario.setLogin("Bruno");
		   usuario.setAtivo(true);
		   usuario.setSenha("123456789");
		   usuario.setEmail("bbsgt@hotmail.com");
		   usuario.setPapel("programador");
	   }

	@Test
	public void validadorSucessoTest() throws Exception {
		assertTrue(Validador.validarObjeto(usuario));
	}
	
	@Test
	public void validadorSenhaCurtaTest() throws Exception {
		usuario.setSenha("123");
		assertFalse(Validador.validarObjeto(usuario));
	}
	
	@Test
	public void validadorEmailInvalidoTest() throws Exception {
		usuario.setEmail("email.com.br");
		assertFalse(Validador.validarObjeto(usuario));
	}
	
	@Test
	public void validadorLoginInvalidoTest() throws Exception {
		usuario.setLogin("L");
		assertFalse(Validador.validarObjeto(usuario));
	}

}
