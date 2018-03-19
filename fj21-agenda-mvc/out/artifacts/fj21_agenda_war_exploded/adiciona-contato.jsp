<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>Novo Contato</title>
        <link rel="stylesheet" href="css/jquery.css">
        <script src="js/jquery.js"></script>
        <script src="js/jquery-ui.js"></script>
	</head>
	<body>
		<form action="adicionaContato" method="post">
			Nome: <input type="text" name="nome"><br>
			Email: <input type="text" name="email"><br>
			Endereco: <input type="text" name="endereco"><br>

			Data de Nascimento: <caelum:campoData id="dataNascimento" /> <br>

			<input type="submit" value="Salvar">
		</form>
	</body>
</html>