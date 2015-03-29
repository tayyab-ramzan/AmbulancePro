<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/listeDemandeTransport.css">
<title>Insert title here</title>
</head>
<body>
${dataErrors.data.demandes}
	<table class="listeDemande" style="width: 100%">
		<th>id Demande Transport</th>
		<th>Nom Etablissement</th>
		<th>Date et Heure</th>
		<c:forEach var="demande" items="${dataErrors.data.demandes}">
			<tr>
			<td>${demande.getIdDemandeTransport() }</td>
			<td>${demande.getIdEtablissement() }</td>
			<td>${demande.getDateTransport() }
		</c:forEach>
			</tr>
		<tr>
			<td>Nesrine</td>
			<td>Nes</td>
			<td>Nes</td>
		</tr>
		<tr>
			<td>sellami</td>
			<td>sel</td>
			<td>Nes</td>
		</tr>
		
	</table>
</body>
</html>