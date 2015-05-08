
<%@ page language="java" contentType="text/html; charset=charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
 <link rel="icon" href="${pageContext.request.contextPath}/resources/img/icon.ico">

<title>Vahvistus</title>

<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">

<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>


</head>

<body>

	<!-- Fixed navbar & login -->

	<nav class="navbar navbar-default navbar-fixed-top custom-navbar">
	<div class="container">
		<div class="navbar-header">			
			<a class="navbar-brand navbar-toggle collapsed" href="/kysely"><img src="${pageContext.request.contextPath}/resources/img/brandimgsmall.png"  alt="Navbar-brand kuva">Etusivu</a>
		</div> 
		<div id="navbar" class="collapse navbar-collapse">
		<!-- navbarlogo -->
		<a class="navbar-brand" href="/kysely"><img src="${pageContext.request.contextPath}/resources/img/brandimg.png" alt=""></a>
			<ul class="nav navbar-nav">
				<li><a href="/kysely">Etusivu</a></li>
			</ul>
			
			<!-- 
			<form class="navbar-form navbar-right" role="search">
				<div class="form-group">
					<input type="text" class="form-control" name="username"
						placeholder="Käyttäjätunnus">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" name="password"
						placeholder="Salasana">
				</div>
				<button type="submit" class="btn btn-primary">Kirjaudu</button>
			</form>
			 -->
		</div>

	</div>
	</nav> <!-- end of navbar -->   

	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<h1>Vastaus lähetetty</h1>
		</div>
		<div class="well">
		<h3>Kiitos!</h3>
		<p>Kiitos kyselyyn osallistumisestasi.</p>
		<br>
			<a class="btn btn-primary" role="button" href="/kysely">Etusivulle</a>
		</div>

		
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
