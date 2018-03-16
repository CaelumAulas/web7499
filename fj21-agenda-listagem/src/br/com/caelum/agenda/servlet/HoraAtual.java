package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HoraDeBrasilia")
public class HoraAtual extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		PrintWriter out = resp.getWriter();
		out.println("<html>"
				+ "<head>"
				+ "<title>Hora Atual</title>"
				+ "</head>"
				+ "<body>"
				+ "<h2>Hora atual: "
				+ Calendar.getInstance().getTime()
				+ "</h2>"
				+ "</body>"
				+ "</html>");
		
	}
}
