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
   <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker({dateFormat:'dd.mm.yy'});
  } );
  </script>
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
				
<h2>Lis‰‰ peli</h2><br>

<form:form commandName="peli" method="post">

	<form:select path="pelaaja1"><form:option value="" label="Pelaaja 1" />
		<form:options items="${pelaajat}" />
	</form:select> 
	&emsp; vastaan &emsp;
	<form:select path="pelaaja2">
		<form:option value="" label="Pelaaja 2" />
		<form:options items="${pelaajat}" />
	</form:select>
	<br><br>
	
	P‰iv‰m‰‰r‰<br>
	<form:input path="pvm" id="datepicker"/>
	<br><br>

<input type="submit" value="Lis‰‰" class="btn"/>
</form:form><br>
<c:out value="${message}"/>

<br><br>
<center><a href="j_spring_security_logout" >Kirjaudu ulos</a></center>
</div></div></div>



</body>
</html>