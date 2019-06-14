<%@ tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="title" %>

<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>${ title }</title>

		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
		<link rel="stylesheet" href="https://unpkg.com/leaflet@1.3.1/dist/leaflet.css" integrity="sha512-Rksm5RenBEKSKFjgI3a41vrjkw4EVPlJ3+OiI65vTjIdo9brlAacEuKOiQ5OFh7cOI1bkDwLqdLw3Zg0cRJAAQ==" crossorigin="">

		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

		<%--<link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/css/monStyle.css"/>">--%>
	</head>
	<body class="vh-100">

		<div class="d-flex flex-column h-100">

			<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
				<a class="navbar-brand" href="<c:url value="/"/>">Autolib</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggler"
						aria-controls="navbarToggler" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarToggler">
					<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
						<li class="nav-item active">
							<a class="nav-link" href="<c:url value="/"/>"><i class="fas fa-home mr-1"></i>Accueil</a>
						</li>

						<li class="nav-item ml-auto">
							<a class="nav-link" href="<c:url value="/stations/carte"/>">Stations</a>
						</li>
						<li class="nav-item ml-auto">
							<a class="nav-link" href="<c:url value="/stations/liste"/>">Liste des stations</a>
						</li>
						<li class="nav-item ml-auto">
							<a class="nav-link" href="<c:url value="/vehicules/liste"/>">Liste des véhicules</a>
						</li>

						<%--<li class="nav-item dropdown"> // TODO Joli dropdown, le bouton principal est un lien
							<div class="btn-group">
								<a role="button" href="<c:url value="/reservations/liste"/>" class="nav-link btn btn-default">Réservations</a>
								<button role="button" class="nav-link btn btn-default dropdown-toggle dropdown-toggle-split"
									data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									<span class="sr-only">Menu déroulant</span>
								</button>
								<div class="dropdown-menu" aria-labelledby="reservationsNavbarDropdown">
									<a class="dropdown-item" href="<c:url value="/reservations/nouveau"/>">Ajouter une réservation</a>
								</div>
							</div>
						</li>--%>
					</ul>

						<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
							<c:if test="${sessionScope.id == null }">
								<li class="nav-item ml-auto">
									<a class="nav-link" href="<c:url value="/login"/>">Connexion</a>
								</li>
								<li class="nav-item ml-auto">
									<a class="nav-link" href="<c:url value="/inscription"/>">Inscription</a>
								</li>
							</c:if>
							<c:if test="${sessionScope.id > 0 }">
								<li class="nav-item">
									<a class="nav-link" href="<c:url value="/logout"/>">Déconnexion</a>
								</li>
							</c:if>
						</ul>

				</div>
			</nav>


			<section class="container">
				<jsp:doBody />
			</section>

			<footer class="container-fluid text-center mt-auto">
				<div class="footer-copyright text-center py-3">© 2018 Copyright : PE Thiboud - J. Perier-Camby - Axel Bertrand - Omran Haidari
					<p>Autolib - 2018-2019 - TP de présentation</p>
				</div>
			</footer>
		</div>
	</body>
</html>