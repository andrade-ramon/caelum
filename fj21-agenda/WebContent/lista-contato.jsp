<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<jsp:useBean id="dao" class="br.com.caelum.agenda.dao.ContatoDao" />
	<table border="0">
		<tr>
			<th>Nome</th>
			<th>Email</th>
			<th>Endereço</th>
			<th>Data de nascimento</th>
		</tr>
		<c:forEach var="contato" items="${dao.lista }" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'ae8' : 'fff' }">
				<td>${contato.nome }</td>
				<td>
					<c:if test="${not empty contato.email }">
						<a href="mailto:${contato.email }">${contato.email}</a>
					</c:if> 
					<c:if test="${empty contato.email }">
						Email não informado
					</c:if>
				</td>
				<td>${contato.endereco}</td>
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${contato.dataNascimento.time }" /></td>
			</tr>
		</c:forEach>
	</table>
	<c:import url="rodape.jsp" />
</body>
</html>