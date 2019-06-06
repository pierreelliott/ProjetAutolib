<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:attribute name="title">Autolib' - Liste des stations</jsp:attribute>
	<jsp:body>
		<div class="jumbotron text-center">
			<h1>Listing des stations</h1>
		</div>

		<div class="container">
			<div class="row mb-3">
				<a class="btn btn-secondary" href="<c:url value="/"/>" role="button"><i class="fas fa-chevron-left mr-2"></i>Retour accueil</a>
			</div>

			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Adresse</th>
						<th>Latitude</th>
						<th>Longitude</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${listeStation}" var="item">
						<tr>
							<td>${item.id}</td>
							<td>${item.numero} ${item.adresse} ${item.ville}, ${item.codePostal}</td>
							<td>${item.latitude}</td>
							<td>${item.longitude}</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</jsp:body>
</t:layout>