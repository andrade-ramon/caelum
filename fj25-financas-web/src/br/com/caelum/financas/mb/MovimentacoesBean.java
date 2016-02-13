package br.com.caelum.financas.mb;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.dao.CategoriaDao;
import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

@Named
@ViewScoped
public class MovimentacoesBean implements Serializable {
	@Inject
	private MovimentacaoDao movimentacaoDao;
	@Inject
	private CategoriaDao categoriaDao;
	@Inject
	private ContaDao contaDao;

	private static final long serialVersionUID = 1L;

	private List<Movimentacao> movimentacoes;
	private List<Categoria> categorias;
	private Movimentacao movimentacao = new Movimentacao();
	private Integer contaId;
	private Integer categoriaId;

	public void adicionaCategoria() {
		if (getCategoriaId() != null && getCategoriaId() > 0) {
			Categoria categoria = categoriaDao.procura(getCategoriaId());
			movimentacao.getCategorias().add(categoria);
		}
	}

	public void grava() {
		Conta contaRelacionada = contaDao.busca(getContaId());

		movimentacao.setConta(contaRelacionada);
		movimentacaoDao.adiciona(movimentacao);
		movimentacoes = movimentacaoDao.lista();
		limpaFormularioDoJSF();
	}

	public void remove() {
		movimentacaoDao.remove(movimentacao);
		movimentacoes = movimentacaoDao.lista();
		limpaFormularioDoJSF();
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacaoDao.lista();
	}

	public Movimentacao getMovimentacao() {
		if (movimentacao.getData() == null) {
			movimentacao.setData(Calendar.getInstance());
		}
		return movimentacao;
	}

	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}

	public Integer getContaId() {
		return contaId;
	}

	public void setContaId(Integer contaId) {
		this.contaId = contaId;
	}

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}

	/**
	 * Esse metodo apenas limpa o formulario da forma com que o JSF espera.
	 * Invoque-o no momento manager que precisar do formulario vazio.
	 */
	private void limpaFormularioDoJSF() {
		this.movimentacao = new Movimentacao();
	}

	public TipoMovimentacao[] getTiposDeMovimentacao() {
		return TipoMovimentacao.values();
	}

	public List<Categoria> getCategorias() {
		if (this.categorias == null) {
			System.out.println("Listando as categorias");
			this.categorias = categoriaDao.lista();
		}
		return this.categorias;
	}

}
