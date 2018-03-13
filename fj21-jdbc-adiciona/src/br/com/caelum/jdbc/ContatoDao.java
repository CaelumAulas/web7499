package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {

	public void adiciona(Contato contato) throws SQLException {
		Connection con = new ConnectionFactory().getConnection();

		String sql = "insert into contatos(nome, email, endereco, dataNascimento)" + " values(?, ?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		long milissegundos = contato.getDataNascimento().getTimeInMillis();
		stmt.setDate(4, new Date(milissegundos));

		stmt.execute();

		stmt.close();
		con.close();
	}
}
