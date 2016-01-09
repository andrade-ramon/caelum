package br.com.caelum.agenda.mvc.servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.mvc.logica.Logica;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String param = req.getParameter("logica");
		String nomeClasse = "br.com.caelum.agenda.mvc.logica." + param;

		try {
			Class classe = Class.forName(nomeClasse);
			Logica logica = (Logica) classe.newInstance();
			String nomePagina = logica.executa(req, res);
			
			req.getRequestDispatcher(nomePagina).forward(req, res);
			
		} catch (Exception e) {
			System.out.println(nomeClasse);
			throw new ServletException("A lógica de negócios causou uma exceção", e);
		}
	}
}
