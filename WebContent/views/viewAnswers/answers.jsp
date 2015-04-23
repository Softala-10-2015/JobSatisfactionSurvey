<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="${pageContext.request.contextPath}/resources/img/kisutopi.ico">

    <title>Muokkaa kysely�</title>

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
			<ul class="nav navbar-nav">
				<li class="active"><a href="/Softala">Home</a></li> <!-- home tab active -->
				<li><a href="summary">Tulokset</a></li>
			</ul>
			<form class="navbar-form navbar-right" role="search">
				<div class="form-group">
					<input type="text" class="form-control" name="username"
						placeholder="K�ytt�j�tunnus">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" name="password"
						placeholder="Salasana">
				</div>
				<button type="submit" class="btn btn-primary">Kirjaudu</button>
			</form>
		</div>

	</div>
	</nav> <!-- end of navbar -->   
    <!-- Begin page content -->
	<div class="container">
    <div class="container">
      <div class="page-header">
      </div>

	<h1><c:out value="${survey.surveyName}" /></h1>
	<c:set var="questionid" value="${survey.answers[0].questionId}"/>
		<div>
		<!-- <span>KysymysID: <c:out value="${survey.answers[0].questionId}"></c:out></span><br /> -->
		<span>Kysymys: <c:out value="${survey.answers[0].questionText}"></c:out></span><br />
		<br>
		<c:forEach var="answer" items="${survey.answers}">
			<c:choose>
				<c:when test="${questionid == answer.questionId}">
				<span>vastaus: <c:out value="${answer.answerText}"></c:out></span>
				<!-- <span>vastausID: <c:out value="${answer.answerId}"></c:out></span><br /> -->
				</c:when>
				<c:otherwise>
				<!-- <span>KysymysID: <c:out value="${answer.questionId}"></c:out></span><br /> -->
				<br>
				<span>Kysymys: <c:out value="${answer.questionText}"></c:out></span><br />
				<br>
				<span>vastaus: <c:out value="${answer.answerText}"></c:out></span>
				<!-- <span>vastausID: <c:out value="${answer.answerId}"></c:out></span><br />  -->
				<c:set var="questionid" value="${answer.questionId}"/>
				</c:otherwise>
			</c:choose>
			<br />
		</c:forEach>
		</div>
      	<br>

    <footer class="footer">
      <div class="container">
        <p class="text-muted">Copiright Make, Jukka, Pasi 2015</p>
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