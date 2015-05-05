<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=0" />

	<link rel="shortcut icon" type="image/x-icon" href="css/images/favicon.ico" />
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="all" />
	
	<script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
	
	<script src="js/jquery.flexslider-min.js" type="text/javascript"></script>
	<script src="js/functions.js" type="text/javascript"></script>
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
				<!-- slider -->
				<div class="m-slider">
					<div class="slider-holder">
						<span class="slider-shadow"></span>
						<span class="slider-b"></span>
						<div class="slider flexslider">
							<ul class="slides">
								<li>
									<div class="img-holder">
										<img src="css/images/-slide-img1.png" alt="" />
									</div>
								</li>
								<li>
									<div class="img-holder">
										<img src="css/images/equipement.png" alt="" />
									</div>
								</li>
								<li>
									<div class="img-holder">
										<img src="css/images/amb pro.png" alt="" />
									</div>
								</li>
							</ul>
						</div>
					</div>
				</div>		
				<!-- end of slider -->
				<!-- main -->
				<div class="main">
					<section class="cols">
						<div class="col">
							<img src="css/images/icone ambu2.png" alt="" />
							<div class="col-cnt">
								<h2>Demande de Transport</h2>
								<a href="demande_transport.html" class="more">Entrer</a>
							</div>
						</div>
							<div class="col">
							<div class="col-cnt">
								<h2></h2>
							</div>
						</div>
						<div class="col">
							<img src="css/images/icone hopital.png" alt="" />
							<div class="col-cnt">
							    <h2>Établissement</h2>
								<a href="materiel.html?mat=VEHICULE" class="more"> Entrer </a>
							</div>
						</div>
						<div class="cl">&nbsp;</div>
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