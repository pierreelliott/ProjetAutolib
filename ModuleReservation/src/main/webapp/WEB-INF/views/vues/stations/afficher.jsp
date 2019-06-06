<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<c:set var="showId" value="${param.showId}"/>
<c:set var="validateButtonTitle" value="${param.validateButtonTitle}"/>
<c:set var="backButtonURL" value="${param.backButtonURL}"/>

<fieldset>
    <legend></legend>
    <div class="row">
        <c:if test="${(adherent != null) and (showId == true)}">
            <div class="col-6 form-group">
                <label for="id_adherent" class="control-label">ID de l'adhérent : </label>
                <input type="text" name="id" value="${adherent.id}" id="id_adherent" class="form-control" readonly>
            </div>
        </c:if>

        <div class="col-6 form-group">
            <label for="nom_adherent" class="control-label">Nom de l'adhérent : </label>
            <input type="text" name="nom" value="${adherent.nom}" id="nom_adherent" class="form-control">
        </div>

        <div class="col-6 form-group">
            <label for="prenom_adherent" class="control-label">Prénom de l'adhérent : </label>
            <input type="text" name="prenom" value="${adherent.prenom}" id="prenom_adherent" class="form-control">
        </div>

        <div class="col-6 form-group">
            <label for="ville_adherent" class="control-label">Ville de l'adhérent : </label>
            <input type="text" name="ville" value="${adherent.ville}" id="ville_adherent" class="form-control">
        </div>

        <div class="col-12 form-group mt-3">
            <button type="submit" class="btn btn-primary">
                <i class="fas fa-save mr-2"></i>
                <c:out value="${validateButtonTitle}"/>
            </button>

            <a type="button" class="btn btn-outline-danger" href="${backButtonURL}">
                <span class="fas fa-ban mr-2"></span>
                Annuler
            </a>
        </div>
    </div>
</fieldset>