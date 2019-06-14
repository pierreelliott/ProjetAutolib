<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%--@elvariable id="station" type="com.epul.autolib.bo.Station"--%>

<t:layout>
    <jsp:attribute name="title">Autolib' - Station n°${station.id}</jsp:attribute>
    <jsp:body>
        <div class="jumbotron text-center">
            <h1>Station n°${station.id}</h1>
        </div>

        <div class="container">
            <div class="row mb-3">
                <a class="btn btn-secondary" href="<c:url value="/stations/carte"/>" role="button"><i class="fas fa-chevron-left mr-2"></i>Retour carte</a>
            </div>

            <p>Localisation : ${station.numero} ${station.adresse}, ${station.codePostal} ${station.ville}</p>
            <p>Coordonnées GPS : ${station.coordonnees}</p>

            <h2>Bornes</h2>
            <table>
                <c:forEach items="${station.bornes}" var="item">
                    <tr>
                        <c:choose>
                            <c:when test="${item.vehicule != null and item.vehicule.disponibilite eq 'LIBRE'}">
                                <td>
                                    <i class="fas fa-car text-success fa-2x"></i>
                                        ${item.vehicule.typeVehicule.typeVehicule} (${item.vehicule.etatBatterie}% batterie)
                                </td>

                                <td>
                                    <a class="btn btn-success" href="<c:url value="/reservations/nouveau/${item.vehicule.idVehicule}"/>"
                                       title="Réserver un véhicule">
                                        <i class="far fa-calendar-check"></i>
                                        Réserver
                                    </a>
                                </td>
                            </c:when>
                            <c:when test="${item.vehicule != null and item.vehicule.disponibilite ne 'LIBRE'}">
                                <td>
                                    <i class="fas fa-car text-warning fa-2x"></i>
                                    Ce véhicule a été réservé par un utilisateur.
                                </td>
                                <td></td>
                            </c:when>
                            <c:otherwise>
                                <td>
                                    <i class="fas fa-car text-danger fa-2x"></i>
                                    Aucun véhicule libre sur cette borne
                                </td>
                                <td></td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </jsp:body>
</t:layout>