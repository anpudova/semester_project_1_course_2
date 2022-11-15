<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:leftRightLayout title="Breeds">
    <div class="main">
        <h2>Cat breeds</h2>
    </div>
    <div class="container-card">
        <c:forEach var="article" items="${articles}">
            <t:card path="/breed/detail?id=${article.id}" name="${article.name}"
                    image="${article.image}">
            </t:card>
        </c:forEach>
    </div>
</t:leftRightLayout>
