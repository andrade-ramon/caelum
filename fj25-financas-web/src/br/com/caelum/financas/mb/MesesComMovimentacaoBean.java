package br.com.caelum.financas.mb;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.modelo.ValorPorMesEAno;

@Named
@RequestScoped
public class MesesComMovimentacaoBean {
	@Inject
	private MovimentacaoDao dao;
	private Conta conta = new Conta();
	private TipoMovimentacao tipoMovimentacao;
	private List<ValorPorMesEAno> valoresPorMesEAno;

	public void lista() {
		valoresPorMesEAno = dao.listaMesesComMovimentacoes(tipoMovimentacao, conta);
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public Conta getConta() {
		return conta;
	}

	public List<ValorPorMesEAno> getValoresPorMesEAno() {
		return valoresPorMesEAno;
	}

}
