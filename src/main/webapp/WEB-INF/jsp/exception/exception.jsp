<%@ page isErrorPage="true" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="../fragments/headTag.jsp"/>

<body>
<jsp:include page="../fragments/bodyHeader.jsp"/>

<div class="jumbotron">
    <div class="container text-center">
        <br>
        <h4>Ошибка приложения</h4>
        <h2>${exception.message}</h2>
    </div>
</div>
<!--
<c:forEach items="${exception.stackTrace}" var="stackTrace">
    ${stackTrace}
</c:forEach>
-->
<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>