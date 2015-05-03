<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${data.ROLE == 'ADMINISTRATEUR'}">
			<nav id ="navigation"> 
				<ul>
					<li class="active"><a style="color: #8A0808" >Administrateur</a></li>
					<li class="active"><a href="personnel.html?role=OPERATEUR" >Opérateur</a></li>
					<li class="active"><a href="personnel.html?role=PLANNING">Planning</a></li>
					<li class="active"><a href="personnel.html?role=FACTURATION">Facturation</a></li>
					<li class="active"><a href="personnel.html?role=CHAUFFEUR">Chauffeur</a></li>
				</ul>
			</nav>
		</c:when>
		<c:when test="${data.ROLE == 'OPERATEUR'}">
			<nav id ="navigation"> 
				<ul>
					<li class="active"><a href="personnel.html?role=ADMINISTRATEUR" >Administrateur</a></li>
					<li class="active"><a style="color: #8A0808" >Opérateur</a></li>
					<li class="active"><a href="personnel.html?role=PLANNING">Planning</a></li>
					<li class="active"><a href="personnel.html?role=FACTURATION">Facturation</a></li>
					<li class="active"><a href="personnel.html?role=CHAUFFEUR">Chauffeur</a></li>
				</ul>
			</nav>
		</c:when>
		<c:when test="${data.ROLE == 'PLANNING'}">
			<nav id ="navigation">
				<ul>
					<li class="active"><a href="personnel.html?role=ADMINISTRATEUR" >Administrateur</a></li>
					<li class="active"><a href="personnel.html?role=OPERATEUR" >Opérateur</a></li>
					<li class="active"><a style="color: #8A0808" >Planning</a></li>
					<li class="active"><a href="personnel.html?role=FACTURATION">Facturation</a></li>
					<li class="active"><a href="personnel.html?role=CHAUFFEUR">Chauffeur</a></li>
				</ul>
			</nav>
		</c:when>
		<c:when test="${data.ROLE == 'FACTURATION'}">
			<nav id ="navigation"> 
				<ul>
					<li class="active"><a href="personnel.html?role=ADMINISTRATEUR" >Administrateur</a></li>
					<li class="active"><a href="personnel.html?role=OPERATEUR" >Opérateur</a></li>
					<li class="active"><a href="personnel.html?role=PLANNING">Planning</a></li>
					<li class="active"><a style="color: #8A0808" >Facturation</a></li>
					<li class="active"><a href="personnel.html?role=CHAUFFEUR">Chauffeur</a></li>
				</ul>
			</nav>
		</c:when>
		<c:when test="${data.ROLE == 'CHAUFFEUR'}">
			<nav id ="navigation"> 
				<ul>
					<li class="active"><a href="personnel.html?role=ADMINISTRATEUR" >Administrateur</a></li>
					<li class="active"><a href="personnel.html?role=OPERATEUR" >Opérateur</a></li>
					<li class="active"><a href="personnel.html?role=PLANNING">Planning</a></li>
					<li class="active"><a href="personnel.html?role=FACTURATION">Facturation</a></li>
					<li class="active"><a style="color: #8A0808" >Chauffeur</a></li>
				</ul>
			</nav>
		</c:when>
	</c:choose>
</body>
</html>