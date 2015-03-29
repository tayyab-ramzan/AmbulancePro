<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/etablissement.css"/>
<title>Insert title here</title>
</head>
<body>
	<div align='center'>
		<h3>Formulaire Création Établissement</h3><br><br>
		
		<form class= "form1" action="etablissement.html" method="POST">
		<label>Nom Établissement:</label><input type="text" id="nom_etablissement" name="nom_etablissement" value="${dataErrors.data.nom}" placeholder="indiquer le nom de l'établissement">${dataErrors.errors.nom}  <br>
		<label>Adresse:</label><input id="adresse" name="adresse" value="${dataErrors.data.adresse}" placeholder="indiquer l'adresse de l'établissement">${dataErrors.errors.adresse} <br>
		
		<label>Email:</label><input id="email" name="email" value="${dataErrors.data.email}" placeholder="indiquer l'Email de l'établissement">${dataErrors.errors.email} <br>
		<label>Téléphone:</label> <input id="tel" name="tel" value="${dataErrors.data.tel}" placeholder="indiquer le numéro de Tel de l'établissement">${dataErrors.errors.tel} <br>
		<button type="submit" name="submit">Créer</button>
	</form>
	</div>
	
</body>
</html>