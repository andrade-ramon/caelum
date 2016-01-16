<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
	<script type="text/javascript" src="resources/js/jquery.js"></script>
	<script type="text/javascript" src="resources/js/jquery-dateFormat.js"></script>
	<link type="text/css" href="resources/css/tarefas.css" rel="stylesheet" />	
</head>
<body>
	<script type="text/javascript">
		function finalizaAgora(id) {
			$.post("finalizaTarefa", {'id' : id}, function() {
			// selecionando o elemento html através da
			// ID e alterando o HTML dele
				$("#tarefa_" + id).html("Finalizado");
		
				$("#tarefa_" + id).prev().html($.format.date(new Date(), 'dd/MM/yyyy'));
			});
		}
		
		function remover(id) {
			$.post("removeTarefa", {'id' : id}, function(){
				$("#tarefa_" + id).parent().remove();
			});
		}
	</script>
	<a href="novaTarefa">Criar nova tarefa</a>
	<br />
	<br />
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Descrição</th>
			<th>Finalizado?</th>
			<th>Data de finalização</th>
			<th></th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${tarefas}" var="tarefa">
			<tr>
				<td>${tarefa.id}</td>
				<td>${tarefa.descricao}</td>
				<c:if test="${tarefa.finalizado eq false}">
					<td>Não finalizado</td>
				</c:if>
				<c:if test="${tarefa.finalizado eq true}">
					<td>Finalizado</td>
				</c:if>
				<td><fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy" /></td>
				
				<td id="tarefa_${tarefa.id}">
					<c:if test="${tarefa.finalizado eq false}">
						<a href="#" onClick="finalizaAgora(${tarefa.id})">Finaliza agora!</a>
					</c:if>
					<c:if test="${tarefa.finalizado eq true}">Finalizado</c:if>
				</td>
				<td><a href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>
				<td><a href="#" onClick="remover(${tarefa.id})">Remover</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>