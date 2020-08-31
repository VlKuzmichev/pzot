<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="container">
    <h3 class="text-center" style="margin-top: 20px">Результаты теста</h3>

    <a type="button" class="btn btn-outline-secondary" onclick="window.history.back()">
        <span class="fa fa-backward"></span>
        Назад
    </a>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Студент</th>
            <th>Статус</th>
            <th>Результат</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${resultList}" var="result">
            <tr>
                <td>${result.key.fullName}</td>
                <td><c:choose>
                    <c:when test="${statusList.get(result.key.id) == 0}">Не начат</c:when>
                    <c:when test="${statusList.get(result.key.id) == 1}">В процессе</c:when>
                    <c:otherwise>Завершен</c:otherwise>
                </c:choose></td>
                <td><c:choose>
                    <c:when test="${statusList.get(result.key.id) != 2}"> - </c:when>
                    <c:otherwise>${result.value}%</c:otherwise>
                </c:choose></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a type="button" class="btn btn-outline-secondary" onclick="window.history.back()">
        <span class="fa fa-backward"></span>
        Назад
    </a>

</div>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>