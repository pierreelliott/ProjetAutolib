<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="<c:url value="/"/>">Médiathèque de POLYTECH</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggler" aria-controls="navbarToggler" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarToggler">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
                <a class="nav-link" href="<c:url value="/"/>"><i class="fas fa-home mr-1"></i>Accueil <span class="sr-only">(page courante)</span></a>
            </li>
            <c:if test="${sessionScope.id == null }">
                <li class="nav-item ml-auto">
                    <a class="nav-link" href="<c:url value="/login"/>">Se Connecter</a>
                </li>
            </c:if>
            <c:if test="${sessionScope.id > 0 }">
                <li class="nav-item dropdown">
                    <div class="btn-group">
                        <a role="button" href="<c:url value="/adherents/liste"/>" class="nav-link btn btn-default">Adhérents</a>
                        <button role="button" class="nav-link btn btn-default dropdown-toggle dropdown-toggle-split"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="sr-only">Menu déroulant</span>
                        </button>
                        <div class="dropdown-menu" aria-labelledby="adherentsNavbarDropdown">
                            <%--<a class="dropdown-item" href="<c:url value="/adherents/liste"/>">Lister les adhérents</a>--%>
                            <a class="dropdown-item" href="<c:url value="/adherents/nouveau"/>">Ajouter un adhérent</a>
                        </div>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <div class="btn-group">
                        <a role="button" href="<c:url value="/oeuvres/liste"/>" class="nav-link btn btn-default">Oeuvres</a>
                        <button role="button" class="nav-link btn btn-default dropdown-toggle dropdown-toggle-split"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="sr-only">Menu déroulant</span>
                        </button>
                        <div class="dropdown-menu" aria-labelledby="oeuvresNavbarDropdown">
                            <a class="dropdown-item" href="<c:url value="/oeuvres/nouveau"/>">Ajouter une oeuvre</a>
                        </div>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <div class="btn-group">
                        <a role="button" href="<c:url value="/reservations/liste"/>" class="nav-link btn btn-default">Réservations</a>
                        <%--<button role="button" class="nav-link btn btn-default dropdown-toggle dropdown-toggle-split"--%>
                            <%--data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                            <%--<span class="sr-only">Menu déroulant</span>--%>
                        <%--</button>--%>
                        <%--<div class="dropdown-menu" aria-labelledby="reservationsNavbarDropdown">--%>
                            <%--<a class="dropdown-item" href="<c:url value="/reservations/nouveau"/>">Ajouter une oeuvre</a>--%>
                        <%--</div>--%>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/logout"/>">Déconnexion</a>
                </li>
            </c:if>
        </ul>
        <span class="navbar-text">
            Gestion de l'exposition 2019
        </span>
    </div>
</nav>
