

<a href="#"><strong><i class="glyphicon glyphicon-info-sign"></i>
		Acerca del M�dulo</strong></a>
<hr>

<%
	String ip = (String) request.getAttribute("ip");
	String puerto = (String) request.getAttribute("puerto");
	String cola = (String) request.getAttribute("cola");
	String modulo = (String) request.getAttribute("modulo");
	String activo = (String) request.getAttribute("activo");
%>
<div>
	<t>Este m�dulo se encarga de recibir de �tems de auditor�a del m�dulo Log�stica y Monitoreo por medio de JMS. Los mismos podr�n ser enviados posteriormente por mail.</t>
</div>

