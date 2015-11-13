$(document).ready(function() {

	$("#menu-toggle").click(function(e) {
		e.preventDefault();
		$("#wrapper").toggleClass("toggled");
	});

	$("#items").click(function() {

		// Carga el servlet recepcion items
		$("#contenido").load("items");
	});

	$("#confi").click(function() {

		// Carga el servlet recepcion configuracion
		$("#contenido").load("configuracion");
	});

	$("#about").click(function() {

		// Carga el servlet recepcion configuracion
		// $("#contenido").load($("#about").attr("href"));
		$("#contenido").load("about.jsp");
	});
});