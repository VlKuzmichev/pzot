<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <h3 class="text-center" style="margin-top: 20px">${test.isNew()? "Новый тест" : "Редактирование теста"}</h3>
    <form method="post" action="tests">
        <input type="hidden" name="id" value="${test.id}">
        <div class="form-group">
            <label for="name" class="col-form-label">Название теста</label>
            <input type="text" class="form-control" id="name" value="${test.name}" name="name"
                   placeholder="Test name">
            <label for="startDate" class="col-form-label">Дата начала</label>
            <input id="startDate" type="text" value="${fn:replace(test.startDate, 'T', ' ')}" name="startDate">
            <label for="endDate" class="col-form-label">Дата завершения</label>
            <input id="endDate" type="text" value="${fn:replace(test.endDate, 'T', ' ')}" name="endDate">
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

<script type="text/javascript">
    $(document).ready(function () {
        $('#startDate').datetimepicker({
            format: 'Y-m-d H:i',
        });
        $('#endDate').datetimepicker({
            format: 'Y-m-d H:i',
        });
    });
</script>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>