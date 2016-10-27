<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
					<li><a href="#"></a></li>
				</ul>
			</div>
		</div>
		<div class="content">
			<div class="container">
				<div class="main">
				<h2>Rekisteröidy pelaajaksi</h2><br>
				
<form:form commandName="pelaaja" method="post">
Käyttäjätunnus<br>
<form:input path="tunnus" />&emsp;<form:errors path="tunnus" /><c:out value="${errormessage}"/><br><br>

Nimi<br>
<form:input path="nimi" />&emsp;<form:errors path="nimi" /><br><br>

Salasana<br>
<form:password path="salasana" />&emsp;<form:errors path="salasana" /><br><br>

<input type="submit" value="Rekisteröidy" class="btn"/>
</form:form>

</div></div></div>


</body>
</html>