<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
    <jsp:attribute name="title">Médiathèque de Polytech - Nouvelle oeuvre</jsp:attribute>
    <jsp:body>
        <div class="jumbotron text-center">
            <h1>Nouvelle oeuvre</h1>
        </div>

        <c:if test="${erreur != null}">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong><i class="fas fa-exclamation-triangle mr-1"></i></strong> ${erreur}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>

        <H1>Informations sur l'oeuvre</H1>
        <form method="post" action="<c:url value="/oeuvres/insererOeuvre"/>">

            <jsp:include page="formOeuvre.jsp">
                <jsp:param name="showId" value="${false}"/>
                <jsp:param name="validateButtonTitle" value="${'Ajouter'}"/>
                <jsp:param name="oeuvre" value="${unOeuvrevente}"/>
                <jsp:param name="backButtonURL" value="/oeuvres/liste"/>
            </jsp:include>

        </form>
    </jsp:body>
</t:layout>