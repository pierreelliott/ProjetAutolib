<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
    <jsp:attribute name="title">Médiathèque de Polytech - Nouvel(le) adhérent(e)</jsp:attribute>
    <jsp:body>
        <div class="jumbotron text-center">
            <h1>Nouvel(le) adhérent(e)</h1>
        </div>

        <H1>Informations de l'adhérent(e)</H1>
        <form method="post" action="<c:url value="/adherents/insererAdherent"/>">

            <jsp:include page="formAdherent.jsp">
                <jsp:param name="showId" value="${false}"/>
                <jsp:param name="validateButtonTitle" value="Ajouter"/>
                <jsp:param name="backButtonURL" value="/adherents/liste"/>
            </jsp:include>

        </form>
    </jsp:body>
</t:layout>