<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="container">
    <h3 class="text-center" style="margin-top: 20px">Смена пароля пользователя ${user.name}</h3>
    <form method="post" action="users">
        <input type="hidden" name="id" value="${user.id}">
        <div class="form-group" style="margin-top: 20px; width: 300px;">
            <label for="newPassword" class="col-form-label">Новый пароль</label>
            <input type="password" class="form-control" id="newPassword" name="newPassword">
            <label for="confirmPassword" class="col-form-label">Подтверждение</label>
            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword">
        </div>
        <label class="error" id="error"></label>

        <div class="form-group">
            <button type="button" class="btn btn-secondary" onclick="window.history.back()">
                <span class="fa fa-close"></span>
                Отмена
            </button>
            <button type="submit" class="btn btn-primary" id="Save" disabled="disabled">
                <span class="fa fa-check"></span>
                Сохранить
            </button>
        </div>
    </form>
</div>

<script type="text/javascript">
    // Validation password fields
    $(".error").attr("hidden", "hidden");
    $("#confirmPassword").on("keyup", function() {
        const value_input1 = $("#newPassword").val();
        const value_input2 = $(this).val();
        if(value_input1 !== value_input2) {
            $("#error").html("Пароли не совпадают!")
                .removeAttr("hidden");
            $("#Save").attr("disabled", "disabled");
        } else if(value_input1.length < 8) {
            $("#error").html("Пароль не удовлетворяет требованиям безопасности(мин 8 знаков)")
                .removeAttr("hidden");
            $("#Save").attr("disabled", "disabled");
        } else {
            $("#Save").attr("disabled", "enabled");
            $("#error").attr("hidden", "hidden");
        }
    });
</script>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
