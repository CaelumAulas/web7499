package br.com.caelum.jdbc.main;

import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.jdbc.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) throws SQLException {
		
		Contato contato = new Contato();
		contato.setNome("D'arc");
		contato.setEmail("j@j.com");
		contato.setEndereco("Rua V.");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
	}
}
