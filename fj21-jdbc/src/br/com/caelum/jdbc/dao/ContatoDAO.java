package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDAO {
	private Connection con;

	public ContatoDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato c) {
		String sql = "insert into contatos (nome,email,endereco,dataNascimento)" + "values(?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, c.getNome());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getEndereco());
			ps.setDate(4, new Date(c.getDataNascimento().getTimeInMillis()));

			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contato> listaContatos() {
		try {
			PreparedStatement ps = con.prepareStatement("select * from contatos");
			ResultSet rs = ps.executeQuery();
			List<Contato> contatos = new ArrayList<>();
			
			while(rs.next()){
				Contato c = new Contato();
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setEndereco(rs.getString("endereco"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				c.setDataNascimento(data);
				
				contatos.add(c);
			}
			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
