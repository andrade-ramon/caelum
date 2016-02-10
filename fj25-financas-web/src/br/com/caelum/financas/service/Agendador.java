package br.com.caelum.financas.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

@Stateless
public class Agendador {

	private static int totalCriado;

	@PostConstruct
	void posConstrucao() {
		System.out.println("construindo agendador");
		totalCriado++;
	}

	@PreDestroy
	void preDestucao() {
		System.out.println("destruindo agendador");
	}

	public void executa() {
		System.out.printf("%d instancias criadas %n", totalCriado);

		// simulando demora de 4s na execucao
		try {
			System.out.printf("Executando %s %n", this);
			Thread.sleep(4000);
		} catch (InterruptedException e) {
		}
	}

}
