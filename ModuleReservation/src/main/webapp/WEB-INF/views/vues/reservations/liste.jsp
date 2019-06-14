<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%--@elvariable id="vehiculesUtilises" type="java.util.List<com.epul.autolib.dto.UtiliseDTO>"--%>
<%--@elvariable id="reservations" type="java.util.List<com.epul.autolib.dto.ReservationDTO>"--%>

<t:layout>
    <jsp:attribute name="title">Autolib - Compte client</jsp:attribute>
    <jsp:body>
        <div class="jumbotron text-center">
            <h1>Compte client</h1>
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
            </div>

            <h1>Véhicules utilisés</h1>
            <table class="table table-hover table-striped">
                <c:forEach items="${vehiculesUtilises}" var="item">
                    <tr>
                        <td>${item.printVehicule()}, le ${item.printFormattedDate()}</td>
                        <td>
                            <c:if test="${item.aDeposer()}">
                                <a href="<c:url value="/stations/carte"/>" class="btn btn-success">Déposer véhicule</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>

            <h1>Réservations</h1>
            <table class="table table-hover table-striped">
                <c:forEach items="${reservations}" var="item">
                    <tr>
                        <td>${item.printVehicule()}, le ${item.printFormattedDateReservation()}</td>
                        <td>
                            <c:if test="${item.echeanceDepassee()}">
                                <span class="font-italic">Échéance dépassée</span>
                            </c:if>
                            <c:if test="${not item.echeanceDepassee()}">
                                <a href="<c:url value="/vehicules/retirer/${item.vehicule.idVehicule}"/>" class="btn btn-success">Retirer véhicule</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </jsp:body>
</t:layout>