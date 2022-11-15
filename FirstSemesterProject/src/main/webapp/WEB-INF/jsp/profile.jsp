<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:leftRightLayout title="Profile">
    <div class="main">
        <h2>Profile</h2>
    </div>
    <div class="parent-profile">
        <div class="profile-info">
            <p>Username: ${user.username}</p>
            <p>Email: ${user.email}</p>
            <p><a href="${pageContext.request.contextPath}/welcome/profile/cats">Open the list of pets</a></p>
        </div>
        <div class="buttons">
            <h3>Profile settings</h3>
            <ul class="menu-button">
                <li><a href="${pageContext.request.contextPath}/welcome/profile/edit">Edit Profile</a></li>
                <li><a href="${pageContext.request.contextPath}/welcome/profile/cat-passport-create">Create a cat passport</a></li>
            </ul>
            <form class="form" method="post" action="${pageContext.request.contextPath}/welcome/logout">
                <input class="button" type="submit" value="Exit">
            </form>
            <form name="form" method="post" action="${pageContext.request.contextPath}/welcome/profile/delete">
                <input class="button-delete" type="submit" value="Delete account">
            </form>
        </div>
    </div>
</t:leftRightLayout>
