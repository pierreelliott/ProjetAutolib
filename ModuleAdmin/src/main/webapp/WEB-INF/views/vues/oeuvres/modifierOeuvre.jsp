<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
    <jsp:attribute name="title">Médiathèque de Polytech - Modifier une oeuvre</jsp:attribute>
    <jsp:body>
        <div class="jumbotron text-center">
            <h1>Nouvelle oeuvre</h1>
        </div>

        <H1>Informations sur l'oeuvre</H1>
        <form method="post" action="<c:url value="/oeuvres/insererOeuvre"/>">

            <jsp:include page="formOeuvre.jsp">
                <jsp:param name="showId" value="${true}"/>
                <jsp:param name="validateButtonTitle" value="${'Modifier'}"/>
                <jsp:param name="oeuvre" value="${unOeuvrevente}"/>
                <jsp:param name="backButtonURL" value="/oeuvres/liste"/>
            </jsp:include>

        </form>
    </jsp:body>
</t:layout>