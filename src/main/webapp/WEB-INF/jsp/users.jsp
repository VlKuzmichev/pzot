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
    <h3 class="text-center " style="margin-top: 20px">Пользователи</h3>
    <a type="button" class="btn btn-outline-secondary" href="users/create">
        <span class="fa fa-plus"></span>
        Добавить
    </a>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ФИО</th>
            <th>Логин</th>
            <th>Email</th>
            <th>Роли</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.fullName}</td>
                <td>${user.name}</td>
                <td><a href="mailto: ${user.email}">${user.email}</a></td>
                <td>
                    <c:forEach items="${user.roles}" var="role" varStatus="loop">
                        <c:choose>
                            <c:when test="${role == ('ROLE_ADMIN')}">[Администратор] </c:when>
                            <c:when test="${role == ('ROLE_USER')}">[Пользователь] </c:when>
                            <c:when test="${role == ('ROLE_EXAMINER')}">[Проверяющий] </c:when>
                        </c:choose>
                    </c:forEach>
                </td>
                <td><a href="users/update?id=${user.id}" title="Изменить данные"><span class='fa fa-pencil' style="color:black"></span></a></td>
                <td><a href="users/changePassword?id=${user.id}" title="Сменить пароль"><span class='fa fa-key' style="color:black"></span></a></td>
                <td><a href="users/delete?id=${user.id}" title="Удалить"><span class='fa fa-remove' style="color:red"></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a type="button" class="btn btn-outline-secondary" href="users/create">
        <span class="fa fa-plus"></span>
        Добавить
    </a>
</div>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>