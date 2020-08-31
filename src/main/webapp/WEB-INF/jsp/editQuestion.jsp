<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="container">
    <h3 class="text-center" style="margin-top: 20px">${question.isNew()? "Новый вопрос" : "Редактирование вопроса"}</h3>
    <form method="post" action="questions">
        <input type="hidden" name="id" value="${question.id}">
        <div class="form-group">
            <label for="name" class="col-form-label">Вопрос</label>
            <input type="text" class="form-control" id="name" value="${question.name}" name="name"
                   placeholder="Вопрос">
            <label for="num" class="col-form-label">Группа</label>
            <select class="form-control" id="num" name="num">
                <c:forEach items="${groups}" var="group">
                    <option value="${group.id}"${group.id == question.questionGroup.id ? " selected" : ""}>${group.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <button type="button" class="btn btn-secondary" onclick="window.history.back()">
                <span class="fa fa-close"></span>
                Отмена
            </button>
            <button type="submit" class="btn btn-primary">
                <span class="fa fa-check"></span>
                Сохранить
            </button>
        </div>
    </form>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
