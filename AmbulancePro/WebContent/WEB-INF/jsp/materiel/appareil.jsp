<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="contenu">
	<div class="sous-contenu">
		<div class="ajout"> 
			<a href="ajouter_appareil.html"><h2>Ajouter Appareil</h2></a>  
		</div>
		<table>
			<tr>
				<th>ID</th>
				<th>Nommination</th>
				<th>Quantité Total</th>
				<th>Quantité Disponible</th>
				<th>Cout Supplémentaire</th>
			</tr>
			<c:forEach var="appareil" items="${data.appareils}">
				<tr>
					<td>${appareil.get_idAppareil()}</td>
					<td>${appareil.getNomAppareil()}</td>
					<td>${appareil.get_qtyTotal()}</td>
					<td>${appareil.get_qtyDispo()}</td>
					<td>${appareil.get_coutSupp()} &euro;</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>