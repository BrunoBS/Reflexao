package br.com.brunobs.reflexao;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Mapeador {
	private Map<Class<?>, Class<?>> mapa = new HashMap<>();

	public Mapeador(String file) {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(file));
			for (Object key : prop.keySet()) {
				Class<?> interF = Class.forName(key.toString());
				Class<?> impl = Class.forName(prop.get(key).toString());
				if (!interF.isAssignableFrom(impl)) {
					throw new RuntimeException("A Classe  " + impl.getName()
							+ " não implementa a interface + "
							+ interF.getName());
				}
				mapa.put(interF, impl);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public Class<?> carregaClass(String path) {
		try {
			Class<?> clazz = null;
			if (path != null) {
				clazz = Class.forName(path);
			} else {
				throw new RuntimeException("Chave inválida");
			}

			return clazz;

		} catch (Exception e) {
			throw new RuntimeException("Erro ao carregar a classe: " + path
					+ ", verifique se ela realmente existe!");
		}
	}

	public Class<?> getImplementacao(Class<?> interF) {
		return mapa.get(interF);

	}

	public <E> E getIntanciar(Class<E> interF) {
		try {
			return (E) getImplementacao(interF).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public <E> E getIntanciar(Class<E> interF, Object ... params) {
		try {
			
			Class<?> clazz = getImplementacao(interF);
			Class<?>[] tiposConstrutor = new Class<?>[params.length];
			for (int i = 0; i < tiposConstrutor.length; i++) {
				tiposConstrutor[i] =params[i].getClass();
			}
			Constructor<?>c = clazz.getConstructor(tiposConstrutor);
			return (E)c.newInstance(params);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
