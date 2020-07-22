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
    <h3 class="text-center">Мои тесты</h3>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Наименование теста</th>
            <th>Результат</th>
            <th>Начало</th>
            <th>Завершение</th>
            <th>Статус</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${userTestList}" var="test">
            <tr>
                <td>${test.name}</td>
                <td> 40% </td>
                <td>${test.startDate.toLocalDate()}</td>
                <td>${test.endDate.toLocalDate()}</td>
                <td>${test.status}</td>
                <td><a href="">Начать</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>