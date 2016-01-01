package br.com.brunobs.reflexao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ValidadorDeNulo {

	public static List<String> getAtributosNulos(Object o) {
		List<String> retorno = new ArrayList<>();
		Class<?> classe = o.getClass();
		for (Field f : classe.getFields()) {
			Object valor;
			try {
				valor = f.get(o);
				if (valor == null) {
					retorno.add(f.getName());
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return retorno;
	}

}
