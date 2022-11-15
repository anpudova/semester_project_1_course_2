<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:leftRightLayout title="PetsPage">
    <div class="main">
        <h2>All pet's</h2>
    </div>
    <h4>Filter by</h4>
    <div class="inner-class-filter">
        <label for="input-breed">Breed:</label>
        <select id="input-breed" class="list" onchange="funFilter()">
            <option>All</option>
            <option>Domestic</option>
            <option>Siamese</option>
            <option>British</option>
            <option>Sphinx</option>
        </select>
    </div>
    <div class="inner-class-filter">
        <label for="input-character">Character:</label>
        <select id="input-character" class="list" onchange="funFilter()">
            <option>All</option>
            <option>Calm</option>
            <option>Angry</option>
            <option>Kind</option>
            <option>Active</option>
            <option>Skittish</option>
        </select>
    </div>
    <table class="table-general" id="table-general">
        <tr class="table-headlines">
            <th class="th-photo">Photo</th>
            <th>Name</th>
            <th>Age</th>
            <th>Breed</th>
            <th>Character</th>
            <th>Owner</th>
        </tr>
        <c:forEach var="cat" items="${allcats}">
            <tr class="table-content">
                <td class="cat-photo">
                    <img class="cat-ph" src="${pageContext.request.contextPath}/images/users/${cat.photo}" alt="cat photo">
                </td>
                <td>${cat.name}</td>
                <td>${cat.age}</td>
                <td>${cat.breed}</td>
                <td>${cat.character}</td>
                <td>${cat.owner_username}</td>
            </tr>
        </c:forEach>
    </table>
</t:leftRightLayout>
