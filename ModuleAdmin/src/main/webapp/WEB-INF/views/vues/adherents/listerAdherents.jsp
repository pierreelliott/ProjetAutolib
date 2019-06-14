<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:attribute name="title">Médiathèque de Polytech - Adhérents</jsp:attribute>
	<jsp:body>
		<div class="jumbotron text-center">
			<h1>Listing des adhérents</h1>
		</div>

		<div class="container">
			<div class="row mb-3">
				<a class="btn btn-secondary" href="<c:url value="/"/>" role="button"><i class="fas fa-chevron-left mr-2"></i>Retour accueil</a>
				<div class="ml-auto">
					<a class="btn btn-success" href="<c:url value="/adherents/nouveau"/>">Ajouter un adhérent</a>
				</div>
			</div>

			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th>Numéro</th>
						<th>Nom</th>
						<th>Prénom</th>
						<th>Ville</th>
						<th></th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${listeAdherent}" var="item">
						<tr>
							<td>${item.id}</td>
							<td>${item.nom}</td>
							<td>${item.prenom}</td>
							<td>${item.ville}</td>
							<td>
								<div class="btn-group" role="group" aria-label="Actions sur l'adhérent">
									<a class="btn btn-info" href="/reservations/nouveau/?idAdherent=${item.id}" title="Réserver une oeuvre" role="button">
										<span class="fas fa-calendar-check"></span>
									</a>
									<a class="btn btn-primary" href="<c:url value="/adherents/modifier/${item.id}"/>" title="Modifier" role="button">
										<i class="fas fa-edit mr-1"></i>
									</a>
									<a class="btn btn-danger" href="/adherents/supprimer/${item.id}" title="Supprimer" role="button">
										<i class="fas fa-ban mr-1"></i>
									</a>
								</div>

							</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</jsp:body>
</t:layout>