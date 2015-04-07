<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Vastauksen lisääminen kantaan</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/styles/common.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/styles/form.css">
</head>	

<!-- turhaa toiminallisuutta deomusta varten, by pete -->
<body>
	<h1>
		Luo Vastaus
	</h1>

	<p><c:out value="${question.questionText}" default="-KYSYMYSTÄ EI OLE OLEMASSA, ÄLÄ VASTAA!-"/></p>

		<form:form modelAttribute="answer" method="post">
		  	<fieldset>		
				<legend>Vastauksen anto</legend>
				<p>
					<form:label	path="answerId">answerId</form:label><br/>
					<form:input path="answerId" />		
				</p>
				<p>	
					<form:label path="answerText">answerText</form:label><br/>
					<form:input path="answerText" />
				</p>
				<p>	
					<button type="submit">add</button>
				</p>
			</fieldset>
		</form:form>

</body>
</html>