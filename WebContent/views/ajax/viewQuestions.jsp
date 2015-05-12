
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<h3>Kysymykset</h3>
<c:if test="${questions != null}">
<c:forEach items="${questions}" var="question" varStatus="status">	
	<div class="row questionListElement well" id="questionNumber${question.getQuestionOrder()}">
		
		<div class="col-lg-9">
		<h4>Kysymys <c:out value="${question.getQuestionOrder()}"/></h4> 
		<p>
			Kysymyksen teksti: <c:out value="${question.getQuestionText()}"/>
		</p>
		<p>
		Kysymyksen tyyppi:
			<c:choose>
				<c:when test="${question.getQuestionType() == 0}">
					Tekstikenttä
				</c:when>
				<c:otherwise>
					Monivalinta
				</c:otherwise>
			</c:choose>
		</p>

		<button class="btn btn-danger deleteQBut" id="deleteButton${question.getQuestionOrder()}" type="button" name="button${question.getQuestionOrder()}" value="${question.getQuestionOrder()}">
			<span class="glyphicon glyphicon-trash"></span>
		</button>
		</div>
		<div class="col-lg-1">
		
			<button class="btn btn-default moveButton" name="up" value="${question.getQuestionOrder()}" type="button"><span class="glyphicon glyphicon-arrow-up"></span></button>
		
			<button class="btn btn-default moveButton" name="down" value="${question.getQuestionOrder()}" type="button"><span class="glyphicon glyphicon-arrow-down"></span></button>
		
		</div>

	</div>
</c:forEach>
<form:hidden path="questions" value="${questions}"/>

</c:if>
<script type="text/javascript">
	$(document).ready(function() {
		
		var first = $(".questionListElement .moveButton").first();
		first.attr("disabled", "");
		var last = $(".questionListElement .moveButton").last();
		last.attr("disabled", "");
		
		$('.deleteQBut').click(function() {
			var name = $(this).attr('name');
			$(this).animate
			$.get("ajax/deleteQuestion/"+ $(this).val(), function callback(data){
				$('#questions-div').text("");
				$('#questions-div').append(data);
			});
			
			return false;
		});
		
		$('.moveButton').click(function() {
			var name = $(this).attr('name');
			var clicked = $(this);
			$.get("ajax/moveQuestion/"+ name + "/" + $(this).val(), function callback(data){			
				$('#questions-div').text("");
				$('#questions-div').append(data);				
			});				
			 return false;
		});
	});

</script>