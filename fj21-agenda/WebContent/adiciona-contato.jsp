<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Contato</title>
<link href="css/jquery.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	
	<form action="adicionaContato">
		<c:if test="${not empty contato.id }">
			<input type="hidden" name="id" value="${contato.id }" />
		</c:if>
		
		Nome:<input type="text" name="nome" value="${contato.nome }"/><br/>
		E-mail:<input type="text" name="email" value="${contato.email}"/><br/>
		Endereço:<input type="text" name="endereco" value="${contato.endereco }"/><br/>
		
		<fmt:formatDate value="${contato.dataNascimento.time }" pattern="dd/MM/yyyy" var="data" />
		Data Nascimento:<caelum:campoData id="dataNascimento" data="${data }"/><br/>
		<input type="submit" value="Gravar"/>
	</form>
	
	<c:import url="rodape.jsp" />
</body>
</html>