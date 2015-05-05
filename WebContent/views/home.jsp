<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="${pageContext.request.contextPath}/resources/img/icon.ico">

    <title>Home</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/home.css" rel="stylesheet">
	
   
  </head>

  <body>

	<!-- Fixed navbar & login -->

	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			
		</div> 
<div class="navbar-brand">

<div class="container">

</div>
 </div>
		<div id="navbar" class="collapse navbar-collapse">
		<!-- navbarlogo -->
		<a class="navbar-brand" href="/kysely"><img src="${pageContext.request.contextPath}/resources/img/brandimg.png"  alt="Navbar-brand kuva"></a>
			<ul class="nav navbar-nav">
				<li class="active"><a href="/kysely">Home</a></li> <!-- home tab active -->
				<li><a href="summary">Tulokset</a></li>
			</ul>
				
			
			
		</div>

	</div>
	
	</nav> <!-- end of navbar -->    
    
 	<div class="logo"> 
   		<center><img src="${pageContext.request.contextPath}/resources/img/logo.png"/> </center>
	</div>
    
    
      <div class="container marketing" style="text-align:center">
      <div class="row">
        <div class="col-lg-3">
          <img src="${pageContext.request.contextPath}/resources/img/answer.png" alt="kuva" style="width: 140px; height: 140px;">
          <h2>Vastaa kyselyyn</h2>
          <p>Vastaa sinulle laadittuun kyselyyn.</p>
          <p><a class="btn btn-default" href="survey/surveys" role="button">Kyselyyn &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-3">
          <img src="${pageContext.request.contextPath}/resources/img/answers.png" alt="kuva" style="width: 140px; height: 140px;">
          <h2>Vastaukset</h2>
          <p>Tarkastele kyselyiden vastauksia.</p>
          <p><a class="btn btn-default" href="survey/surveylist" role="button">Vastauksiin &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-3">
          <img src="${pageContext.request.contextPath}/resources/img/create.png" alt="kuva" style="width: 140px; height: 140px;">
          <h2>Luo kysely</h2>
          <p>Luo oma kysely.</p>
          <p><a class="btn btn-default" href="survey/create" role="button">Luontiin &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-3">
          <img src="${pageContext.request.contextPath}/resources/img/editing.png" alt="kuva" style="width: 140px; height: 140px;">
          <h2>Muokkaa kyselyä</h2>
          <p>Muokkaa olemassa olevaa kyselyä</p>
          <p><a class="btn btn-default" href="survey/edit" role="button">Muokkaukseen &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
      </div><!-- /.row -->
      
      <!-- Displays a list of available surveys. 
      <h3>Vastattavat kyselyt</h3>
      <c:forEach var="survey" items="${surveys}">
      	<a href="survey/get-survey/${survey.surveyId}"><c:out value="${survey.getSurveyName()}"/></a>
      	<br>
      </c:forEach>-->
    <!-- Begin page content -->
    <div class="container">
      <div class="page-header">

      </div>
  
    <footer class="footer">
      <div class="container" >
        <p class="text-muted"  style="float: left;">Copyright Make ja Mikot 2015</p>
      </div>
    </footer>

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
