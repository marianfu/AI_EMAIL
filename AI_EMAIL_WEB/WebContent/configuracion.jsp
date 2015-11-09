

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
		<tbody id="tbody_conf">
			<tr>
				<%if(ip != null) {%>
					<td id="ip"><%= ip %></td>
					<td id="port"><%= puerto %></td>
					<td><%= cola %></td>
					<td><%= modulo %></td>
					<td><%= activo %></td>
					<td><input type="checkbox"/></td>
				<% }%>
			</tr>
		</tbody>
	</table>

	<button id="agregar_conf" type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#exampleModal" data-whatever="@mdo">Agregar Configuración</button>
	
	<button id="eliminar_conf" type="button" class="btn btn-danger">Eliminar Configuración</button>

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
							<input type="text" class="form-control" id="ip_dir">
						</div>
						<div class="form-group">
							<label for="puerto" class="control-label">Puerto:</label>
							<input type="text" class="form-control" id="puerto">
						</div>
						<div class="form-group">
							<label for="ip" class="control-label">Cola:</label>
							<input type="text" class="form-control" id="cola">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
					<button id="guardar_conf" type="button" class="btn btn-primary" data-dismiss="modal">Guardar</button>
				</div>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	$(document).ready(function() {
		var ip = "<%= ip %>";
		var puerto = <%= puerto %>;
		
		
		
		// ELIMINA LA CONFIGURACION ACTUAL
		$("#eliminar_conf").click(function(){
			$('#tbody_conf tr').filter(':has(:checkbox:checked)').find('#ip').each(function(){
				var ipSelected = ($(this).html());

				$.ajax({
					type : "POST",
					data : {"ip" : ipSelected },
					//dataType : "json",
					url : "eliminarConfiguracion",
					success : function(data) {

						$("#tbody_conf").empty();
					}		
				});
			});
			
		});

		// AGREGA UNA NUEVA CONFIGURACION DE EMAIL 
		$("#guardar_conf").click(function(){
			
				$.ajax({
					type : "POST",
					data : {"ip_dir" : $("#ip_dir").val(), "puerto": $("#puerto").val(), "cola": $("#cola").val()},
					//dataType : "json",
					url : "agregarConfiguracion",
					success : function(data) {
						
					}		
				});
			});
			
		});
	
</script>
