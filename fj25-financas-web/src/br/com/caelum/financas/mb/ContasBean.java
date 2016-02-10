package br.com.caelum.financas.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;

@Named
@ViewScoped
public class ContasBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private ContaDao contaDao;

	private Conta conta = new Conta();
	private List<Conta> contas;

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public void grava() {
		if (conta.getId() == null) {
			contaDao.adiciona(conta);
		} else {
			contaDao.altera(conta);
		}
		contas = contaDao.lista();
		limpaFormularioDoJSF();
	}

	public List<Conta> getContas() {
		if (contas == null) {
			contas = contaDao.lista();
		}
		return contas;
	}

	public void remove() {
		contaDao.remove(conta);
		contas = contaDao.lista();
		limpaFormularioDoJSF();
	}

	/**
	 * Esse metodo apenas limpa o formulario da forma com que o JSF espera.
	 * Invoque-o no momento em que precisar do formulario vazio.
	 */
	private void limpaFormularioDoJSF() {
		this.conta = new Conta();
	}
}
