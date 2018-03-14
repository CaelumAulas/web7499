package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

	public List<Contato> getLista() {

		try {
			String sql = "select * from contatos";

			Connection conexao = new ConnectionFactory().getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			List<Contato> contatos = new ArrayList<>();
			
			while(rs.next()) {
				Contato c = new Contato();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setEndereco(rs.getString("endereco"));
				
				Date dataBanco = rs.getDate("dataNascimento");
				Calendar dataNascimento =  Calendar.getInstance();
				dataNascimento.setTime(dataBanco);
				c.setDataNascimento(dataNascimento);
				
				contatos.add(c);
			}
			
			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
