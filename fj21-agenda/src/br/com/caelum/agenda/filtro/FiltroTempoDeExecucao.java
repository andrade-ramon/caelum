package br.com.caelum.agenda.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class FiltroTempoDeExecucao implements Filter {
	@Override
	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		long tempoInicial = System.currentTimeMillis();
		chain.doFilter(req, resp);
		long tempoFinal = System.currentTimeMillis();
		String uri = ((HttpServletRequest) req).getRequestURI();
		String parametros = ((HttpServletRequest) req).getParameter("logica");
		System.out.println("Tempo da requisicao de " + uri + "?logica=" + parametros + " demorou (ms): "
				+ (tempoFinal - tempoInicial));
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
