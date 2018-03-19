package br.com.caelum.mvc.logica;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveContatoLogic implements Logica {
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("id"));

        Contato contato = new Contato();
        contato.setId(id);

        ContatoDao dao = new ContatoDao();
        dao.exclui(contato);

        System.out.println("Excuindo contato...");

        return "lista-contatos.jsp";
    }
}
