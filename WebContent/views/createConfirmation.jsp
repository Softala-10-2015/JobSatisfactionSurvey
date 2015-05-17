
<%@ page language="java" contentType="text/html; charset=charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
     <link rel="icon" href="${pageContext.request.contextPath}/resources/img/icon.ico">

    <title>Luo kysely</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

		<!-- Fixed navbar & login -->

	<nav class="navbar navbar-default navbar-fixed-top custom-navbar">
	<div class="container">
		<div class="navbar-header">			
			<a class="navbar-brand navbar-toggle collapsed" href="${pageContext.request.contextPath}"><img src="${pageContext.request.contextPath}/resources/img/brandimgsmall.png"  alt="Navbar-brand kuva">Etusivu</a>
		</div> 
				<div id="navbar" class="collapse navbar-collapse">
		<!-- navbarlogo -->
		<a class="navbar-brand" href="${pageContext.request.contextPath}"><img src="${pageContext.request.contextPath}/resources/img/brandimg.png" alt=""></a>
			<ul class="nav navbar-nav">
				<li><a href="${pageContext.request.contextPath}">Etusivu</a></li>
			</ul>
			
		</div>

	</div>
	</nav> <!-- end of navbar -->   
    <!-- Begin page content -->
    <div class="container">
      <div class="page-header">
      </div>

	<div class="row">
		<div class="col-lg-12">
			<div class="row">
				<div class="col-lg-12">
					<h2>Kysely luotu</h2>
				</div>
			</div>
			<div class="well">
			<div class="row">
				<div class="col-lg-12">
					<p>
						Voit luoda uuden kyselyn tai palata etusivulle.
					</p>
					<p>
						<a href="${pageContext.request.contextPath}/survey/get-survey/${id}">Klikkaa tästä päästäksesi kyselyysi.</a>
						
					</p>					
					<br>
				</div>
			</div>
			
			<div class="row">
				<div class="col-lg-2">
					<a href="${pageContext.request.contextPath}/survey/create"><button class="btn btn-primary" type="button">Uusi kysely</button></a>
				</div>
				<div class="col-lg-2">
					<a href="${pageContext.request.contextPath}"><button class="btn btn-primary" type="button">Etusivulle</button></a>
				</div>
			</div>
			
		</div>
	</div>
</div>

</div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/angular.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
