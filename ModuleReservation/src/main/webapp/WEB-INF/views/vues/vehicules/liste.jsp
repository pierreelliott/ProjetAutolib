<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:attribute name="title">Autolib' - Liste des véhicules</jsp:attribute>
	<jsp:body>
		<div class="jumbotron text-center">
			<h1>Listing des véhicules</h1>
		</div>

		<div class="container">
			<div class="row mb-3">
				<a class="btn btn-secondary" href="<c:url value="/"/>" role="button"><i class="fas fa-chevron-left mr-2"></i>Retour accueil</a>
			</div>

			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>RFID</th>
						<th>Batterie</th>
						<th>Disponibilité</th>
						<th>Coordonnées</th>
						<th>Type de véhicule</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${listeVehicule}" var="item">
						<tr>
							<td>${item.idVehicule}</td>
							<td>${item.rfid}</td>
							<td>${item.etatBatterie}</td>
							<td>${item.disponibilite}</td>
							<td>
								<a href="https://www.openstreetmap.org/#map=14/${item.latitude}/${item.longitude}"
								   target="_blank">
									<i class="fas fa-street-view mr-1"></i>
										${item.coordonnees}
								</a>
							</td>
							<td>${item.typeVehicule.typeVehicule}</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</jsp:body>
</t:layout>