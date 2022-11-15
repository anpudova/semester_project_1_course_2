<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:leftRightLayout title="MainPage">
    <div class="main">
        <h2>CatStory</h2>
        <h4>Here you can find useful and interesting information about cats</h4>
    </div>
    <div class="container-card">
        <c:forEach var="article" items="${articles}">
            <t:card path="/main-page/detail?id=${article.id}" name="${article.name}"
                    image="${article.image}">
            </t:card>
        </c:forEach>
    </div>
</t:leftRightLayout>
