<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:leftRightLayout title="BreeedDetail">
    <div class="main">
        <h2>${article.name}</h2>
    </div>
    <div class="content">
        <img class="img-article" src="<c:url value="/images/project/${article.image}"/>" class="content-img" alt="cat photo">
            ${article.content}
    </div>
</t:leftRightLayout>
