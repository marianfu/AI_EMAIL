

<a href="#"><strong><i class="glyphicon glyphicon-info-sign"></i>
		Acerca del Módulo</strong></a>
<hr>

<%
	String ip = (String) request.getAttribute("ip");
	String puerto = (String) request.getAttribute("puerto");
	String cola = (String) request.getAttribute("cola");
	String modulo = (String) request.getAttribute("modulo");
	String activo = (String) request.getAttribute("activo");
%>
<div>
	<t>Este módulo se encarga de recibir de ítems de auditoría del módulo Logística y Monitoreo por medio de JMS. Los mismos podrán ser enviados posteriormente por mail.</t>
</div>

