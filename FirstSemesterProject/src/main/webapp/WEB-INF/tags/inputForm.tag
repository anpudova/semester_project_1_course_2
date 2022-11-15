<%@tag description="TagLayout" pageEncoding="UTF-8"%>
<%@attribute name="name" required="true" type="java.lang.String"%>
<%@attribute name="type" required="true" type="java.lang.String"%>
<%@attribute name="innerText" required="true" type="java.lang.String"%>
<%@attribute name="value" type="java.lang.String"%>
<%@attribute name="accept" type="java.lang.String" %>

<jsp:doBody/>
<div class="inner-class-form">
    <label for="${name}">${innerText}</label>
    <input id="${name}" name="${name}" type="${type}" value="${value}" accept="${accept}">
</div>
<jsp:doBody/>
