<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/etablissement.css"/>
<title>AmbulancePro</title>
</head>
<body>
 	
 	<div align='center'>
		<h3>Traitement de Demande de Transport</h3><br><br>
	 	<form class="form1" action="traiterDemande.html" method="POST">
	 		<label>Établissement</label> <input type="text" value="${data.demande.getEtablissement()}" disabled><br>
	 		<label>Date</label> <input type="text" value="${data.demande.getDateTransport()}" disabled><br>
	 		<label>Heure</label> <input type="text" value="${data.demande.getHeureTransport()}" disabled><br>
	 		<label>Adresse Départ</label> <input type="text" value="${data.demande.getAdresseDebut()}" disabled><br>
	 		<label>Adresse Fin</label> <input type="text" value="${data.demande.getAdresseFin()}" disabled><br>
	 		<label>Nom Malade</label> <input type="text" value="${data.demande.getHeureTransport()}" disabled><br>
	 		<label>Prénom Malade</label> <input type="text" disabled><br>
	 		<label>Adresse Malade</label> <input type="text" disabled><br>
	 		<label>Chauffeur Principale</label>
	 		<select>
	 			<option>Chauffeur 1</option>
	 			<option>Chauufeur 2</option>
	 		</select>
	 		<br>
	 		<label>Chauffeur Secondaire</label>
	 		<select>
	 			<option>Chauffeur 1</option>
	 			<option>Chauffeur 2</option>
	 		</select>
	 		<br>
	 		<label>Véhicule</label> 
	 		<select>
	 			<option>Véhicule
	 		</select>
	 		<br>
	 		<button>Transférer</button><button type="submit">Valider</button>
	 	</form>
 	</div>
</body>
</html>