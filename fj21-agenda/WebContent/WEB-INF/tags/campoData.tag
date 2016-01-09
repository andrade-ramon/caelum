<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ attribute name="id" required="true"%>
<%@ attribute name="data" required="false"%>

<input id="${id}" name="${id}" value="${data }"/>

<script>
	$("#${id}").datepicker({
		dateFormat : 'dd/mm/yy'
	});
</script>
