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
		<c:when test="${data.MAT == 'VEHICULE'}">
			<nav id ="navigation"> 
				<ul>
					<li class="active"><a style="color: #8A0808" >Véhicule</a></li>
					<li class="active"><a href="materiel.html?mat=APPAREIL" >Appareil</a></li>
				</ul>
			</nav>
		</c:when>
		<c:when test="${data.MAT == 'APPAREIL'}">
			<nav id ="navigation"> 
				<ul>
					<li class="active"><a href="materiel.html?mat=VEHICULE" >Véhicule</a></li>
					<li class="active"><a style="color: #8A0808" >Appareil</a></li>
				</ul>
			</nav>
		</c:when>	
	</c:choose>
</body>