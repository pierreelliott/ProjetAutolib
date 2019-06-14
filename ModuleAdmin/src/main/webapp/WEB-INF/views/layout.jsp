<!DOCTYPE html>
<html>
<head>
    <%@include file="layout/header.jsp"%>
</head>
<body class="vh-100">

    <div class="d-flex flex-column h-100">

        <%@include file="layout/navigation.jsp"%>

        <section class="container">
            <c:if test="${page != null}">
                <jsp:include page="${page}.jsp"/>
            </c:if>
            <c:if test="${page == null}">
                <jsp:include page="vues/404.jsp"/>
            </c:if>
        </section>

        <%@include file="layout/footer.jsp"%>

    </div>
</body>
</html>
