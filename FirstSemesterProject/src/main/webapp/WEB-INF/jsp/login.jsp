<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:mainLayout title="LogIn" css="/css/login-register.css">
    <div class="parent-container">
        <div class="container">
            <h1>Login</h1>
            <form id="form" name="form" method="post">
                <t:inputForm name="username" type="text" innerText="Username:">
                </t:inputForm>
                <t:inputForm name="password" type="password" innerText="Password:">
                </t:inputForm>
                <p><input id="btn-send" class="button" name="btn-login" type="submit" value="Enter"></p>
                <p class="text-reg">No account?&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/register">Registration</a></p>
            </form>
        </div>
    </div>
</t:mainLayout>
