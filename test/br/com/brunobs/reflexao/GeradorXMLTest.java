package br.com.brunobs.reflexao;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import br.com.brunobs.model.Usuario;

public class GeradorXMLTest {
	   private Usuario usuario= new Usuario();
	   
	   @Before
	   public void preencheUsuario(){
		   usuario.setLogin("Bruno");
		   usuario.setAtivo(true);
		   usuario.setSenha("123456");
		   usuario.setEmail("bbsgt@hotmail.com");
		   usuario.setPapel("programador");
	   }

	@Test
	public void testGeraXML() throws Exception {
	 
	   String xml  = GeradorDeDados.geraXML(usuario);
	   assertTrue(xml.contains("<Usuario>"));
	   assertTrue(xml.contains("<login>Bruno</login>"));
	   assertTrue(xml.contains("<login>"));
	   
	}
	
	@Test
	public void testGeraMAP() throws Exception {
	   Map mapa = GeradorDeDados.geraMAP(usuario);
	   assertEquals(5, mapa.size());
	   assertEquals(mapa.get("login"), "Bruno");
		   
	}


}
