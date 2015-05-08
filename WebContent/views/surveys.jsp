<%@ page language="java" contentType="text/html; charset=charset=UTF-8"
	pageEncoding="UTF-8"%>
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

    <title>Vastaa kyselyyn</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/home.css" rel="stylesheet">
	
  
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
				
			
			
		</div>

	</div>
	
	</nav> <!-- end of navbar -->     
    
 	
     <div class="container">
    <h1>Vastattavat kyselyt</h1>
	<div class="well">
      <!-- Displays a list of available surveys. -->
      <c:forEach var="survey" items="${surveys}">
      <table class="table table-striped">
      	<td><a href="get-survey/${survey.surveyId}"><c:out value="${survey.getSurveyName()}"/></a>
      	</td>
      	</table>
      </c:forEach>
      <div>
		<br>
		<a class="btn btn-default" href="/kysely" role="button">Takaisin</a>
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
