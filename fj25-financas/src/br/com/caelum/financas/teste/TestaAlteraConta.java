package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;

public class TestaAlteraConta {
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		ContaDao dao = new ContaDao(manager);
		
		Conta conta = dao.busca(6);
		conta.setTitular("Teste de alteração");
		
		manager.getTransaction().begin();
		dao.altera(conta);
		manager.getTransaction().commit();
		
		manager.close();
		
	}
}
