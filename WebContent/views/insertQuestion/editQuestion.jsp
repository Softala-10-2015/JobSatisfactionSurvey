<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="${pageContext.request.contextPath}/resources/img/icon.ico">

    <title>Muokkaa kysymystä</title>

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
    <div class="container">
      <div class="page-header">
      </div>
<h1>
		Muokkaa kysymystä
	</h1>
		<form:form modelAttribute="question" class="well" method="post">
		  	<fieldset>		
				<p>
					<form:input type="hidden" path="surveyId" value="${question.surveyId}"/>		
				</p>
				<p>	
					<form:label path="questionType" id="questionType">Kysymystyyppi</form:label><br/>
					<form:select path="questionType">
					<form:option value="0" label="Tekstikenttä" />
					<form:option value="1" label="Väite" />
					</form:select>
				</p>
				<p>	
					<form:label path="questionText">Kysymysteksti *</form:label><br/>
					<form:textarea path="questionText" rows="3" />
					<p>
						<form:errors path="questionText"/>
					</p>
				<p>	
					<form:label path="questionOrder">Kysymyksen järjestys</form:label><br/>
					<form:input path="questionOrder" />
					<p>
						<!-- Lazy man's integer validation -->
						<c:set var="orderErrorMessage"><form:errors path="questionOrder"/></c:set>
   						<c:if test="${not empty orderErrorMessage}">
			     			Kysymyksen järjestyksen pitää olla numero.
   						</c:if>
					</p>
				<p>	
					<button type="submit" class="btn btn-primary">Tallenna</button>
					<a class="btn btn-default" href="${pageContext.request.contextPath}/survey/edit/${question.surveyId}">Takaisin</a>
				</p>
			</fieldset>
		</form:form>
		

		
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