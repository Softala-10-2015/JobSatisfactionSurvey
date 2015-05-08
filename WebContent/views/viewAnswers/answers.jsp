
<%@ page language="java" contentType="text/html; charset=charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="Pasi, Jukka, Kytis, Olli">
<link rel="icon"
	href="${pageContext.request.contextPath}/resources/img/icon.ico">

<title>Vastaukset</title>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/answers.css"
	rel="stylesheet">
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
			<a class="navbar-brand navbar-toggle collapsed" href="/kysely"><img src="${pageContext.request.contextPath}/resources/img/brandimgsmall.png"  alt="Navbar-brand kuva">Etusivu</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<!-- navbarlogo -->
			<a class="navbar-brand" href="/kysely"><img
				src="${pageContext.request.contextPath}/resources/img/brandimg.png"
				alt=""></a>
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
	</nav>
	<!-- end of navbar -->
	<!-- Begin page content -->
	<div class="container">
		<div class="page-header"></div>

		<h1>
			<c:out value="${survey.surveyName}" />
		</h1>
		<c:set var="questionid" value="${survey.answers[0].questionId}" />
		<c:set var="count" value="0" scope="page" />
		<div id="viewcount" class="title"></div>
		<!-- <script language="">${"#maxvalue"}.html()</script>  -->
		<div class="well">
			<!-- <span>KysymysID: <c:out value="${survey.answers[0].questionId}"></c:out></span><br /> -->
			<div class="title">
				Kysymys:
				<c:out value="${survey.answers[0].questionText}"></c:out>
			</div>
			<c:set var="maxcount" value="0" scope="page" />
			<c:forEach var="answer" items="${survey.answers}">
				<c:choose>
					<c:when test="${questionid == answer.questionId}">
						<c:set var="count" value="${count + 1}" scope="page" />
						<c:if test="${count >= maxcount}">
							<c:set var="maxcount" value="${count}" />
						</c:if>
						<div class="answer">
							Vastaus
							<c:out value="${count}"></c:out>
							:
							<c:out value="${answer.answerText}"></c:out>
						</div>
						<!-- <span>vastausID: <c:out value="${answer.answerId}"></c:out></span><br /> -->
					</c:when>
					<c:otherwise>
						<!-- <span>KysymysID: <c:out value="${answer.questionId}"></c:out></span><br /> -->
						<div class="title">
							Kysymys:
							<c:out value="${answer.questionText}"></c:out>
						</div>
						<c:set var="count" value="1" scope="page" />
						<div class="answer">
							Vastaus
							<c:out value="${count}"></c:out>
							:
							<c:out value="${answer.answerText}"></c:out>
						</div>
						<!-- <span>vastausID: <c:out value="${answer.answerId}"></c:out></span><br />  -->
						<c:set var="questionid" value="${answer.questionId}" />
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<br />
			<a class="btn btn-default" href="../surveylist">Takaisin</a>
		</div>
		<br>
		<div id="maxcount">
			<c:out value="${maxcount}" />

		</div>
	</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/angular.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
	<script>
		$(function() {
			$("#viewcount").html("Vastaajia: " + $("#maxcount").html());
		})
	</script>
</body>
</html>
