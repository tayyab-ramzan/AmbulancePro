<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ambulance Pro</title>

<link rel="shortcut icon" type="image/x-icon" href="css/images/favicon.ico" />
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<link rel="stylesheet" href="css/form.css">
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
							<c:choose>
								<c:when test="${ USER.getStrategie().get_intituleRole() == 'OPERATEUR' }">
									<li class="active"><a  href="etablissement.html">Établissement</a></li>
								</c:when>
							</c:choose>
							
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
									 		<a href="creer_demande.html"><h2>Nouvelle Demande de Transport</h2></a>  
									 	</div>
									<form class="form1" action="traiter_demande.html" method="POST">
								 		<label>Établissement</label> <input type="text" value="${data.demande.getEtablissement().getIdEtablissement()} : ${data.demande.getEtablissement().getNomEtablissement()}" disabled><br>
								 		<label>Date</label> <input type="text" value="${data.demande.getDateTransport()}" disabled><br>
								 		<label>Heure</label> <input type="text" value="${data.demande.getHeureTransport()}" disabled><br>
								 		<label>Adresse Départ</label> <input type="text" value="${data.demande.getAdresseDebut().toString()}" disabled><br>
								 		<label>Adresse Fin</label> <input type="text" value="${data.demande.getAdresseFin().toString()}" disabled><br>
								 		<label>Nom Malade</label> <input type="text" value="${data.demande.getMalade().getNomMalade()}" disabled><br>
								 		<label>Prénom Malade</label> <input type="text" value="${data.demande.getMalade().getPrenomMalade()}"disabled><br>
								 		<label>Adresse Malade</label> <input type="text" value="${data.demande.getMalade().getAdresseMalade().toString()}" disabled><br>
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