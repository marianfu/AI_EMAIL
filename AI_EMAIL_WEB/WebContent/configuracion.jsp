

<a href="#"><strong><i class="glyphicon glyphicon-stats"></i>
		Configuración de Modulos</strong></a>
<hr>

<%
	String ip = (String) request.getAttribute("ip");
	String puerto = (String) request.getAttribute("puerto");
	String cola = (String) request.getAttribute("cola");
	String modulo = (String) request.getAttribute("modulo");
	String activo = (String) request.getAttribute("activo");
%>
<div>
	<br>
	<h4>Mi configuración</h4>
	<table class="table">
		<tr>
			<th>Ip</th>
			<th>Puerto</th>
			<th>Cola</th>
			<th>Modulo</th>
			<th>Activo</th>
		</tr>
		<tbody id="tbody">
			<tr>
				<td><%= ip %></td>
				<td><%= puerto %></td>
				<td><%= cola %></td>
				<td><%= modulo %></td>
				<td><%= activo %></td>
			</tr>
		</tbody>
	</table>

</div>


<script type="text/javascript">
	$(document).ready(function() {
		var ip = "<%= ip %>";
		var puerto = <%= puerto %>;
		var flag = 0;
		
		$("#contar").click(function() {

			$.ajax({
				type : "POST",
				data : cantidad,
				//dataType : "json",
				url : "PoolDatabase",
				success : function(data) {

				}
			});
		});
	});
</script>
