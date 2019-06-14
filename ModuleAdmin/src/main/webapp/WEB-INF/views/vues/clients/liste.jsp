<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%--@elvariable id="listeClient" type="java.util.List<com.epul.autolib.bo.Client>"--%>

<t:layout>
	<jsp:attribute name="title">Autolib' - Liste des clients</jsp:attribute>
	<jsp:body>
		<div class="jumbotron text-center">
			<h1>Listing des clients</h1>
		</div>

		<div class="container">
			<div class="row mb-3">
				<a class="btn btn-secondary" href="<c:url value="/"/>" role="button"><i class="fas fa-chevron-left mr-2"></i>Retour accueil</a>
			</div>

			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nom</th>
						<th>Prénom</th>
						<th>Date de naissance</th>
						<th>login</th>
						<th>Réservations</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${listeClient}" var="item">
						<tr>
							<td>${item.idClient}</td>
							<td>${item.nom}</td>
							<td>${item.prenom}</td>
							<td>${item.dateNaissance}</td>
							<td>${item.login}</td>
							<td>
								<a class="btn btn-info" href="<c:url value="/reservations/liste/${item.idClient}"/>">
									<i class="fas fa-eye mr-1"></i>
										Voir réservations
								</a>
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
								<a class="page-link" href="<c:url value="/stations/liste?page=${currentPage - 1}"/>" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
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
								<li class="page-item"><a class="page-link" href="<c:url value="/stations/liste?page=${ i }"/>">${ i }</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<li class="page-item">
						<c:choose>
							<c:when test="${currentPage lt nbPages}">
								<a class="page-link" href="<c:url value="/stations/liste?page=${currentPage + 1}"/>" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
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