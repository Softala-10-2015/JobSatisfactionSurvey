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
						placeholder="K‰ytt‰j‰tunnus">
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
      <div class="page-header">
      </div>
	<h1>
		Luo kysely
	</h1>

<%--<button class="btn btn-primary" type="submit" value="Send" >Submit</button>
		<a class="btn btn-default" href="/kysely" role="button">Takaisin</a>
</form:form> --%>
<div class="well">
	<h3>Kyselyn pohja</h3>
	<div class="well">
		<div class="row">
			<div class="div-lg-12">	
				<p>
					Voit luoda kyselyn alusta l‰htien, 
					tai voit tuoda valmiin kyselyn tiedot ja kysymykset alla olevasta listasta
				</p>	
					<div class="row">
						<div class="col-lg-12">
							<!-- <div class="form-group" id="survey-list-select"> -->
							<button class="btn btn-default dropdown-toggle" id="survey-select-butn" type="button" data-toggle="dropdown">
								Valitse <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
		 						<c:forEach items="${surveys}" var="survey">
									<li><a href="getSurveys/${survey.getSurveyId()}"><c:out value="${survey.getSurveyName()}"/></a></li>
								</c:forEach>
							</ul>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-lg-12">
							<!-- <button type="button" class="btn btn-primary">Tyhjenn‰ kysely</button> -->
						</div>
					</div>
			</div>
		</div>
	</div>
	
	
	<h3>Kyselyn tiedot</h3>
	
	<div class="well">
	<form:form class="form-horizontal" id="survey-form" modelAttribute="survey" method="post" action="create">
		<fieldset>
			<div class="row">
			<div class="col-xs-3">
				<div class="form-group" style="padding-left:0; margin-left:0">
					<form:label	path="surveyName" value="${survey.getSurveyName()}">Kyselyn nimi</form:label>
					<form:input class="col-xs-1 form-control" path="surveyName" /><br/>
				</div>
			</div>
			</div>
	
		</fieldset>
	</form:form>
	</div>
	
	<div class="row">
		<div class="col-lg-12">
			
			<%-- 
			--	Aleksin koodeja, jos kysymyksi‰
			--%>	
			<!-- begin quest listing (ajax -> ajax/viewQuestions.jsp + jQuery append)-->
			<h3>Kysymykset</h3>
			<div class="col-lg-5 " id="questions-div"></div>
			<!-- end quest listing -->
				
				<!-- begin quest adding -->
				<div class="col-lg-6 col-lg-offset-1 well">
				
					<h3>Kysymysten lis‰ys</h3>
					
					<form:form class="form-horizontal" id="add-question-form" modelAttribute="question" action="" method="POST">
						<fieldset>
						<div class="row">
							<div class="col-lg-11">
								<div class="form-group" style="margin-left:0">
									<p>
										<form:label path="questionText">Kysymys teksti</form:label>
										<form:input class="form-control" id="#questionText" path="questionText"/>
									</p>
									
									<p>
										<form:label path="questionType">Kysymyksen tyyppi</form:label>
										<form:select class="form-control" id="#questionType" path="questionType">
											<form:option value="0" label="Tekstikentt‰" />
											<form:option value="1" label="Checkbox" />
										</form:select>
									</p>
									<%-- 	<form:label path="choices[0].aChoiceText">Vastausvaihtoehdot</form:label><br/>
									<form:input path="choices[0].aChoiceText" /><br><br> --%>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-3">
								<form:button class="btn btn-default" id="add-question" type="submit">Lis‰‰ kysymys</form:button>
							</div>
						</div>
						
						</fieldset>
					</form:form>
				</div>
				<!-- end quest adding -->
		</div>
	</div>
	
	<!-- begin survey send -->
	<div class="row">
		<div class="col-lg-1 col-lg-offset-10">
		<p>
			<button id="submit-button" class="btn btn-lg btn-primary" type="button" value="Send" >Tallenna</button>
		</p>
		</div>
	</div>
	<!-- end survey send -->

</div>

<!-- jQuery for adding and listing the questions -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">
	$( document ).ready(function() {
		$.get("ajax/viewQuestions", {"" : ""}, callback);
		function callback (data){
			$('#questions-div').text("");
			$('#questions-div').append(data);
		}; 
		
		
		$('#submit-button').click(function() {
			console.log("submitting form");
			$('#survey-form').submit();
		});
		
		$('#add-question-form').submit(function(){
			var data = {};
			var dataStr = "";
			
			$.each(this, function(index, value){
				var input = $(value);
				data[input.attr("name")] = input.val();
				
				if(dataStr) {
					dataStr += "&";
				}
				
				dataStr += input.attr("name") + "=" + data[input.attr("name")]
				console.log('input value: ' + input.val());
				delete data["undefined"];
			});
			
			console.log('posting ajax' + " " + JSON.stringify(data));
			
			$.ajax({
				type:"post",
				url:"ajax/addQuestion",
				data:dataStr,
				async:false,
			});
 			
			$.get("ajax/viewQuestions", {"" : ""}, callback);
			function callback (data){
				$('#questions-div').text("");
				$('#questions-div').append(data);
			};  
			
			return false;
			
		});
	});
</script>
<%-- 
--end Aleksin koodit 
--%>

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
