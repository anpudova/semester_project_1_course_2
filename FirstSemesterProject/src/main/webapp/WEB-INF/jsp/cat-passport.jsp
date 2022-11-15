<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:leftRightLayout title="CatPassport">
    <div class="main">
        <h2>Create a passport for a cat</h2>
    </div>
    <form name="container" method="post" enctype="multipart/form-data">
        <t:inputForm name="name" type="text" innerText="Name:">
        </t:inputForm>
        <t:inputForm name="age" type="number" innerText="Age:">
        </t:inputForm>
        <div class="inner-class-form">
            <label for="list-breed">Breed:</label>
            <select id="list-breed" name="breed" class="list">
                <option>Domestic</option>
                <option>Siamese</option>
                <option>British</option>
                <option>Munchkin</option>
                <option>Sphinx</option>
            </select>
        </div>
        <div class="inner-class-form">
            <label for="list-char">Character:</label>
            <select id="list-char" name="character" class="list">
                <option>Calm</option>
                <option>Angry</option>
                <option>Kind</option>
                <option>Active</option>
                <option>Skittish</option>
            </select>
        </div>
        <t:inputForm name="file-img" type="file" accept="image/jpeg, image/jpg, image/png" innerText="Photo:">
        </t:inputForm>
        <p><input class="button" name="btn-save-pass" type="submit" value="Save"></p>
    </form>
    <form method="post" action="${pageContext.request.contextPath}/welcome/profile">
        <input class="button" type="submit" value="Onward">
    </form>
</t:leftRightLayout>

