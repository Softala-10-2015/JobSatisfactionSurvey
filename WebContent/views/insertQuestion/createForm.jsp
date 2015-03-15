<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Kysymyksen lisääminen kantaan</title>
<link rel="stylesheet" type="text/css" href="../resources/styles/common.css">
<link rel="stylesheet" type="text/css" href="../resources/styles/form.css">
</head>	

<!-- turhaa toiminallisuutta deomusta varten by pete-->
<body>
	<h1>
		Luo Kysymys
	</h1>
		<form:form modelAttribute="question" method="post">
		  	<fieldset>		
				<legend>Kysymyksen täyttö, ps kaikki paitsi text integerinä,pss survey id 1&3 toimii</legend>
				<p>
					<form:label	path="survey_id">survey_id</form:label><br/>
					<form:input path="survey_id" />		
				</p>
				<p>	
					<form:label path="question_id">question_id</form:label><br/>
					<form:input path="question_id" />
				</p>
								<p>	
					<form:label path="question_order">question_order</form:label><br/>
					<form:input path="question_order" />
				</p>
								<p>	
					<form:label path="question_text">question_text</form:label><br/>
					<form:input path="question_text" />
				</p>
								<p>	
					<form:label path="question_type">question_type</form:label><br/>
					<form:input path="question_type" />
				</p>
				<p>	
					<button type="submit">add</button>
				</p>
			</fieldset>
		</form:form>
</body>
</html>