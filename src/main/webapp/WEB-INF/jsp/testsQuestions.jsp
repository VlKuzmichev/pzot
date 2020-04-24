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
    <h3 class="text-center">Вопросы к тесту</h3>
    <a type="button" class="btn btn-outline-secondary" href="tests/questions/add?id=${testId}">
        <span class="fa fa-plus"></span>
        Добавить
    </a>
    <a type="button" class="btn btn-outline-secondary" href="tests">
        <span class="fa fa-backward"></span>
        Назад
    </a>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Текст вопроса</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${testWithQuestions.questions}" var="question">
            <tr>
                <td>${question.name}</td>
                <td><a href="tests/questions/delete?id=${testId}&question=${question.id}"><span class='fa fa-remove'
                                                                                                style="color:red"></span></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a type="button" class="btn btn-outline-secondary" href="tests/questions/add?id=${testId}">
        <span class="fa fa-plus"></span>
        Добавить
    </a>
    <a type="button" class="btn btn-outline-secondary" href="tests">
        <span class="fa fa-backward"></span>
        Назад
    </a>
</div>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>