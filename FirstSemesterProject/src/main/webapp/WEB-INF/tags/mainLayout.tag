<%@tag description="TagLayout" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@attribute name="title" required="true" type="java.lang.String"%>
<%@attribute name="css" required="true" type="java.lang.String"%>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>"/>
    <title>${title}</title>
    <!--  -->
</head>
<body>
    <div class="header">
        <div class="inner-class-header">
            <span class="name-page">CatStory </span>
            <span class="description-page"> website for cat lovers</span>
        </div>
    </div>

    <jsp:doBody/>
    <div class="footer">
        <div>Created by Angela Pudova</div>
    </div>
    <script type="text/javascript" src="<c:url value="/js/filterElem.js"/>"></script>
</body>
</html>
