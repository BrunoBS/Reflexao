package br.com.brunobs.reflexao;

import java.lang.reflect.Method;

public class Validador {

	public static boolean validarObjeto(Object obj) throws Exception {
		boolean resultado = true;
		Class<?> clazz = obj.getClass();
		for (Method m : clazz.getMethods()) {
			if (chamaMetodo(m)) {
				Boolean retorno = (Boolean) m.invoke(obj);
				resultado = resultado && retorno;
			}
		}
		return resultado;

	}

	private static boolean chamaMetodo(Method m) {
		return m.getName().startsWith("validar")
				&& m.getReturnType() == boolean.class
				&& m.getParameterTypes().length == 0;
	}

}
