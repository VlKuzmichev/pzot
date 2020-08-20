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
    <h3 class="text-center" style="margin-top: 20px">Вопросы</h3>
    <a type="button" class="btn btn-outline-secondary" href="questions/create">
        <span class="fa fa-plus"></span>
        Добавить
    </a>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Вопрос</th>
            <th>Группа вопросов</th>
            <th>Ответы</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${questionList}" var="question">
            <tr>
                <td>${question.name}</td>
                <td>${question.questionGroup.name}</td>
                <td><a href="answers/${question.id}"><span class='fa fa-edit'
                                                                       style="color:black"></span></a></td>
                <td><a href="questions/update?id=${question.id}"><span class='fa fa-pencil'
                                                                           style="color:black"></span></a></td>
                <td><a href="questions/delete?id=${question.id}"><span class='fa fa-remove'
                                                                           style="color:red"></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a type="button" class="btn btn-outline-secondary" href="questions/create">
        <span class="fa fa-plus"></span>
        Добавить
    </a>
</div>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>