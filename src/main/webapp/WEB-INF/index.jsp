<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<thead>
  <tr>
    <th> Burger Name</th>
    <th>Restaurant Name</th>
    <th>Rating</th>
  </tr>
 </thead>
 <tbody>
  <tr>
    <td>Krabby</td>
    <td>Krusty Krab</td>
    <td>4</td>
  </tr>
  <tr>
    <td>Hummus a Tune Burger</td>
    <td>Krusty</td>
    <td>5</td>
  </tr>
  <tr>
    <td>Big Mick</td>
    <td>McDowell's</td>
    <td>3</td>
  </tr>
  <tr>
    <td>Krusty Burger</td>
    <td>Krusty Burger</td>
    <td>2</td>
  </tr>
  <c:forEach var="burger" items="${burgers}">
			<tr>
				<td><c:out value="${burger.burgerName}"/></td>
				<td><c:out value="${burger.restaurantName}"/></td>
				<td><c:out value="${burger.rating}"/></td>
				<td> <a href ="/burger/edit/${burger.id}">Edit</a></td>
			</tr>
	</c:forEach>
  </tbody>
</table>

<form:form action="/burger/add" method="post" modelAttribute="burger">
 <form:label path="burgerName" >Burger Name:</form:label >
   <form:errors path="burgerName"/>
  <form:input type="text" path="burgerName"></form:input><br>
  
  <form:label path="restaurantName">Restaurant Name</form:label>
   <form:errors path="restaurantName"/>
  <form:input type="text" path="restaurantName"></form:input><br>
  
  <form:label path="rating">Rating</form:label>
   <form:errors path="rating"/>
  <form:input type="text" path="rating"></form:input><br>
  
  <form:label path="notes">Notes</form:label><br>
  <form:errors path="rating"/>
  <form:input type="text" path="notes"></form:input> <br>
  <button type="submit">submit</button>

 
  </form:form>
</body>
</html>