<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/etablissement.css"/>
<title>Insert title here</title>
</head>
<body>
	<div align='center'>
		<h3>Formulaire Création Vehicule</h3><br><br>
		
	<form class= "form1" action="vehicule.html" method="POST">
		<label>Numéro d'Immatricule:</label><input type="text" id="numero_immatricule" name="numero_immatricule" value="${dataErrors.data.nom}" placeholder="indiquer le numéro d'imatricule du véhicule">${dataErrors.errors.nom}  <br>
		<button type="submit" name="submit">Créer</button>
	</form>
	</div>
</body>
</html>