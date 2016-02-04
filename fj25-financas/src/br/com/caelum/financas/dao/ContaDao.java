package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;

public class ContaDao {
	private EntityManager manager;

	public ContaDao(EntityManager manager) {
		this.manager = manager;
	}

	public Conta busca(Integer id) {
		return this.manager.find(Conta.class, id);
	}

	public List<Conta> lista() {
		return manager.createQuery("select c from Conta c", Conta.class).getResultList();
	}

	public void adiciona(Conta conta) {
		manager.persist(conta);
	}

	public void remove(Conta conta) {
		manager.remove(conta);
	}

	public void altera(Conta conta) {
		manager.merge(conta);
	}
}
