<%@ page import="java.util.*,
                br.com.caelum.agenda.dao.*,
                br.com.caelum.agenda.modelo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de contatos</title>
</head>
<body>

    <c:import url="cabecalho.jsp" />

    <jsp:useBean id="dao" class="br.com.caelum.agenda.dao.ContatoDao" />

    <table border="1">
        <thead>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Endereco</th>
                <th>Email</th>
                <th>Data de Nascimento</th>
            </tr>
        </thead>

        <c:forEach var="contato" items="${dao.lista}">
            <tr>
                <td>${contato.id}</td>
                <td>${contato.nome}</td>
                <td>${contato.endereco}</td>
                <c:if test="${empty contato.email}">
                    <td>Email não informado</td>
                </c:if>
                <c:if test="${not empty contato.email}">
                    <td>
                        <a href="mailto:${contato.email}">${contato.email}</a>
                    </td>
                </c:if>
                <td>
                        <fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" />
                </td>
                <td>
                    <a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
                </td>
            </tr>
        </c:forEach>

    </table>

    <c:import url="rodape.jsp" />
</body>
</html>
