<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="container">
    <h3 class="text-center" style="margin-top: 20px">Роли пользователя ${user.name}</h3>
    <a type="button" class="btn btn-outline-secondary" href="users/roles/add?id=${user.id}">
        <span class="fa fa-plus"></span>
        Добавить
    </a>
    <a type="button" class="btn btn-outline-secondary" href="tests">
        <span class="fa fa-backward"></span>
        Назад
    </a>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Роль</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${user.roles}" var="role">
            <tr>
                <td>${role}</td>
                <td><a href="users/role/delete?role=${role}&id=${user.id}" title="Удалить">
                    <span class='fa fa-remove' style="color:red"></span></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a type="button" class="btn btn-outline-secondary" href="users/roles/add?id=${user.id}">
        <span class="fa fa-plus"></span>
        Добавить
    </a>
    <a type="button" class="btn btn-outline-secondary" href="users">
        <span class="fa fa-backward"></span>
        Назад
    </a>
</div>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>