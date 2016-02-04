package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;

public class TesteListagemConta {
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		ContaDao dao = new ContaDao(manager);
		
		List<Conta> lista = dao.lista();
		
		lista.forEach(c -> System.out.println(c.getId() + " - " + c.getTitular()));
		
		manager.close();
	}
}
