<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
    <jsp:attribute name="title">Autolib' - Carte</jsp:attribute>
    <jsp:body>
        <div class="jumbotron text-center">
            <h1>Station n°${station.id}</h1>
        </div>

        <div class="container">
            <div class="row mb-3">
                <a class="btn btn-secondary" href="<c:url value="/"/>" role="button"><i class="fas fa-chevron-left mr-2"></i>Retour accueil</a>
            </div>

            <p>Adresse : ${station.numero} ${station.adresse} ${station.codePostal} ${station.ville} (${station.coordonnees})</p>

            <h2>Bornes</h2>
            <c:forEach items="${station.bornes}" var="item">
                <div>
                    <c:choose>
                        <c:when test="${item.vehicule != null}">
                            <c:set value="text-success" var="colorClass"/>
                            <c:if test="${item.vehicule.disponibilite != 'LIBRE'}">
                                <c:set value="text-primary" var="colorClass"/>
                            </c:if>
                            <i class="fas fa-car ${colorClass}" style="font-size: 2rem;"></i>
                            ${item.vehicule.typeVehicule.typeVehicule} (${item.vehicule.etatBatterie}% batterie)
                            <a class="btn btn-success" href="<c:url value="/reservations/nouveau"/>"
                               title="Réserver un véhicule">
                                <i class="far fa-calendar-check"></i>
                                Réserver
                            </a>
                        </c:when>
                        <c:otherwise>
                            <i class="fas fa-car text-warning" style="font-size: 2rem;"></i>
                            Aucun véhicule libre sur cette borne
                        </c:otherwise>
                    </c:choose>
                </div>
            </c:forEach>
        </div>
    </jsp:body>
</t:layout>