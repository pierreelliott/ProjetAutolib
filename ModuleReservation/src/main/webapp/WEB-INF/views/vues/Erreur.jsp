<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
    <jsp:attribute name="title">Médiathèque de Polytech - Erreur</jsp:attribute>
    <jsp:body>
        <div class="col-md-12 well well-md">
            <h1>Gestion des erreurs </h1>
        </div>
        <c:if test="${MesErreurs != null }">
            <div class="alert-danger" role="alert">
                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                <c:out value="${MesErreurs}" />
            </div>
        </c:if>

        <div class="form-group">
            <div class="col-md-6 col-md-offset-3">
                <a class="btn btn-primary"  onclick="relocate_home()">
                    <i class="fas fa-home mr-1"></i>
                    Valider
                </a>
            </div>
        </div>


        <script>
            function relocate_home()
            {
                location.href = "/";
            }
        </script>
    </jsp:body>
</t:layout>