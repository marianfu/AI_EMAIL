

<a href="#"><strong><i class="glyphicon glyphicon-stats"></i> Recepci�n de Items de Auditor�a</strong></a>
<hr>

	<%
		String ip = (String) request.getAttribute("ip");
		String puerto = (String) request.getAttribute("puerto");
	%>
<div id="recepcion">
<h4>Listado de Informes de Auditor�a</h4>
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
		
		setInterval(function() {
				$.ajax({
					type : "GET",
					dataType : "json",
					url : "http://"+ip+":"+puerto+"/AI_EMAIL_WEB/rest/log/all",
					success : function(data) {

						var cantidadFilas = $('#tbody tr').length;

						if(data.length > cantidadFilas){
						
							$.each(data, function(i, val) {							
								$('#tbody').append("<tr><td>"+val.modulo+"</td><td>"+val.descripcion+"</td><td>"
										+val.fecha+"</td></tr>");
							});
						}
					}
				});
		}, 2000);

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
