<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ambulance Pro</title>

<link rel="shortcut icon" type="image/x-icon" href="css/images/favicon.ico" />
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<link rel="stylesheet" href="css/form.css" type="text/css" media="all" />
	<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="all" />
	
	<script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
	
	<script src="js/jquery.flexslider-min.js" type="text/javascript"></script>
	<script src="js/functions.js" type="text/javascript"></script>
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

<!-- wraper -->
	<div id="wrapper">
		<!-- shell -->
		<div class="shell">
			<!-- container -->
			<div class="container">
				<c:import url="../header.jsp"></c:import>
				<c:import url="../user_information.jsp"></c:import>
				<!-- main -->
				<div class="main">
					<nav id ="navigation"> 
						<ul>
							<li class="active"><a style="color: #8A0808" >Demande de Transport</a></li>
							<li class="active"><a  href="etablissement.html">Établissement</a></li>
						</ul>
					</nav>
					<section class="cols" align="center">
							<div align='center'><br>
								<h3 style="font-size: 30px">DEMANDE DE TRANSPORTS</h3><br>
								<img width="200" height="200" src="css/images/icone ambu2.png" alt="" />
							</div>
							
							<div class="contenu">
								<div class="sous-contenu">
									<div class="ajout"> 
									 	<h2>Nouvelle Demande de Transport</h2>
									</div>
									<form class="form1" method="POST" action="creer_demande.html">
										<label>Etablissement</label>
										<select id="etablissement" name="etablissement">
											<option value="">Veuillez choisir un établissement</option>
											<c:forEach var="etablissement" items="${data.etablissements}">
												<c:choose>
													<c:when test="${data.etablissement == etablissement.getIdEtablissement()}">
														<option value="${etablissement.getIdEtablissement()}" selected>${etablissement.getNomEtablissement()}</option>
													</c:when>
													<c:otherwise>
														<option value="${etablissement.getIdEtablissement()}">${etablissement.getNomEtablissement()}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</select> ${data.errors.etablissement} <br>
										<label>Date : </label><input type="text" id="datepicker" name="date" value="${data.date }" placeholder="indiquer la date">${data.errors.date} <br>
										<label>Heure :</label>
										<select id="hour" name="hour">
											<option value="">Heure</option>
											<c:forEach var="i" begin="9" end="17">
												<c:choose>
													<c:when test="${data.hour == i}">
														<option selected><fmt:formatNumber type="number" minIntegerDigits="2" value="${i}" /></option>
													</c:when>
													<c:otherwise>
														<option><fmt:formatNumber type="number" minIntegerDigits="2" value="${i}" /></option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</select> :
										<select id="min" name="min">
											<option value="">Minute</option>
											<c:forEach var="i" begin="00" end="59" step="15">
												<c:choose>
													<c:when test="${data.min == i}">
														<option selected><fmt:formatNumber type="number" minIntegerDigits="2" value="${i}" /></option>
													</c:when>
													<c:otherwise>
														<option><fmt:formatNumber type="number" minIntegerDigits="2" value="${i}" /></option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</select><br>${data.errors.time}
										<br>
										<label>Adresse de Départ:</label> 
												<input type="text" id="num" name="num_dep" value="${data.num_dep}" placeholder="n°"> 
												<input type="text" id="nom_rue" name="nom_rue_dep" value="${data.nom_rue_dep}" placeholder="Rue/Avenue"> <br>
												<input type="number" id="code_postal" name="code_postal_dep" value="${data.code_postal_dep}" placeholder="Code Postal"> <input id="ville" name="ville_dep" value="${data.ville_dep}" placeholder="Ville"><br>${data.errors.adresse_dep}<br>
										<label>Adresse de Fin:</label>
												<input type="text" id="num" name="num_fin" value="${data.num_fin}" placeholder="n°"> 
												<input type="text" id="nom_rue" name="nom_rue_fin" value="${data.nom_rue_fin}" placeholder="Rue/Avenue"> <br>
												<input type="number" id="code_postal" name="code_postal_fin" value="${data.code_postal_fin}" placeholder="Code Postal"> <input id="ville" name="ville_fin" value="${data.ville_fin}" placeholder="Ville"><br>${data.errors.adresse_fin}<br>
										
										<label>Nom malade:</label><input id="nom_malade" name="nom_malade" value="${data.nom_malade }" placeholder="indiquer le nom du malade">${data.errors.nom_malade} <br>
										<label>Prénom malade:</label> <input id="prenom_malade" name="prenom_malade" value="${data.prenom_malade }" placeholder="indiquer le prénom du malade">${data.errors.prenom_malade} <br>
										<label>Adresse du Malade:</label> 
												<input type="text" id="num" name="num_malade" value="${data.num_malade}" placeholder="n°"> 
												<input type="text" id="nom_rue" name="nom_rue_malade" value="${data.nom_rue_malade}" placeholder="Rue/Avenue"> <br>
												<input type="number" id="code_postal" name="code_postal_malade" value="${data.code_postal_malade}" placeholder="Code Postal"> <input id="ville" name="ville_malade" value="${data.ville_malade}" placeholder="Ville"><br>${data.errors.adresse_malade}<br>
										<button type="submit" name="submit">Créer</button>
									</form>
								</div>
							</div>
					</section>		
				</div>
				<!-- end of main -->
			</div>
			<!-- end of container -->	
		</div>
		<!-- end of shell -->	
	</div>
	<!-- end of wrapper -->

</body>
</html>