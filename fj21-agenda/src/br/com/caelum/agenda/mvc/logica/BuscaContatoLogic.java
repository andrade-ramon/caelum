package br.com.caelum.agenda.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;

public class BuscaContatoLogic implements Logica{
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Long id = Long.parseLong(req.getParameter("id"));
		Connection con = (Connection) req.getAttribute("connection");
		req.setAttribute("contato", new ContatoDao(con).buscaContato(id));
		return "adiciona-contato.jsp";
	}
}
