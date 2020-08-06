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
    <br/>
    <h3 class="text-center">${user.isNew()? "Новый пользователь" : "Редактирование пользователя"}</h3>
    <form method="post" action="users">
        <input type="hidden" name="id" value="${user.id}">
        <div class="form-group">
            <label for="name" class="col-form-label">Логин</label>
            <input type="text" class="form-control" id="name" value="${user.name}" name="name"
                   placeholder="User name">
        </div>
        <div class="form-group">
            <label for="fullName" class="col-form-label">ФИО</label>
            <input type="text" class="form-control" id="fullName" value="${user.fullName}" name="fullName"
                   placeholder="Full name">
        </div>

        <div class="form-group">
            <label for="email" class="col-form-label">E-mail</label>
            <input type="text" class="form-control" id="email" value="${user.email}" name="email"
                   placeholder="Email">
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