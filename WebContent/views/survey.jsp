<%@ page language="java" contentType="text/html; charset=charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
 <link rel="icon" href="${pageContext.request.contextPath}/resources/img/icon.ico">

<title>Kysely</title>

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

			<div class="page-header">
				<h1> <c:out value="${survey.getSurveyName()}" default="Hyvinvointikysely"/> </h1>
			</div>
			<br>
			
			<spring:hasBindErrors name="answers">
					<p><strong>Kaikkiin kysymyksiin on vastattava</strong></p>
					<div><form:errors path="*"/></div>
			</spring:hasBindErrors>
			
			<form:form  class="well" modelAttribute="answers" method="post">
				<c:forEach var="question" items="${questions}" varStatus="i">
					<div class="well">
						<form:label path="answerList[${i.index}].answerText">
							Kysymys <c:out value="${question.getQuestionOrder()}" />:&nbsp;
							<c:out value="${question.getQuestionText()}" />
						</form:label>


						<!-- Autor:Erik,Petri | toistaiseksi tallentaa teksti kenttä tyyllillä myöhemmin voidaan korjata...vaatti muutoksia daoon -->

						<c:if test="${question.questionType != 1}">
							<form:textarea class="form-control" rows="5"
								path="answerList[${i.index}].answerText" />
							<form:hidden path="answerList[${i.index}].questionId"
								value="${question.getQuestionId()}" />
							<span><form:errors path="answerList[${i.index}].answerText">Vastauksen on oltava 1-3000 merkkiä</form:errors></span>
						</c:if>
						<br><br>
						<div class="btn-group" data-toggle="buttons">
						<c:if test="${question.questionType == 1}">
						
							
							
							<label class="btn btn-primary"><form:radiobutton path="answerList[${i.index}].answerText"
								value="Erittäin erimieltä"></form:radiobutton>
							<img src="${pageContext.request.contextPath}/resources/img/suru.png" alt="suru" style="position: relative;left: 4px;"> &nbsp;</label>
							
							<label class="btn btn-primary"><form:radiobutton path="answerList[${i.index}].answerText"
								value="Melko erimieltä"></form:radiobutton>
							<img src="${pageContext.request.contextPath}/resources/img/semi.png" alt="semi" style="position: relative;left: 4px;"> &nbsp;</label>
							
							<label class="btn btn-primary"><form:radiobutton path="answerList[${i.index}].answerText"
								value="Melko samaa mieltä"></form:radiobutton>
							<img src="${pageContext.request.contextPath}/resources/img/hymy.png" alt="hymy" style="position: relative;left: 4px;"> &nbsp;</label>
							
							<label class="btn btn-primary"><form:radiobutton path="answerList[${i.index}].answerText"
								value="Erittäin samaa mieltä"></form:radiobutton>
							<img src="${pageContext.request.contextPath}/resources/img/megahymy.png" alt="megahymy" style="position: relative;left: 4px;"> &nbsp;</label>
							
							<label class="btn btn-primary surveyButton"><form:radiobutton path="answerList[${i.index}].answerText"
								value="En osaa vastata"></form:radiobutton>En osaa<br>sanoa
							</label>
							
							<label class="btn btn-primary surveyButton"><form:radiobutton path="answerList[${i.index}].answerText"
								value="En halua vastata"></form:radiobutton>En halua<br>vastata
							</label>
									
							<span><form:errors path="answerList[${i.index}].answerText">Kysymykseen on vastattava</form:errors></span>
							<form:hidden path="answerList[${i.index}].questionId"
								value="${question.getQuestionId()}" />
							
						</c:if>
					</div>
					</div>
				</c:forEach>
				<button class="btn btn-primary" type="submit" value="submit">Lähetä</button>
				<a class="btn btn-default" href="../surveys" role="button">Takaisin</a>
			</form:form>
			
			
			
			

		</div>
		<!-- Bootstrap core JavaScript
    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/angular.min.js"></script>
		<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
		<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
		
		<script>
			$(document).ready(function() {
				$(':checked').parent().addClass('active');
			});
		</script>
</body>
</html>
