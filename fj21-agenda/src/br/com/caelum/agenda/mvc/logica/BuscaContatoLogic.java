package br.com.caelum.agenda.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;

public class BuscaContatoLogic implements Logica{
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Long id = Long.parseLong(req.getParameter("id"));
		req.setAttribute("contato", new ContatoDao().buscaContato(id));
		return "adiciona-contato.jsp";
	}
}
