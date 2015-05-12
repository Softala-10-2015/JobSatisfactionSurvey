
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
    <title>Poista kysymys</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    
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
	<h1>Poista kysymys</h1>
    <div class="well">
    	<span>Kysymystyyppi: <c:out value="${question.questionType}"></c:out></span><br />
		<span>Kysymysteksti: <c:out value="${question.questionText}"></c:out></span><br />
		<span>Kysymyksen järjestys: <c:out value="${question.questionOrder}"></c:out></span><br />
		<br />
		<p>Haluatko varmasti poistaa kysymyksen</p>
		<form method="post">
			<button class="btn btn-danger">Poista</button>&nbsp;&nbsp;
			<a class="btn btn-default" href="${pageContext.request.contextPath}/survey/edit/${surveyId}">Takaisin</a>
		</form>
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
