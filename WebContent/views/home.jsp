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
    <link rel="icon" href="resources/img/kisutopi.ico">

    <title>Home</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/css/bootstrap.css" rel="stylesheet">
	<link href="resources/css/style.css" rel="stylesheet">
	<link href="resources/css/home.css" rel="stylesheet">
	
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
				<li class="active"><a href="home.jsp">Home</a></li> <!-- home tab active -->
				<li><a href="summary.jsp">Tulokset</a></li>
			</ul>
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
		</div>
		<!--/.nav-collapse -->

	</div>
	</nav> <!-- end of navbar -->

<div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img src="resources/img/hh-pasila.jpg" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Tee kysely</h1>
              <p>Tee toki kysely sovelluksellamme</p>

            </div>
          </div>
        </div>
        <div class="item">
          <img src="resources/img/bigmac.png" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Katsele kyselyiden tuloksia</h1>
              <p>Tämän sovelluksen toimittaa softala1</p>

            </div>
          </div>
        </div>
        <div class="item">
          <img src="resources/img/hh-logo.jpg" alt="Third slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Softala 1</h1>
              <p>Kaikilla on kivaa =)</p>

            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>
    
    
      <div class="container marketing">

      <!-- Three columns of text below the carousel -->
      <div class="row">
        <div class="col-lg-4">
          <img src="resources/img/vastaa.png" alt="Generic placeholder image" style="width: 140px; height: 140px;">
          <h2>Vastaa kyselyyn</h2>
          <p>Vastaa sinulle laadittuun kyselyyn.</p>
          <p><a class="btn btn-default" href="views/survey.jsp" role="button">Kyselyyn &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img src="resources/img/vastaukset.png" alt="Generic placeholder image" style="width: 140px; height: 140px;">
          <h2>Vastaukset</h2>
          <p>Tarkastele kyselyiden vastauksia.</p>
          <p><a class="btn btn-default" href="views/summary.jsp" role="button">Vastauksiin &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img src="resources/img/luo.png" alt="Generic placeholder image" style="width: 140px; height: 140px;">
          <h2>Luo lomake</h2>
          <p>Luo oma kysely.</p>
          <p><a class="btn btn-default" href="views/create.jsp" role="button">Luontiin &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
      </div><!-- /.row -->
      
      <!-- Displays a list of available surveys. -->
      <h3>Vastattavat kyselyt</h3>
      <c:forEach var="survey" items="${surveys}">
      	<a href="survey/get-survey/${survey.survey_id}"><c:out value="${survey.getSurvey_name()}"/></a>
      	<br>
      </c:forEach>
      
    <!-- Begin page content -->
    <div class="container">
      <div class="page-header">

      </div>
  
    <footer class="footer">
      <div class="container">
        <p class="text-muted">Copiright Make ja Mikot 2015</p>
      </div>
    </footer>

</div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/angular.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
