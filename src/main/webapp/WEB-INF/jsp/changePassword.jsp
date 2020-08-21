<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="container">
    <h3 class="text-center" style="margin-top: 20px">Изменение пароля пользователя ${user.name}</h3>
    <form method="post" action="users">
        <input type="hidden" name="id" value="${user.id}">
        <div class="form-group" style="margin-top: 20px">
            <label for="password" class="col-form-label">Новый пароль</label>
            <input type="password" class="form-control" id="password" name="password">
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
