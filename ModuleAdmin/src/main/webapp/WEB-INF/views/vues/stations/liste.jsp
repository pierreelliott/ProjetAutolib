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
						<th>Coordonnées</th>
						<th>Bornes</th>
						<th>Réserver</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${listeStation}" var="item">
						<tr>
							<td>${item.id}</td>
							<td>${item.numero} ${item.adresse} ${item.ville}, ${item.codePostal}</td>
							<td>
								<a class="text-decoration-none" href="https://www.openstreetmap.org/#map=14/${item.latitude}/${item.longitude}"
									target="_blank">
									<i class="fas fa-street-view mr-1"></i>
										(${item.coordonnees})
								</a>
							</td>
							<td>
								<div class="d-flex justify-content-between">
									<div><i class="fas fa-car text-success" style="font-size: 2rem;"></i><span class="badge badge-pill badge-success position-relative" style="top:-18px;">${ item.nbVehiculesLibres }</span></div>
									<div><i class="fas fa-car text-primary" style="font-size: 2rem;"></i><span class="badge badge-pill badge-primary position-relative" style="top:-18px;">${ item.nbVehiculesReserves }</span></div>
									<div><i class="fas fa-car text-warning" style="font-size: 2rem;"></i><span class="badge badge-pill badge-warning position-relative" style="top:-18px;">${ item.nbVehiculesAbsents }</span></div>
								</div>
							</td>
							<td>
								<c:if test="${item.nbVehiculesLibres > 0}">
									<a class="btn btn-success" href="<c:url value="/reservations/nouveau"/>"
									   title="Réserver un véhicule">
										<i class="far fa-calendar-check"></i>
									</a>
								</c:if>
								<c:if test="${item.nbVehiculesLibres == 0}">
									<button class="btn btn-success disabled" title="Aucun véhicule disponible !">
										<i class="far fa-calendar-check"></i>
									</button>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<li class="page-item">
						<c:choose>
							<c:when test="${currentPage != 1}">
								<a class="page-link" href="/stations/liste?page=${currentPage - 1}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
							</c:when>
							<c:otherwise>
								<span class="page-link" aria-hidden="true">&laquo;</span>
							</c:otherwise>
						</c:choose>
					</li>

					<c:forEach begin="1" end="${nbPages}" var="i">
						<c:choose>
							<c:when test="${currentPage eq i}">
								<li class="page-item page-link">${ i }</li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link" href="/stations/liste?page=${ i }">${ i }</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<li class="page-item">
						<c:choose>
							<c:when test="${currentPage lt nbPages}">
								<a class="page-link" href="/stations/liste?page=${currentPage + 1}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
							</c:when>
							<c:otherwise>
								<span class="page-link" aria-hidden="true">&raquo;</span>
							</c:otherwise>
						</c:choose>
					</li>
				</ul>
			</nav>
		</div>
	</jsp:body>
</t:layout>