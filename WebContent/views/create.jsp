<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="resources/img/kisutopi.ico">

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
			<ul class="nav navbar-nav">
				<li><a href="home.jsp">Home</a></li>
				<li class="active"><a href="create.jsp">Luo lomake</a></li><!-- create tab active -->
				<li><a href="#">Esikatselu</a></li> 
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
	</nav> <!-- End of navbar -->
    <!-- Begin page content -->
	<div class="container">
    <div class="container">
      <div class="page-header">
        <h1>Iso kysely</h1>
      </div>

<form class="well" method="post" action="newSurvey">
  <h3>Kurssin tiedot</h3>
  <!--  optionit jsp loopilla? --> 
  <div class="form-group">
  <label for="course-opt">Kurssitunnus:</label>
  <select class="form-control" id="course-opt">
  <option>Valitse</option>
  <option>SWE12345</option>
  <option>BUS54321</option>
 </select>
</div>
  <div class="input-group">
  <span class="input-group-addon" id="basic-addon1"></span>
  <input type="text" class="form-control createInput" placeholder="Kurssin nimi" aria-describedby="basic-addon1">
</div>
<br/>
<div class="input-group">
  <span class="input-group-addon" id="basic-addon1"></span>
  <input type="text" class="form-control createInput" placeholder="Opettajan nimi" aria-describedby="basic-addon1">
</div>
<!--  optionit jsp loopilla? --> 
  <div class="form-group">
  <label for="class-year">Vuosikurssi:</label>
  <select class="form-control" id="class-year">
  <option>2012</option>
  <option>2013</option>
  <option>2014</option>
  <option>2015</option>
 </select>
</div>
<label for="input_message">Toteutus:</label><br>
<div class="btn-group" data-toggle="buttons">

  <label class="btn btn-primary active">
    <input type="radio" name="options" id="option1" autocomplete="off" checked>Kevät 
  </label>
  <label class="btn btn-primary">
    <input type="radio" name="options" id="option2" autocomplete="off">Syksy 
  </label>
</div>
<br><br>
<button class="btn btn-primary" type="submit" value="Send" >Submit</button>
<br><br>
</form>

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
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/angular.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
