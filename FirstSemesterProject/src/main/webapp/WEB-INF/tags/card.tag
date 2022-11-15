<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="TagCard" pageEncoding="UTF-8"%>
<%@attribute name="path" required="true" type="java.lang.String"%>
<%@attribute name="name" required="true" type="java.lang.String"%>
<%@attribute name="image" required="true" type="java.lang.String"%>

<jsp:doBody/>
<div class="card">
    <div class="card-img">
        <a href="${pageContext.request.contextPath}/welcome${path}">
            <img src="<c:url value="/images/project/${image}"/>" class="card-img" alt="cat photo">
        </a>
    </div>
    <div class="card-text">
        <a href="${pageContext.request.contextPath}/welcome${path}">
            <p class="card-name">${name}</p>
        </a>
    </div>
</div>
<jsp:doBody/>
