<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<c:set var="showId" value="${param.showId}"/>
<c:set var="validateButtonTitle" value="${param.validateButtonTitle}"/>
<c:set var="readonly" value="${param.readonly ? param.readonly : false}"/>
<%--@elvariable id="unOeuvrevente" type="com.epul.autolib.domains.Oeuvrevente"--%>
<c:set var="oeuvre" value="${unOeuvrevente}"/>
<c:set var="backButtonURL" value="${param.backButtonURL}"/>
<c:if test="${oeuvre.proprietaire != null}">
    <c:set var="idProprietaire" value="${oeuvre.proprietaire.id}"/>
</c:if>

<fieldset>
    <legend></legend>
    <div class="row">
        <c:if test="${(oeuvre != null) and (showId == true)}">
            <div class="col-6 form-group">
                <label for="id_oeuvre" class="control-label">ID de l'oeuvre : </label>
                <input type="text" name="id" value="${oeuvre.id}" id="id_oeuvre" class="form-control" readonly>
            </div>
        </c:if>

        <div class="col-6 form-group">
            <label for="titre_oeuvre" class="control-label">Titre de l'oeuvre : </label>
            <input type="text" name="titre" value="${oeuvre.titre}" id="titre_oeuvre" class="form-control"
                <c:if test="${readonly}">readonly</c:if>>
        </div>
    </div>

    <div class="row">
        <div class="col-6 form-group">
            <label for="etat_oeuvre" class="control-label">État de l'oeuvre : </label>
            <input type="text" name="etat" value="${oeuvre.etat}" id="etat_oeuvre" class="form-control"
                   <c:if test="${readonly}">readonly</c:if>>
        </div>

        <div class="col-6 form-group">
            <label for="prix_oeuvre" class="control-label">Prix de l'oeuvre : </label>
            <input type="number" name="prix" value="${oeuvre.prix}" id="prix_oeuvre" class="form-control"
                   <c:if test="${readonly}">readonly</c:if>>
        </div>
    </div>

    <div class="row">
        <div class="col-6 form-group">
            <label for="proprietaire" class="col-form-label">Propriétaire : </label>
            <select id="proprietaire" name="idProprietaire" class="custom-select">
                <c:if test="${showId == false}"><option value=""> </option></c:if>
                <c:forEach items="${listeProprietaire}" var="item">
                    <option value="${item.id}" ${(idProprietaire == item.id) ? 'selected' : ''}>
                            ${item.prenom} ${item.nom}
                    </option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="row mt-3">
        <div class="col form-group">
            <button type="submit" class="btn btn-primary">
                <i class="fas fa-save mr-2"></i>
                <c:out value="${validateButtonTitle}"/>
            </button>

            <a type="button" class="btn btn-outline-danger" href="${backButtonURL}">
                <span class="fas fa-ban mr-2"></span>
                Annuler
            </a>
        </div>
        <c:if test="${showId == true}">
            <div class="col-auto">
                    <a type="button" class="btn btn-info" href="/reservations/nouveau?idOeuvre=${oeuvre.id}">
                        <span class="fas fa-calendar-check mr-2"></span>
                        Réserver
                    </a>
            </div>
        </c:if>
    </div>
</fieldset>