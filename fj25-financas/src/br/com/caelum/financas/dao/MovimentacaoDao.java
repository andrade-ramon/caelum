package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Movimentacao;

public class MovimentacaoDao {
	private EntityManager manager;

	public MovimentacaoDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public void adiciona(Movimentacao movimentacao){
		manager.persist(movimentacao);
	}
	
	public Movimentacao busca(Integer id){
		return manager.find(Movimentacao.class, id);
	}
	
	public List<Movimentacao> lista(){
		return manager.createQuery("select m from Movimentacao m", Movimentacao.class).getResultList();
	}
	
}
