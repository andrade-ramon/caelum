package br.com.caelum.financas.service;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.ScheduleExpression;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

@Stateless
@Startup
public class Agendador {
	@Resource // EJB Injeta o TimeService
	private TimerService timeService;
	private static int totalCriado;

	public Agendador() {
		// Não é possível acessar o objeto TimerService pois a
		// injeção(@Resource)
		// só ocorre depois do da construção do objeto
		// Collection<Timer> timers = timeService.getTimers();
	}

	public void agenda(String expressaoMinutos, String expressaoSegundos) {
		ScheduleExpression expression = new ScheduleExpression();
		expression.hour("*");
		expression.minute(expressaoMinutos);
		expression.second(expressaoSegundos);

		TimerConfig config = new TimerConfig();
		config.setInfo(expression.toString());
		config.setPersistent(false);

		this.timeService.createCalendarTimer(expression, config);

		System.out.println("Agendamento: " + expression);
	}

	@Timeout
	public void verificacaoPeriodicaSeHaNovasContas(Timer timer) {
		System.out.println(timer.getInfo());
		// aqui poderiamos acessar o bamco de dados
		// com JPA para verificar as contas periodicamente
	}

	@Schedule(hour = "9", minute = "*", second = "*", dayOfWeek = "Wed", persistent = false)
	public void autoAgendamento() {
		System.out.println("Realizando o que foi definido no metodo autoAgendamento");
	}

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
