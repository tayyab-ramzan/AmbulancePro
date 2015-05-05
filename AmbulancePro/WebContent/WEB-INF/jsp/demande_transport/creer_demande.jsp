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
							<li class="active"><a  href="materiel.html?mat=VEHICULE">Établissement</a></li>
						</ul>
					</nav>
					<section class="cols" align="center">
							<div align='center'><br>
								<h3 style="font-size: 30px">DEMANDE DE TRANSPORTS</h3><br>
								<img width="200" height="200" src="css/images/icone ambu2.png" alt="" />
								<section class="cols"  >
									<c:import url="../personnel/sous-menu.jsp"></c:import>
									 <!-- <div class="col">
									 <div class="col-cnt"> 
									  
									 <a href="ajouter_personnel.html" class="more">Entrer</a> 
									 </div> </div> 
									 <div class="col"> <div class="col-cnt">
									  <h2>Supprimer Personnel</h2>
									 <a href="SupprimerMateriel.jsp" class="more">Entrer</a> 
									 </div> </div> 
									 <div class="col"> <div class="col-cnt"> 
									 <h2>Modifier Personnel</h2> 
									 <a href="ModifierMateriel.jsp" class="more"> Entrer </a> 
									 </div> </div>
									  <div class="cl">&nbsp;</div>  -->
								
			  					</section>
							</div>
							
							<div class="contenu">
								<div class="sous-contenu">
									<div class="ajout"> 
									 	<h2>Nouvelle Demande de Transport</h2>
									</div>
									<form class="form1" method="POST" action="demandeTransport.html">
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
										<label>Date : </label><input type="text" id="datepicker" name="date" value="${dataErrors.data.date }" placeholder="indiquer la date">${dataErrors.errors.date} <br>
										<label>Heure :</label>
										<select id="hour" name="hour">
											<option value="">Heure</option>
											<c:forEach var="i" begin="9" end="17">
												<c:choose>
													<c:when test="${dataErrors.data.hour == i}">
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
													<c:when test="${dataErrors.data.min == i}">
														<option selected><fmt:formatNumber type="number" minIntegerDigits="2" value="${i}" /></option>
													</c:when>
													<c:otherwise>
														<option><fmt:formatNumber type="number" minIntegerDigits="2" value="${i}" /></option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</select>${dataErrors.errors.time}
										<br>
										<label>Adresse Départ:</label><input type="text" id="adresse_deb" name="adresse_deb" value="${dataErrors.data.adresse_deb }" placeholder="indiquer l'adresse de départ">${dataErrors.errors.adresse_deb} <br>
										<label>Adresse D'arrivé:</label><input id="adresse_fin" name="adresse_fin" value="${dataErrors.data.adresse_fin }" placeholder="indiquer l'adresse de fin">${dataErrors.errors.adresse_fin} <br>
										
										<label>Nom malade:</label><input id="nom_malade" name="nom_malade" value="${dataErrors.data.nom_malade }" placeholder="indiquer le nom du malade">${dataErrors.errors.nom_malade} <br>
										<label>Prénom malade:</label> <input id="prenom_malade" name="prenom_malade" value="${dataErrors.data.prenom_malade }" placeholder="indiquer le prénom du malade">${dataErrors.errors.prenom_malade} <br>
										<label>Adresse malade:</label> <input id="adresse_malade" name="adresse_malade" value="${dataErrors.data.adresse_malade }" placeholder="indiquer l'adresse du malade">${dataErrors.errors.adresse_malade} <br>
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