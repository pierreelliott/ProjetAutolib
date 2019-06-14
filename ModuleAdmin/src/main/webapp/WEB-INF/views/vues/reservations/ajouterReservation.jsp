<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
    <jsp:attribute name="title">Autolib - Réserver</jsp:attribute>
    <jsp:body>
        <div class="jumbotron text-center">
            <h1>Nouvelle réservation</h1>
        </div>

        <c:if test="${(erreur != null)}">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong><i class="fas fa-exclamation-triangle mr-1"></i></strong> ${erreur}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>

        <H1>Informations sur la réservation</H1>
        <form method="post" action="<c:url value="/reservations/insererReservation"/>">

            <jsp:include page="formReservation.jsp">
                <jsp:param name="validateButtonTitle" value="${'Réserver'}"/>
                <jsp:param name="backButtonURL" value="/oeuvres/liste"/>
            </jsp:include>

        </form>
    </jsp:body>
</t:layout>