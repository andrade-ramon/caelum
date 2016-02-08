package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.EnumTipoMovimentacao;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacao {
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		ContaDao contaDao = new ContaDao(manager);
		Conta conta = contaDao.busca(7);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setConta(conta);
		movimentacao.setDescricao("teste pre persist()");
		movimentacao.setTipoMovimentacao(EnumTipoMovimentacao.ENTRADA);
		movimentacao.setValor(new BigDecimal(100));
		
		MovimentacaoDao movDao = new MovimentacaoDao(manager);
		manager.getTransaction().begin();
		movDao.adiciona(movimentacao);
		manager.getTransaction().commit();
		manager.close();
	}
}
