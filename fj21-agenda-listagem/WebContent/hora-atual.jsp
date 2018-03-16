<%@page import="java.util.Calendar" %>
<%@page pageEncoding="utf-8" contentType="text/html" %>
<html>
	<head>
		<title>Hora atual</title>
		<meta charset="utf-8">
	</head>
	<body>
        <% Calendar agora = Calendar.getInstance(); %>
		<h2>Página com a hora atual:
            <% out.println(agora.getTime()); %></h2>

        <h2>Outra forma de escrever na página:
            <%= agora.getTime() %></h2>
	</body>
</html>