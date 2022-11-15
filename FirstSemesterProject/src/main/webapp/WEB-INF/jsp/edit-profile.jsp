<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <t:leftRightLayout title="EditProfile">
        <div class="main">
            <h2>Editing a profile</h2>
        </div>
        <form name="container-update" method="post" action="">
            <t:inputForm name="username" type="text" innerText="Username:" value="${user.username}">
            </t:inputForm>
            <t:inputForm name="email" type="text" innerText="Email:" value="${user.email}">
            </t:inputForm>
            <t:inputForm name="password" type="password" innerText="Password:" value="">
            </t:inputForm>
            <p><input class="button" name="btn-save" type="submit" value="Save"></p>
        </form>
        <form method="post" action="${pageContext.request.contextPath}/welcome/profile">
            <input class="button" type="submit" value="Onward">
        </form>
    </t:leftRightLayout>
