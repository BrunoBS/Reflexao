package br.com.brunobs.reflexao;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class GeradorDeDados {

	public static String geraXML(Object obj) throws Exception {
		StringBuilder sb = new StringBuilder();
		Class<?> c = obj.getClass();

		sb.append("<" + c.getSimpleName() + ">\n");
		for (Field f : c.getDeclaredFields()) {
			sb.append("<" + f.getName() + ">");
			f.setAccessible(true);
			sb.append(f.get(obj));
			sb.append("</" + f.getName() + ">\n");

		}

		sb.append("</" + c.getSimpleName() + ">\n");
		return sb.toString();
	}

	public static Map geraMAP(Object obj) throws Exception {
		Map<String, Object> map = new HashMap();
		Class<?> c = obj.getClass();
		for (Field f : c.getDeclaredFields()) {
			f.setAccessible(true);
			map.put(f.getName(), f.get(obj));

		}
		return map;
	}
}
