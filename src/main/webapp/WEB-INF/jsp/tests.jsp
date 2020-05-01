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
    <h3 class="text-center">Тесты</h3>
    <a type="button" class="btn btn-outline-secondary" href="tests/create">
        <span class="fa fa-plus"></span>
        Добавить
    </a>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Наименование теста</th>
            <th>Результаты</th>
            <th>Начало</th>
            <th>Завершение</th>
            <th>Вопросы</th>
            <th>Студенты</th>
            <th>Статус</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${testList}" var="test">
            <tr>
                <td>${test.name}</td>
                <td><a href="tests/results?id=${test.id}">Результаты</a></td>
                <td>${test.startDate.toLocalDate()}</td>
                <td>${test.endDate.toLocalDate()}</td>
                <td><a href="tests/questions?id=${test.id}"><span class='fa fa-question-circle'
                                                              style="color:black"></span></a></td>
                <td><a href="tests/users?id=${test.id}"><span class='fa fa-address-book'
                                                               style="color:black"></span></a></td>
                <td><a href="tests/status?id=${test.id}">
                    <span class='fa fa-toggle-${test.status == "[INACTIVE]" ? "off" : "on"}'
                          style="color:${test.status == "[INACTIVE]" ? "black" : "green"}"></span></a></td>
                <td><a href="tests/update?id=${test.id}"><span class='fa fa-pencil'
                                                               style="color:black"></span></a></td>
                <td><a href="tests/delete?id=${test.id}"
                       onclick="return confirm('Вы действительно хотите удалить тест?')"><span class='fa fa-remove'
                                                                                               style="color:red"></span></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a type="button" class="btn btn-outline-secondary" href="tests/create">
        <span class="fa fa-plus"></span>
        Добавить
    </a>
</div>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>