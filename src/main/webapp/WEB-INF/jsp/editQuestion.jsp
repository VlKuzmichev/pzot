<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<h3 class="text-center">${question.isNew()? "Новый вопрос" : "Редактирование вопроса"}</h3>
<form method="post" action="questions">
    <input type="hidden" name="id" value="${question.id}">
    <div class="form-group">
        <label for="name" class="col-form-label">Вопрос</label>
        <table class="table table-striped">
            <tr>
                <td colspan="2"><input type="text" class="form-control" id="name" value="${question.name}" name="name"
                                       placeholder="Вопрос"></td>
            </tr>
            <tr>
                <td>Группа вопросов</td>
                <td><select class="form-control" name="num">
                    <c:forEach items="${groups}" var="group">
                        <option value="${group.id}"${group.id == question.questionGroup.id ? " selected" : ""}>${group.name}</option>
                    </c:forEach>
                </select></td>
            </tr>
        </table>
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

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
