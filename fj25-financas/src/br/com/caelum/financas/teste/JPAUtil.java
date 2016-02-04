package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("controledefinancas");

	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
