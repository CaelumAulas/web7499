package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PrintWriter out = resp.getWriter();

		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String dataTexto = req.getParameter("dataNascimento");
		
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		
		/*SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		formatador.parse(dataTexto);*/
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataTexto);
			Calendar dataNascimento = Calendar.getInstance();		
			dataNascimento.setTime(data);
			contato.setDataNascimento(dataNascimento);
		} catch (ParseException e) {
			out.println("Deu ruim");
			return;
		}
		
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
		
		RequestDispatcher rd = req.getRequestDispatcher("contato-adicionado.jsp");
		rd.forward(req, resp);
	}
}
