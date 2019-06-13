<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:attribute name="title">Autolib' - Liste des types de véhicules</jsp:attribute>
	<jsp:body>
		<div class="jumbotron text-center">
			<h1>Listing des types de véhicules</h1>
		</div>

		<div class="container">
			<div class="row mb-3">
				<a class="btn btn-secondary" href="<c:url value="/"/>" role="button"><i class="fas fa-chevron-left mr-2"></i>Retour accueil</a>
			</div>

			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th>Véhicule</th>
						<th>Catégorie</th>
						<th>Nombre de libres</th>
						<th>Nombre de réservés</th>
						<th>Nombre d'occupés</th>
					</tr>
				</thead>

				<tbody>
					<%--@elvariable id="typeVehicule" type="java.util.List<com.epul.autolib.dto.TypeVehiculeDTO>"--%>
					<c:forEach items="${typeVehicule}" var="item">
						<tr>
							<td>${item.typeVehicule}</td>
							<td>${item.categorie}</td>
							<td>${item.nbVehiculesLibres}</td>
							<td>${item.nbVehiculesReserves}</td>
							<td>${item.nbVehiculesUtilises}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</jsp:body>
</t:layout>