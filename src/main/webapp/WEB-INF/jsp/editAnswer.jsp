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
    <h3 class="text-center" style="margin-top: 20px">${answer.isNew()? "Новый ответ" : "Редактирование ответа"}</h3>
    <form method="post" action="answers">
        <input type="hidden" name="id" value="${answer.id}">
        <input type="hidden" name="q" value="${answer.question.id}">
        <div class="form-group">
            <label for="name" class="col-form-label">Ответ</label>
            <table class="table table-striped">
                <tr>
                    <td colspan="2"><input type="text" class="form-control" id="name" value="${answer.name}" name="name"
                                           placeholder="Answer"></td>
                </tr>
                <tr>
                    <td>Верный/неверный</td>
                    <td><input type="checkbox" class="form-control" id="truth" name="truth"
                    ${answer.truth ? "checked" : ""}></td>
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
