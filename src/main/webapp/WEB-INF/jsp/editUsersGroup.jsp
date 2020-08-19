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
    <h3 class="text-center" style="margin-top: 20px">${userGroup.isNew()? "Новая группа" : "Изменение группы"}</h3>
    <form method="post" action="usersGroups">
        <input type="hidden" name="id" value="${userGroup.id}">
        <div class="form-group">
            <label for="name" class="col-form-label">Название группы</label>
            <input type="text" class="form-control" id="name" value="${userGroup.name}" name="name"
                   placeholder="UserGroup name">
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