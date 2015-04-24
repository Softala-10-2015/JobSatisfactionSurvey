<%@ page language="java" contentType="text/html; charset=charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<!-- navbarlogo -->
		<a class="navbar-brand" href="/kysely"><img src="${pageContext.request.contextPath}/resources/img/brandimg.png" alt=""></a>
			<ul class="nav navbar-nav">
				<li class="active"><a href="/kysely">Home</a></li> <!-- home tab active -->
				<li><a href="summary">Tulokset</a></li>
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
		<div class="container">

			<div class="page-header">
				<h1> <c:out value="${survey.getSurveyName()}" default="Hyvinvointikysely"/> </h1>
			</div>
			<br>
			
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
							
							<label class="btn btn-primary"><form:radiobutton path="answerList[${i.index}].answerText"
								value="En osaa vastata"></form:radiobutton>En osaa<br>vastata
							</label>
							
							<label class="btn btn-primary"><form:radiobutton path="answerList[${i.index}].answerText"
								value="En halua vastata"></form:radiobutton>En halua<br>vastata
							</label>
									
							<form:hidden path="answerList[${i.index}].questionId"
								value="${question.getQuestionId()}" />
							
						</c:if>
					</div>
					</div>
				</c:forEach>
				<button class="btn btn-primary" type="submit" value="submit">Lähetä</button>
				<a class="btn btn-default" href="../surveys" role="button">Peruuta</a>
			</form:form>
			
			
			<%-- <div class="page-header">
				<h1>Iso kysely</h1>
			</div>
			
			<form class="well" method="post" action="email">
				<h3>Kurssin tiedot</h3>
				<!--  optionit jsp loopilla? -->
				<div class="form-group">
					<label for="course-opt">Kurssitunnus:</label> <select
						class="form-control" id="course-opt">
						<option>Valitse</option>
						<option>SWE12345</option>
						<option>BUS54321</option>
					</select>
				</div>
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1"></span> <input
						type="text" class="form-control" placeholder="Kurssin nimi"
						aria-describedby="basic-addon1">
				</div>
				<br />
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1"></span> <input
						type="text" class="form-control" placeholder="Opettajan nimi"
						aria-describedby="basic-addon1">
				</div>
				<!--  optionit jsp loopilla? -->
				<div class="form-group">
					<label for="class-year">Vuosikurssi:</label> <select
						class="form-control" id="class-year">
						<option>2012</option>
						<option>2013</option>
						<option>2014</option>
						<option>2015</option>
					</select>
				</div>
				<div class="container">

					<label for="input_message">Toteutus:</label><br>
					<div class="btn-group" data-toggle="buttons">

						<label class="btn btn-primary active"> <input type="radio"
							name="options" id="option1" autocomplete="off" checked>Kevät
						</label> <label class="btn btn-primary"> <input type="radio"
							name="options" id="option2" autocomplete="off">Syksy
						</label>
					</div>
				</div>
			</form>


			<form action="email" method="post">
				<div class="well">

					<!-- Tekstikenttä -->
					<div class="form-group">
						<div class="input-group">
							<label for="input_message">Ole hyvä ja kerro, miltä
								sinusta nyt tuntuu:</label> <input type="text" name="input_message"
								id="input_message" class="form-control" rows="5" required
								autofocus> <input type="hidden" name="receiver"
								value="softala2015@gmail.com">
						</div>
					</div>

				</div>



				<div class="well">
					<br> <label for="input_message">Ole hyvä ja kerro,
						miltä sinusta nyt tuntuu hymynaamoilla:</label><br>
					<div class="btn-group" data-toggle="buttons">

						<label class="btn btn-primary"> <input type="radio"
							name="options" id="option1" autocomplete="off"> <img
							src="img/hymy.png" alt="Smiley face">
						</label> <label class="btn btn-primary"> <input type="radio"
							name="options" id="option2" autocomplete="off"> <img
							src="img/perus.png" alt="medium">
						</label> <label class="btn btn-primary"> <input type="radio"
							name="options" id="option3" autocomplete="off"> <img
							src="img/suru.png" alt="sad face">
						</label>
					</div>
				</div>

				<div class="well">
					<br> <label for="input_message">Mitkä kaikki näistä
						feelsseistä sulla on nyt? </label><br>
					<div class="btn-group" data-toggle="buttons">
						<label class="btn btn-primary"> <input type="checkbox"
							autocomplete="off"> Feels good man
						</label> <label class="btn btn-primary"> <input type="checkbox"
							autocomplete="off"> Semi
						</label> <label class="btn btn-primary"> <input type="checkbox"
							autocomplete="off"> Harmittaa
						</label>
					</div>

				</div>

				<div class="container">
					<button class="btn btn-primary" type="submit" value="Send">Submit</button>
					<br>
					<br>
				</div>
			  </form> --%>
			<footer class="footer">
			<div class="container">
				<p class="text-muted">Copiright Make 2015</p>
			</div>
			</footer>

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
</body>
</html>
