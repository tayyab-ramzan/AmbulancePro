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
	${message}
	<br>
	<form method="POST" action="demandeTransport.html">
		<label>Etablissement</label>
		<select>
			<option>Etablissement 1</option>
			<option>Etablissement 2</option>
			<option>Etablissement 3</option>
		</select> <br>
		<label>Date : </label><input type="text" id="datepicker"> <br>
		<label>Heure :</label>
		<select>
			<option>9</option>
			<option>10</option>
			<option>11</option>
			<option>12</option>
			<option>13</option>
			<option>14</option>
			<option>15</option>
			<option>16</option>
			<option>17</option>	
		</select> :
		<select>
			<option>00</option>
			<option>05</option>
			<option>10</option>
			<option>15</option>
			<option>20</option>
			<option>25</option>
			<option>30</option>
			<option>35</option>
			<option>40</option>
			<option>45</option>
			<option>50</option>
			<option>55</option>
			
		</select>
		<br>
		<label>Adresse Départ</label><input> <br>
		<label>Adresse D'arrivé</label><input> <br>
		
		<label>Nom malade:</label><input> <br>
		<label>Prénom malade:</label> <input> <br>
		<label>Adresse malade:</label> <input> <br>
		<button type="submit">Créer</button>
	</form>
</body>
</html>