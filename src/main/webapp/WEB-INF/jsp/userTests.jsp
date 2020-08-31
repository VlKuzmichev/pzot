<%@ page import="rzd.oao.zrw.pzot.util.DateTimeUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="container">
    <h3 class="text-center" style="margin-top: 20px">Мои тесты</h3>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Наименование теста</th>
            <th>Выполнено</th>
            <th>Период тестирования</th>
            <th>Результат</th>
            <th>Статус</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${userTestList}" var="test" varStatus="status">
            <jsp:useBean id="test" scope="page" type="rzd.oao.zrw.pzot.model.Quiz"/>
            <tr>
                <td>${test.name}</td>
                <td>${percentList.get(status.index)}%</td>
                <td> с <%=DateTimeUtil.toString(test.getStartDate())%> по <%=DateTimeUtil.toString(test.getEndDate())%></td>
                <td><a href="userTests/${test.id}">${percentList.get(status.index) == 100 ? 'Просмотр': ''}</a></td>
                <td>
                    <c:choose>
                        <c:when test="${percentList.get(status.index) == 100}">Тест завершен</c:when>
                        <c:when test="${test.status == ('[INACTIVE]')}">Недоступен</c:when>
                        <c:when test="${(percentList.get(status.index) >= 0 and percentList.get(status.index) < 100)}"><a
                                href="userTests/${test.id}">Запустить тест</a></c:when>
                        <c:otherwise>Тест завершен</c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>