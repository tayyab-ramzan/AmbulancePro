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
									 		<a href="ajouter_vehicule.html"><h2>Ajouter Véhicule</h2></a>  
									 	</div>
									<table>
										<tr>
											<th>Numéro d'Immatriculation</th>
										</tr>
										<c:forEach var="vehicule" items="${data.vehicules}">
											<a href="#">
												<tr>
													<td>${vehicule.getNumeroImatriculation()}</td>
												</tr>
											</a>
										</c:forEach>
									</table>
								</div>
							</div>
</body>
</html>