package br.com.caelum.jdbc.main;

import java.sql.SQLException;
import java.util.List;

import br.com.caelum.jdbc.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		
		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.getLista();
		
		for (Contato contato : contatos) {
			System.out.println("Id: " + contato.getId() + 
					", Nome: " + contato.getNome() + 
					", data nascimento: " + contato.getDataNascimento().getTime());
		}
	}
}
