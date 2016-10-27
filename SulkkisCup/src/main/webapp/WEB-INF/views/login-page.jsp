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
				<h2>Kirjaudu sisään</h2><br>
				

	
<form action="j_spring_security_check" method="post">
Käyttäjätunnus<br>
<input type='text' name='j_username' value=''><br><br>

Salasana<br>
<input type='password' name='j_password' /><br><br>

<button type="submit" class="btn">Kirjaudu</button><br><br>
</form>

	<c:if test="${not empty loginerror}">
		Käyttäjätunnus ja salasana eivät täsmää!
	</c:if>

<br><br>
Puuttuuko tunnukset? <a href="register">Rekisteröidy</a>!

</div></div></div>


</body>
</html>