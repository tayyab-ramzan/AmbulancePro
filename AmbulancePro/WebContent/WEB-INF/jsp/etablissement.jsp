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
	<div align='center'>
		<h3>Formulaire Création Établissement</h3><br><br>
		<form action="etablissement.html" method="POST">
		<label>Nom Établissement:</label><input type="text" id="nom_etablissement" name="nom_etablissement" value="${dataErrors.data.nom}">${dataErrors.errors.nom} <br>
		<label>Adresse:</label><input id="adresse" name="adresse" value="${dataErrors.data.adresse}">${dataErrors.errors.adresse} <br>
		
		<label>Email:</label><input id="email" name="email" value="${dataErrors.data.email}">${dataErrors.errors.email} <br>
		<label>Téléphone:</label> <input id="tel" name="tel" value="${dataErrors.data.tel}">${dataErrors.errors.tel} <br>
		<button type="submit" name="submit">Créer</button>
	</form>
	</div>
	
</body>
</html>