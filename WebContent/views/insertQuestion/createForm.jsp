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
					<form:label	path="surveyId">surveyId</form:label><br/>
					<form:input path="surveyId" />		
				</p>
				<p>	
					<form:label path="questionId">questionId</form:label><br/>
					<form:input path="questionId" />
				</p>
								<p>	
					<form:label path="questionOrder">questionOrder</form:label><br/>
					<form:input path="questionOrder" />
				</p>
								<p>	
					<form:label path="questionText">questionText</form:label><br/>
					<form:input path="questionText" />
				</p>
								<p>	
					<form:label path="questionType">questionType</form:label><br/>
					<form:input path="questionType" />
				</p>
				<p>	
					<button type="submit">add</button>
				</p>
			</fieldset>
		</form:form>
</body>
</html>