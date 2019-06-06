<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
    <jsp:attribute name="title">Médiathèque de Polytech - Connexion</jsp:attribute>
    <jsp:body>
        <form method="post" action="<c:url value="/controleLogin"/>">
        <div class="col-md-12 well well-md">
            <h1 class="text-center">Authentification</h1>
            <div class="form-horizontal">
                <div class="form-group">
                    <label class="col-md-3 control-label">Identifiant : </label>
                    <div class="col-md-6  col-md-3">
                        <input type="text" name="login" class="form-control" placeholder="Votre identifiant" required autofocus>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">Mot de passe : </label>
                    <div class="col-md-6 col-md-3">
                        <input type="password" name="pwd" class="form-control" placeholder="Votre mot de passe" required>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-6 col-md-offset-3">
                        <button type="submit" class="btn btn-default btn-primary"><span class="glyphicon glyphicon-log-in"></span> Valider</button>
                    </div>
                </div>
                <c:if test="${not empty message}">
                <div class="alert alert-danger fade in">
                    <div class="col-md-3 ">
                    <strong> Connexion !</strong> <c:out value="${message}" />
                   </div>
                </div>
                 </c:if>

            </div>
        </div>
        </form>
    </jsp:body>
</t:layout>