package br.com.caelum.agenda.mvc.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class ListaContatosLogic implements Logica {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection con = (Connection) req.getAttribute("connection");
		List<Contato> contatos = new ContatoDao(con).getLista();

		req.setAttribute("contatos", contatos);
		return "/WEB-INF/lista-contatos.jsp";
	}
}
