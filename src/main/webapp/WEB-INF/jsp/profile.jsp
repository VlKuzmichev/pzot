<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="container">
    <h3 class="text-center" style="margin-top: 20px">Смена пароля ${user.name}</h3>
    <form method="post" action="users">
        <input type="hidden" name="id" value="${user.id}">
        <div class="container text-center" style="margin-top: 20px;margin-bottom: 10px; width: 300px">
            <label for="newPassword" class="col-form-label">Новый пароль</label>
            <input type="password" class="form-control" id="newPassword" name="newPassword">
            <label for="confirmPassword" class="col-form-label">Подтверждение</label>
            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword">
        </div>

        <div class="form-group text-center">
            <button type="button" class="btn btn-secondary" onclick="window.history.back()">
                <span class="fa fa-close"></span>
                Отмена
            </button>
            <button type="submit" class="btn btn-primary" id="Save" disabled="disabled">
                <span class="fa fa-check"></span>
                Сохранить
            </button>
        </div>
        <div class="form-group text-center">
            <label style="margin-top: 10px" class="error" id="error"></label>
        </div>
    </form>
</div>

<script type="text/javascript">
    // Validation password fields
    $(".error").attr("hidden", "hidden");
    $("#confirmPassword").on("keyup", function () {
        const value_input1 = $("#newPassword").val();
        const value_input2 = $(this).val();
        if (value_input1 !== value_input2) {
            $("#error").html("Пароли не совпадают!")
                .removeAttr("hidden");
            $("#Save").attr("disabled", "disabled");
        } else if (value_input1.length < 8) {
            $("#error").html("Пароль не удовлетворяет требованиям безопасности(мин 8 знаков)")
                .removeAttr("hidden");
            $("#Save").attr("disabled", "disabled");
        } else {
            $("#Save").removeAttr("disabled", "disabled");
            $("#error").attr("hidden", "hidden");
        }
    });
</script>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
