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
							<li class="active"><a href="demande_transport.html">Demande de Transport</a></li>
							<li class="active"><a style="color: #8A0808">Établissement</a></li>
						</ul>
					</nav>
				
					<section class="cols" align="center">
							<div align='center'><br>
								<h3 style="font-size: 30px">ETABLISSEMENTS</h3><br>
								<img width="200" height="200" src="css/images/icone hopital.png" alt="" />
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
									 		<a href="creer_etablissement.html"><h2>Nouvelle Etablissement</h2></a>  
									 	</div>
									<table>
										<th>ID Etablissement</th>
										<th>Nom Etablissement</th>
										<th>Adresse</th>
										<th>Email</th>
											<c:forEach var="etablissement" items="${data.etablissements}">
												<a href="#">
													<tr>
														<td>${etablissement.getIdEtablissement() }</td>
														<td>${etablissement.getNomEtablissement() }</td>
														<td>${etablissement.getAdresseEtablissement().getNum()} ${etablissement.getAdresseEtablissement().getNomRue()} ${etablissement.getAdresseEtablissement().getCodePostal()} ${etablissement.getAdresseEtablissement().getVille()} </td>
														<td>${etablissement.getMailEtablissment()}</td>
													</tr>
												</a>
											</c:forEach>
											
									</table>
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