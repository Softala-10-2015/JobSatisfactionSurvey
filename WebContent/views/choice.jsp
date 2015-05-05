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

    <title>Lisää kysymys</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    
  </head>

<script type="text/javascript">
var i = 0;
    function insertInput(){
		i=i+1;
        var anchor, input;
        anchor = document.getElementById('anchor');
        input = document.createElement('input');
        input.name = "acList["+i+"].aChoiceText";
        input.id = "acList["+i+"].aChoiceText";
        anchor.appendChild(input);
        anchor.appendChild(document.createElement('br'));
        anchor.appendChild(document.createElement('br'));
    }
</script>


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
		<div class="container">
    <div class="container">
      <div class="page-header">
      </div>
	<h1>
		Lisää monivalintakysymys
	</h1>
		<form:form id="form" modelAttribute="questions" class="well" method="post">
		  	<fieldset>		
				<p>
				</p>
				<p>	
					<form:label path="acList[0].aChoiceText">Vastausvaihtoehdot</form:label><br/>
					<form:input path="acList[0].aChoiceText" /><br><br>
					<a id="anchor"></a>
				</p>
				
				<p>	<button type="button" onClick="insertInput()">Uusi vaihtoehto</button>
					<button type="submit">Lisää</button>
				</p>
			</fieldset>
		</form:form>
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