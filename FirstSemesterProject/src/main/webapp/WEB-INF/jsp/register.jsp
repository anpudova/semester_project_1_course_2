<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:mainLayout title="Register" css="/css/login-register.css">
    <div class="parent-container">
        <div class="container">
            <h1>Registration</h1>
            <form id="form" name="container" method="post">
                <t:inputForm name="username" type="text" innerText="Username:">
                </t:inputForm>
                <t:inputForm name="email" type="text" innerText="Email:">
                </t:inputForm>
                <t:inputForm name="password" type="password" innerText="Password:">
                </t:inputForm>
                <div class="container-agreement">
                    <p class="text-agree"><input type="checkbox" required="required" name="agreement" value="agree"> I consent to the processing of personal data</p>
                </div>
                <p><input id="btn-send" class="button" name="btn-register" type="submit" value="Register"></p>
            </form>
        </div>
    </div>
</t:mainLayout>
