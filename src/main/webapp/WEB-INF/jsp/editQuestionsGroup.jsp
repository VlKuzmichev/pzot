<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="container">
    <h3 class="text-center" style="margin-top: 20px">${questionGroup.isNew()? "Новая группа" : "Редактирование группы"}</h3>
    <form method="post" action="questionsGroups">
        <input type="hidden" name="id" value="${questionGroup.id}">
        <div class="form-group">
            <label for="name" class="col-form-label">Название группы</label>
            <input type="text" class="form-control" id="name" value="${questionGroup.name}" name="name"
                   placeholder="QuestionGroup name">
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