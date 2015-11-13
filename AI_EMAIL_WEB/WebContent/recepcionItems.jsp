

<a href="#"><strong><i class="glyphicon glyphicon-stats"></i>
		Recepción de Items de Auditoría</strong></a>
<hr>

<button id="pool" class="btn btn-success">Poll</button>

<%
	String ip = (String) request.getAttribute("ip");
	String puerto = (String) request.getAttribute("puerto");
%>
<div id="recepcion">
	<br>
	<h4>Listado de Informes de Auditoría</h4>
	<br>
	<table class="table">
		<tr>
			<th>Modulo</th>
			<th>Descripcion</th>
			<th>Fecha</th>
		</tr>
		<tbody id="tbody">

		</tbody>
	</table>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Configuración del Módulo</h4>
      </div>
      <div class="modal-body">
        Actualmente no hay ninguna configuración agregada, es necesario que la ingrese para poder continuar.
      </div>
      <div class="modal-footer">
        <button id="ir_conf" type="button" class="btn btn-primary" data-dismiss="modal">Ir a Configuración</button>
      </div>
    </div>
  </div>
</div>


<script type="text/javascript">
	$(document).ready(function() {
		var ip = "<%= ip %>";
		var puerto = <%= puerto %>;
		var flag = 0;

		if(ip == null || puerto == null){
			$('#myModal').modal('show');
		}

		$("#pool").click(function(){

			if(flag == 0){
				flag = 1;
				$("#pool").removeClass("btn-success");
				$("#pool").addClass("btn-warning");
			}
			else{
				$("#pool").removeClass("btn-warning");
				$("#pool").addClass("btn-success");
				flag = 0;
			}
			
			setInterval(function() {
				if(flag == 1){
				$.ajax({
					type : "GET",
					dataType : "json",
					url : "http://"+ip+":"+puerto+"/AI_EMAIL_WEB/rest/log/all",
					success : function(data) {

						var cantidadFilas = $('#tbody tr').length;

						if(data.length > cantidadFilas){
							$("#tbody").empty();
							$.each(data, function(i, val) {							
								$('#tbody').append("<tr><td>"+val.modulo+"</td><td>"+val.descripcion+"</td><td>"
										+val.fecha+"</td></tr>");
							});
						}
					}
				})};
		}, 2000);
	});
		

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

		$("#ir_conf").click(function(){
			
			$('#myModal').on('hidden.bs.modal', function () {
				$("#contenido").load("configuracion"); 
			});	
		});
	});
</script>
