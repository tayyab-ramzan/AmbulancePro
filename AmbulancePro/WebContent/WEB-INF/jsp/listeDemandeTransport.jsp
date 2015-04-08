<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<table class="listeDemande" style="width: 100%">
		<th>id Demande Transport</th>
		<th>Nom Etablissement</th>
		<th>Date et Heure</th>
			<c:forEach var="demande" items="${dataErrors.data.demandes}">
				<a href="#">
					<tr>
						<td>${demande.getIdDemandeTransport() }</td>
						<td>${demande.getEtablissment() }</td>
						<td>${demande.getDateTransport() }
					</tr>
				</a>
			</c:forEach>
			
	</table>
</body>
</html>