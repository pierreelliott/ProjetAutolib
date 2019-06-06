<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
    <jsp:attribute name="title">Médiathèque de Polytech - Éditer adhérent(e)</jsp:attribute>
    <jsp:body>
        <div class="jumbotron text-center">
            <h1>Modification d'un(e) adhérent(e)</h1>
        </div>

        <H1>Informations de l'adhérent(e)</H1>
        <form method="post" action="<c:url value="/adherents/modifierAdherent"/>">

            <jsp:include page="formAdherent.jsp">
                <jsp:param name="showId" value="${true}"/>
                <jsp:param name="validateButtonTitle" value="Sauvegarder les modifications"/>
                <jsp:param name="adherent" value="${unAdherent}"/>
                <jsp:param name="backButtonURL" value="/adherents/liste"/>
            </jsp:include>

        </form>
    </jsp:body>
</t:layout>