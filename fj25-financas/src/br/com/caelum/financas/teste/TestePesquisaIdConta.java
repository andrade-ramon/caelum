package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestePesquisaIdConta {
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		ContaDao dao = new ContaDao(manager);
		
		Conta encontrado = dao.busca(4);
		System.out.println(encontrado != null ? "Contato encontrado: " + encontrado.getTitular() : "Contado não encontrado");

		manager.close();
	}
}
