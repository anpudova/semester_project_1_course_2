<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:leftRightLayout title="Care">
    <div class="main">
        <h2>Care</h2>
        <h4>About how to properly care for cats</h4>
    </div>
    <div class="container-card">
        <c:forEach var="article" items="${articles}">
            <t:card path="/care/detail?id=${article.id}" name="${article.name}"
                    image="${article.image}">
            </t:card>
        </c:forEach>
    </div>
</t:leftRightLayout>
