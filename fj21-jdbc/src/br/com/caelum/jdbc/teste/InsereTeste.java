package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class InsereTeste {
	public static void main(String[] args) {
		ContatoDAO dao = new ContatoDAO();
		Contato c = new Contato();
		c.setNome("Ramon Andrade");
		c.setEmail("andrade.rmn@gmail.com");
		c.setEndereco("Rua teste, 444");
		c.setDataNascimento(Calendar.getInstance());
		
		dao.adiciona(c);
		System.out.println("Contato Gravado");
	}
}
