<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
    <jsp:attribute name="title">Médiathèque de Polytech - Réservations</jsp:attribute>
    <jsp:body>
        <div class="jumbotron text-center">
            <h1>Listing des réservations</h1>
        </div>

        <c:if test="${(erreur != null)}">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong><i class="fas fa-exclamation-triangle mr-1"></i></strong> ${erreur}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>

        <div class="container">
            <div class="row mb-3">
                <a class="btn btn-secondary" href="<c:url value="/"/>" role="button"><i class="fas fa-chevron-left mr-2"></i>Retour accueil</a>
                <div class="ml-auto">
                    <a href="<c:url value="/reservations/nouveau"/>" class="btn btn-primary">Ajouter une réservation</a>
                </div>
            </div>

            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Titre</th>
                        <th>Prénom adhérent(e)</th>
                        <th>Nom adhérent(e)</th>
                        <th>Date</th>
                        <th>Statut</th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                    <%--@elvariable id="listeReservation" type="java.util.List<com.epul.autolib.domains.Reservation>"--%>
                    <c:forEach items="${listeReservation}" var="item">
                        <tr>
                            <td>${item.oeuvre.titre}</td>
                            <td>${item.adherent.prenom}</td>
                            <td>${item.adherent.nom}</td>
                            <td>${item.dateReservation}</td>
                            <td>${item.statut.toUpperCase()}</td>
                            <td>
                                <div class="btn-group" role="group" aria-label="Actions sur la réservation">
                                    <c:if test="${item.statut == 'en attente'}">
                                        <a class="btn btn-success" href="/reservations/valider/${item.id}"
                                           title="Confirmer la réservation" role="button">
                                            <span class="fas fa-check"></span>
                                        </a>
                                    </c:if>

                                    <a class="btn btn-primary" href="/reservations/modifier/${item.id}"
                                       title="Modifier" role="button">
                                        <span class="fas fa-edit"></span>
                                    </a>
                                    <a class="btn btn-danger" href="/reservations/supprimer/${item.id}"
                                       title="Supprimer" role="button">
                                        <span class="fas fa-ban"></span>
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