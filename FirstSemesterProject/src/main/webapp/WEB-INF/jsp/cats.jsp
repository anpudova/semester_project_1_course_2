<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:leftRightLayout title="Profile">
    <div class="main">
        <h2>Your pets</h2>
    </div>
    <form method="post" action="${pageContext.request.contextPath}/welcome/profile">
        <input class="button" type="submit" value="Onward">
    </form>
    <table class="table-general">
        <tr class="table-headlines">
            <th class="th-photo">Photo</th>
            <th>Name</th>
            <th>Age</th>
            <th>Breed</th>
            <th>Character</th>
        </tr>
        <c:forEach var="cat" items="${cats}">
            <tr class="table-content">
                <td class="cat-photo">
                    <img class="cat-ph" src="${pageContext.request.contextPath}/images/users/${cat.photo}" alt="cat photo">
                </td>
                <td>${cat.name} </td>
                <td>${cat.age}</td>
                <td>${cat.breed}</td>
                <td>${cat.character}</td>
            </tr>
        </c:forEach>
    </table>
</t:leftRightLayout>
