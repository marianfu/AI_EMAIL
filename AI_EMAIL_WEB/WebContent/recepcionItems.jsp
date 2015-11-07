
<div id="recepcion">
<a href="#"><strong><i class="glyphicon glyphicon-stats"></i> Recepción de Items de Auditoría</strong></a>
<hr>

	<%
		String ip = (String) request.getAttribute("ip");
		String puerto = (String) request.getAttribute("puerto");
	%>

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

						console.log(data);
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
