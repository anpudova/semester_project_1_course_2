<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:leftRightLayout title="EditBreed">
    <div class="main">
        <h2>Edit breed ${article.name}</h2>
    </div>
    <form name="container-update" method="post" action="">
        <t:inputForm name="name" type="text" innerText="Name:" value="${article.name}">
        </t:inputForm>
        <div class="inner-class-content-edit">
            <label for="content">Content:</label>
            <textarea id="content" name="content" type="text" wrap="soft">${article.content}</textarea>
        </div>
        <p><input class="button" name="btn-save" type="submit" value="Save"></p>
    </form>
    <form method="post" action="${pageContext.request.contextPath}/welcome/admin">
        <input class="button" type="submit" value="Onward">
    </form>
</t:leftRightLayout>
