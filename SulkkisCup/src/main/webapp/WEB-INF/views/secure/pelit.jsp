<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>SulkkisCup</title>
 <link href="<c:url value="/resources/styles.css" />" rel="stylesheet">
</head>
<body>

<div class="header">
			<div class="container">
				<h1 class="header-heading">Sulkapallon ranking-pisteet</h1>
			</div>
		</div>
		<div class="nav-bar">
			<div class="container">
				<ul class="nav">
					<li><a href="pistetilasto">Pistetilasto</a></li>
					<li><a href="pelit">Pelit</a></li>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="lisaaPeli">Lis‰‰ peli</a></li>
					</sec:authorize>
				</ul>
			</div>
		</div>
		<div class="content">
			<div class="container">
				<div class="main">
				
<h3>Pelit: Kaksinpelit</h3><br>
	
<table class="table table-striped">
	<thead>
		<tr>
			<th>Pelaajat</th>
			<th>P‰iv‰m‰‰r‰</th>
			<th>Voittaja</th>
			</tr>
	</thead>
	<tbody>

	<c:forEach items="${pelit}" var="pelix" varStatus="loopStatus">
	<tr>
	<form:form commandName="peli" method="post">
		<td><c:out value="${pelix.pelaaja1}"/>&emsp;vs.&emsp;<c:out value="${pelix.pelaaja2}"/></td>
		<form:hidden path="pelaaja1" value="${pelix.pelaaja1}" />
		<form:hidden path="pelaaja2" value="${pelix.pelaaja2}" />
		<td><c:out value="${pelix.pvm}"/></td><form:hidden path="pvm" value="${pelix.pvm}" />
		<td><c:out value="${pelix.voittaja}"/>
		
		<c:if test="${empty pelix.voittaja}">
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<form:select path="voittaja">
			<form:option value="" label="Voittaja" />
			<form:options items="${pelaajat}" />
			</form:select>
			<input type="submit" value="Tallenna" class="smallbtn"/></sec:authorize>
		</c:if></td>
	</form:form> 
	</tr>
	</c:forEach>
</tbody>
</table>

<br><br>
<center><a href="j_spring_security_logout" >Kirjaudu ulos</a></center>
</div></div></div>


</body>
</html>