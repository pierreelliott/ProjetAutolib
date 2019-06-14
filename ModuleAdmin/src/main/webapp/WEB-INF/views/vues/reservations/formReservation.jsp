<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<c:set var="validateButtonTitle" value="${param.validateButtonTitle}"/>
<c:set var="readonly" value="${param.readonly ? param.readonly : false}"/>
<c:set var="backButtonURL" value="${param.backButtonURL}"/>
<%--@elvariable id="reservation" type="com.epul.autolib.dto.ReservationDTOOld"--%>

<%--<c:set var="idAdherent" value="${(reservation != null) ? reservation.adherent.id : idAdherent}"/>--%>
<%--<c:set var="idOeuvre" value="${(reservation != null) ? reservation.oeuvre.id : idOeuvre}"/>--%>
<%--<c:set var="dateReservation" value="${(reservation != null) ? reservation.dateReservation : dateReservation}"/>--%>

<fieldset>
    <legend></legend>
    <div class="row">
        <div class="col-6">
            <div class="row">
                <div class="form-group col">
                    <label for="idAdherent" class="col-form-label">Adhérent</label>
                    <select id="idAdherent" name="idAdherent" class="custom-select">
                        <option value=""> </option>
                        <c:forEach items="${listeAdherent}" var="item">
                            <option value="${item.id}" ${(reservation.idAdherent == item.id) ? 'selected' : ''}>${item.prenom} ${item.nom}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="row">
                <div class="col">

                </div>
            </div>

        </div>

        <div class="form-group col-6">
            <div class="row">
                <div class="form-group col">
                    <label for="idOeuvre" class="col-form-label">Oeuvre</label>
                    <select id="idOeuvre" name="idOeuvrevente" class="custom-select">
                        <option value=""> </option>
                        <c:forEach items="${listeOeuvrevente}" var="item">
                            <option value="${item.id}" ${(reservation.idOeuvrevente == item.id) ? 'selected' : ''}>${item.titre}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="row">
                <div class="col">

                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6 form-group">
            <label for="dateReservation" class="col-form-label">Date réservation</label>
            <input type="date" value="${reservation.dateReservation}" id="dateReservation" name="dateReservation"
                   class="form-control" required autofocus onfocus="this.min = new Date().toISOString().split('T')[0]">
        </div>

        <c:if test="${showId == true}">
            <div class="col-md-6 form-group">
                <label for="statut" class="col-form-label">Statut</label>
                <input type="text" value="${reservation.statut}" id="statut" name="statut"
                       class="form-control" readonly/>
            </div>
        </c:if>
    </div>

    <div class="row">
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