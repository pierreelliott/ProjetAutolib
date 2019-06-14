<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
    <jsp:attribute name="title">Médiathèque de Polytech - Oeuvres</jsp:attribute>
    <jsp:body>
        <div class="jumbotron text-center">
            <h1>Listing des oeuvres</h1>
        </div>

        <div class="container">
            <div class="row mb-3">
                <a class="btn btn-secondary" href="<c:url value="/"/>" role="button"><i class="fas fa-chevron-left mr-2"></i>Retour accueil</a>
                <div class="ml-auto">
                    <a href="<c:url value="/oeuvres/nouveau"/>" class="btn btn-success">Ajouter une oeuvre</a>
                </div>
            </div>

            <table class="table table-hover table-striped">
                <thead>
                    <tr>
                        <th>Numéro</th>
                        <th>Titre</th>
                        <th>Prénom propriétaire</th>
                        <th>Nom propriétaire</th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${listeOeuvrevente}" var="item">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.titre}</td>
                            <td>${item.proprietaire.prenom}</td>
                            <td>${item.proprietaire.nom}</td>
                            <td>
                                <div class="btn-group" role="group" aria-label="Actions sur l'oeuvre">
                                    <a class="btn btn-info" href="/reservations/nouveau/?idOeuvre=${item.id}" title="Réserver pour un adhérent" role="button">
                                        <span class="fas fa-calendar-check"></span>
                                    </a>
                                    <a class="btn btn-primary" href="/oeuvres/modifier/${item.id}" title="Modifier" role="button">
                                        <span class="fas fa-edit"></span>
                                    </a>
                                    <a class="btn btn-danger" href="/oeuvres/supprimer/${item.id}" title="Supprimer" role="button">
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