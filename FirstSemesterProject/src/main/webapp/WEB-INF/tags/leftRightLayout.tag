<%@tag description="TagLayout" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@attribute name="title" required="true" type="java.lang.String"%>

<t:mainLayout title="${title}" css="/css/main-page.css">
    <div class="parent-main">
        <div class="left">
            <ul class="menu-button">
                <li><a href="${pageContext.request.contextPath}/welcome/profile">Profile</a></li>
                <li><a href="${pageContext.request.contextPath}/welcome/main-page">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/welcome/breed">Breeds</a></li>
                <li><a href="${pageContext.request.contextPath}/welcome/care">Care</a></li>
                <li><a href="${pageContext.request.contextPath}/welcome/petsAll">Pets</a></li>
                <c:if test="${user.role == 'admin'}">
                    <li><a href="${pageContext.request.contextPath}/welcome/admin">Dashboard</a></li>
                </c:if>
            </ul>
        </div>
        <div class="parent-container">
            <div class="container">
                <jsp:doBody/>
            </div>
        </div>
        <div class="right"></div>
    </div>
</t:mainLayout>
