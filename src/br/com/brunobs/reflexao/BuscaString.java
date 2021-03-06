package br.com.brunobs.reflexao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class BuscaString {

	public static List<String> find(Object o, String parametro) {
		List<String> retorno = new ArrayList<>();
		Class<?> classe = o.getClass();
		for (Field f : classe.getDeclaredFields()) {
			Object valor;
			try {
				f.setAccessible(true);
				valor = f.get(o);
				if (valor != null) {
					String string = valor.toString();
					if (string.contains(parametro)) {
						retorno.add(f.getName());
					}
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return retorno;
	}

}
