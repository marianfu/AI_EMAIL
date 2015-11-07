

<a href="#"><strong><i class="glyphicon glyphicon-stats"></i>
		Recepción de Items de Auditoría</strong></a>
<hr>

<button id="pool" class="btn btn-success">Pool</button>

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


<script type="text/javascript">
	$(document).ready(function() {
		var ip = "<%= ip %>";
		var puerto = <%= puerto %>;
		var flag = 0;

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
	});
</script>
