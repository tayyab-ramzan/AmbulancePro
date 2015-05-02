<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=0" />
	<link rel="shortcut icon" type="image/x-icon" href="css/images/favicon.ico" />
	<link rel="stylesheet" href="css/style1.css" type="text/css" media="all" />
	
	<script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
	<script src="js/jquery.flexslider-min.js" type="text/javascript"></script>
	<script src="js/functions.js" type="text/javascript"></script>
<title>AmbulancePro - Page de Connexion</title>
</head>

<header>
	<div class="foreground"></div>

	<div class="midground">
  		<div class="tuna"></div>
	</div>

	<div class="animationback"></div>
</header>

<body>
	<form action="connexion.html" method="POST">
  		<h1>Page de Connexion</h1>
  		<div class="inset">
  		<p>
    		<label for="login">Login :</label> <input type="text" name="login" id="login">
  		</p>
  		<p>
    		<label for="password">Mot de Passe :</label> <input type="password" name="password" id="password">
  		</p>
  		</div>
  		<p class="p-container">
    
    	<input type="submit" name="connexion" value="Connexion">
  		</p>
	</form>	
</body>
</html>