<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Modulo Email</title>

<!-- Custom CSS -->
<link href="css/simple-sidebar.css" rel="stylesheet">

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Icons Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<link href="css/index.css" rel="stylesheet">

</head>
<body>

	<%
		String ip = (String) request.getAttribute("ip");
		String puerto = (String) request.getAttribute("puerto");
	%>

	<!-- Header -->
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"> Email </a>
		</div>
		<div class="navbar-form navbar-left">
			<button id="menu-toggle" class="btn btn-default">Menú</button>
		</div>
	</div>
	</nav>
	<!-- /Header -->

	<div id="wrapper">

		<!-- Sidebar -->
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li class="sidebar-brand"><a><i
						class="glyphicon glyphicon-dashboard"></i> Dashboard </a></li>
				<li><a href="#" id="items"><i
						class="glyphicon glyphicon-briefcase"></i> Recepción de Item de
						Auditoría</a></li>
				<li><a href="#" id="confi"><i class="glyphicon glyphicon-cog"></i>
						Configuración de Módulos</a></li>
				<li><a href="#" id="about"><i class="glyphicon glyphicon-info-sign"></i>
						Acerca del Módulo</a></li>
			</ul>
		</div>
		<!-- /Sidebar -->

		<!-- Contenido -->
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<img id="loading" src="img/loading.gif">
						<div id="contenido"></div>
					</div>
				</div>
			</div>
		</div>
		<!-- /Contenido -->
	</div>

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap  -->
	<script src="js/bootstrap.min.js"></script>

	<script src="js/index.js"></script>


</body>

</html>
