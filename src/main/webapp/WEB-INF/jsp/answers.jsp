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
    <h3 class="text-center">Ответы к вопросу</h3>
    <a type="button" class="btn btn-outline-secondary" href="answers/create/${id}">
        <span class="fa fa-plus"></span>
        Добавить ответ
    </a>
    <a type="button" class="btn btn-outline-secondary" href="questions">
        <span class="fa fa-backward"></span>
        Назад
    </a>
    <div>Вопрос: <br/> ${answerList[0].question.name}</div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Ответ</th>
            <th>Верный/неверный</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${answerList}" var="answer">
            <tr>
                <td>${answer.name}</td>
                <td>${answer.truth ? "Верный" : "Неверный"}</td>
                <td><a href="answers/update?id=${answer.id}&q=${answer.question.id}"><span class='fa fa-pencil'
                                                                           style="color:black"></span></a></td>
                <td><a href="answers/delete?id=${answer.id}&q=${answer.question.id}"><span class='fa fa-remove'
                                                                           style="color:red"></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a type="button" class="btn btn-outline-secondary" href="answers/create/${id}">
        <span class="fa fa-plus"></span>
        Добавить ответ
    </a>
    <a type="button" class="btn btn-outline-secondary" href="questions">
        <span class="fa fa-backward"></span>
        Назад
    </a>
</div>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>