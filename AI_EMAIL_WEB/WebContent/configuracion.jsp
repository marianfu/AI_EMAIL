

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
			<th>Check</th>
		</tr>
		<tbody id="tbody">
			<tr>
				<td><%= ip %></td>
				<td><%= puerto %></td>
				<td><%= cola %></td>
				<td><%= modulo %></td>
				<td><%= activo %></td>
				<td><input type="checkbox"/></td>
			</tr>
		</tbody>
	</table>

	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#exampleModal" data-whatever="@mdo">Agregar Configuración</button>

	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">Mi Configuración</h4>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="ip" class="control-label">Dirección IP:</label>
							<input type="text" class="form-control" id="ip">
						</div>
						<div class="form-group">
							<label for="puerto" class="control-label">Puerto:</label>
							<input type="text" class="form-control" id="puerto">
						</div>
						<div class="form-group">
							<label for="activo">Activo:</label>
							<input type="checkbox" class="form-control" id="activo">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
					<button type="button" class="btn btn-primary">Guardar</button>
				</div>
			</div>
		</div>
	</div>
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
