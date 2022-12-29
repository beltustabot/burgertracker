<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Edit Burger</title>
</head>
<body>
<h1>Edit Burger</h1><a href="/">Go back</a>
<br>
<div>
<h1>Expense</h1>
<form:form action="/burger/edit/${burger.id}" method="Post" modelAttribute="burger">
<input type="hidden" name="_method" value="PUT" />

	<div>
		<form:label path="burgerName">Burger Name: </form:label><br />
		<form:errors path="burgerName" class="text-danger"/>
		<form:input path="burgerName"/>
	</div>

	<div>
		<form:label path="restaurantName">Restaurant Name: </form:label><br />
		<form:errors path="restaurantName" class="text-danger"/>
		<form:input path="restaurantName"/>
	</div>
	
	<div>
		<form:label path="rating">Rating: </form:label><br />
		<form:errors path="rating" class="text-danger"/>
		<form:input type="rating" step="1" min="0" max="5" path="rating"/>
	</div>
	
	<div>
		<form:label path="notes">Notes: </form:label><br />
		<form:errors path="notes" class="text-danger"/>
		<form:textarea rows="3" path="notes"/>
	</div>
	
	<div>
		<input type="submit" value="Submit"/>
	</div>
	
	

</form:form>
</div>

</body>
</html>