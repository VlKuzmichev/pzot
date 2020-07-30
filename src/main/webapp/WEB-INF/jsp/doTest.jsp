<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="container">
    <h3 class="text-center">Ответьте на вопрос</h3>
    <form method="post" action="userTests">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>${question.name}</th>
                <th></th>
            </tr>
            </thead>
    <tbody>
    <c:forEach items="${question.answers}" var="answer">
        <tr>
            <td><input type="radio" name="answer" value="${answer.id}"> ${answer.name}</td>
        </tr>
    </c:forEach>
    </tbody>
    </table>
        <input type="hidden" name="testId" value="${test.id}">
        <button type="submit" class="btn btn-primary">
            <span class="fa fa-check"></span>
            Подтвердить
        </button>
    </form>
</div>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>