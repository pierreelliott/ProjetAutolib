<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
    <jsp:attribute name="title">Médiathèque de Polytech - Page introuvable</jsp:attribute>
    <jsp:body>
        <div class="jumbotron text-center">

            <h1>Erreur 404 - Êtes-vous perdu ? <i class="fas fa-map-marked-alt"></i></h1>
        </div>
        <p>La page que vous avez demandé est introuvable. Voulez-vous <a href="<c:url value="/"/>" class="btn btn-success"><i class="fas fa-home mr-2"></i>Retourner à l'accueil</a> ?</p>
    </jsp:body>
</t:layout>