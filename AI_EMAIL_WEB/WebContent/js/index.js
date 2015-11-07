$("#menu-toggle").click(function(e) {
	e.preventDefault();
	$("#wrapper").toggleClass("toggled");
});

$("#menu_principal").click(function() {
	$("#myTable").empty();
});

//$('#linkVentas').click(function() {
//	cargarContenido('Ventas');
//});



$("#menu_principal").click(function() {
	$("#myTable").empty();
});

$("#linkVentas").click(function() {

	$("#contenido").load("jugadoresForm.jsp");
});

function createTable(data){

	$("#contenido").append("<table class='table' id='myTable'></table>");
	$("#myTable").empty();
	$('#myTable').append("<tr><th>Tipo Documento</th><th>Numero Documento</th><th>"
			+"Nombre</th><th>Fecha Nacimiento</th><th>Categoria</th><th>Id del Club</th></tr>");
	$.each(data, function(i, val) {
		//$(".container").append("<p>" + val.Categoria + "</p>");
		
		$('#myTable').append("<tr><td>"+val.id.TipoDoc+"</td><td>"+val.id.nroDoc+"</td><td>"
				+val.Nombre+"</td><td>"+val.Fecha_Nac+"</td><td>"+val.Categoria+"</td><td>"+val.Id_Club+"</td></tr>");
		
	});
	console.log("Number of objects: "+data.length);
}

$("#sidebar-wrapper a").click(function(e){
	
	$("#contenido").empty();
})	
