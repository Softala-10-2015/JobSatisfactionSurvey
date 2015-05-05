<%@ page language="java" contentType="text/html; charset=charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
     <link rel="icon" href="${pageContext.request.contextPath}/resources/img/icon.ico">

    <title>Summary</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    
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
		<div id="navbar" class="collapse navbar-collapse">
		<!-- navbarlogo -->
		<a class="navbar-brand" href="/kysely"><img src="${pageContext.request.contextPath}/resources/img/brandimg.png" alt=""></a>
			<ul class="nav navbar-nav">
				<li class="active"><a href="/kysely">Home</a></li> <!-- home tab active -->
				<li><a href="summary">Tulokset</a></li>
			</ul>
			
			
		 
		</div>

	</div>
	</nav> <!-- end of navbar -->   

    <!-- Begin page content -->
	<div class="container">
    <div class="container">
      <div class="page-header">
        <h1>Iso kysely</h1>
      </div>
      
<form class="well" method="post" action="email">
  <h3>Ootko Make? -kysely</h3>
  		<img alt="make" src="${pageContext.request.contextPath}/resources/img/make.PNG">
		<a class="btn btn-primary btn-lg btn-block homeButton" role="button" href="/kysely">Himaan</a><br>
  
</form>
<table>
<caption>MUUTA TÄMÄ OTSIKKO OTSIKOKSI</caption>
<thead>
	<tr>
		<td>ID</td>
		<td>ETUNIMI</td>
		<td>SUKUNIMI</td>
	</tr>
</thead>
<tbody>
<c:forEach items="${surveyanswers}" var="answer">
	<tr>
		<td><c:out value="${answer.questionText}"/></td>
		
		<c:if test="${not empty answer.answerText}">
  		<td><c:out value="${answer.answerText}"/></td>
  		</c:if>
  		
		<c:if test ="${not empty answer.aChoiceText}">
		<td><c:out value="${answer.aChoiceText}"/></td>
		</c:if>
	</tr>
</c:forEach>
</tbody>
</table>
<c:forEach items="${surveyanswers}" var="answer">
		<c:set var="questionText" scope="session" value="${answer.questionText}"  />
		
		<label id="questionText"><c:out value="${questionText}"></c:out></label>
		
		<br/>
	</c:forEach>
	
	<br/>
	
	<c:forEach items="${answers}" var="answer">
		<c:set var="answerText" scope="session" value="${answer.answerText}"  />
		<label id="answerText"><c:out value="${answerText}"></c:out></label>
	<br/>
	</c:forEach>

    <footer class="footer">
      <div class="container">
        <p class="text-muted">Copiright Make 2015</p>
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
