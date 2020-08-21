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
    <h3 class="text-center" style="margin-top: 20px">Изменение пароля пользователя ${user.name}</h3>
    <form method="post" action="users">
        <input type="hidden" name="id" value="${user.id}">
        <div class="form-group">
            <table class="table table-striped">
                <tr>
                    Новый пароль
                </tr>
                <tr>
                    <td><input type="password" class="form-control" id="password" name="password"></td>
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
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
