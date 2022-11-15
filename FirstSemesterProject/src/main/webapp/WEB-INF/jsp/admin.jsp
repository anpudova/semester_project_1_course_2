<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:leftRightLayout title="CarePage">
    <div class="main">
        <h2>Dashboard</h2>
    </div>
    <h4>All users</h4>
    <table class="table-general">
        <tr class="table-headlines" style="border-bottom: 1px solid #c2c2c2">
            <th>ID</th>
            <th>Username</th>
            <th>Email</th>
            <th>Role</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr class="table-content">
                <td>${user.id} </td>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>${user.role}</td>
            </tr>
        </c:forEach>
    </table>
    <h4>Breed editor</h4>
    <c:forEach var="breed" items="${articles}">
        <t:card path="/admin/edit-breed?id=${breed.id}" name="${breed.name}"
                image="${breed.image}">
        </t:card>
    </c:forEach>
</t:leftRightLayout>
