<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ambulance Pro</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
<script>
  $(function() {
    $( "#datepicker" ).datepicker( $.datepicker.regional[ "fr" ] );
    $( "#locale" ).change(function() {
      $( "#datepicker" ).datepicker( "option",
        $.datepicker.regional[ $( this ).val() ] );
    });
  });
  </script>

</head>
<body>
	<div align='center'>
		<h3>Formulaire Création Demande de Transport</h3><br><br>
		<form method="POST" action="demandeTransport.html">
			<label>Etablissement</label>
			<select id="etablissement" name="etablissement">
				<option value="">Veuillez choisir un établissement</option>
				<c:forEach var="etablissement" items="${dataErrors.data.etablissements}">
					<c:choose>
						<c:when test="${dataErrors.data.etablissement == etablissement.getIdEtablissement()}">
							<option value="${etablissement.getIdEtablissement()}" selected>${etablissement.getNomEtablissement()}</option>
						</c:when>
						<c:otherwise>
							<option value="${etablissement.getIdEtablissement()}">${etablissement.getNomEtablissement()}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select> ${dataErrors.errors.etablissement} <br>
			<label>Date : </label><input type="text" id="datepicker" name="date" value="${dataErrors.data.date }">${dataErrors.errors.date} <br>
			<label>Heure :</label>
			<select id="hour" name="hour">
				<option value="">Heure</option>
				<c:forEach var="i" begin="9" end="17">
					<c:choose>
						<c:when test="${dataErrors.data.hour == i}">
							<option selected>${i}</option>
						</c:when>
						<c:otherwise>
							<option>${i}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select> :
			<select id="min" name="min">
				<option value="">Minute</option>
				<c:forEach var="i" begin="0" end="59">
					<c:choose>
						<c:when test="${dataErrors.data.min == i}">
							<option selected>${i}</option>
						</c:when>
						<c:otherwise>
							<option>${i}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>${dataErrors.errors.time}
			<br>
			<label>Adresse Départ:</label><input type="text" id="adresse_deb" name="adresse_deb" value="${dataErrors.data.adresse_deb }">${dataErrors.errors.adresse_deb} <br>
			<label>Adresse D'arrivé:</label><input id="adresse_fin" name="adresse_fin" value="${dataErrors.data.adresse_fin }">${dataErrors.errors.adresse_fin} <br>
			
			<label>Nom malade:</label><input id="nom_malade" name="nom_malade" value="${dataErrors.data.nom_malade }">${dataErrors.errors.nom_malade} <br>
			<label>Prénom malade:</label> <input id="prenom_malade" name="prenom_malade" value="${dataErrors.data.prenom_malade }">${dataErrors.errors.prenom_malade} <br>
			<label>Adresse malade:</label> <input id="adresse_malade" name="adresse_malade" value="${dataErrors.data.adresse_malade }">${dataErrors.errors.adresse_malade} <br>
			<button type="submit" name="submit">Créer</button>
		</form>
	</div>
	
</body>
</html>