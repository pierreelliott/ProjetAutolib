<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
    <jsp:attribute name="title">Autolib' - Page introuvable</jsp:attribute>
    <jsp:body>
        <div class="jumbotron text-center">

            <h1>Travaux en cours ! <i class="fas fa-tools"></i></h1>
        </div>
        <p>Cette page est en cours de création ou de remaniement.
            Voulez-vous <a href="<c:url value="/"/>" class="btn btn-success"><i class="fas fa-home mr-2"></i>Retourner à l'accueil</a> en attendant qu'lle soit terminée ?</p>
    </jsp:body>
</t:layout>