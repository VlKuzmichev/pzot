<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron pt-4">
    <div class="container">
        <h3 class="text-center">Группы пользователей</h3>
        <a type="button" class="btn btn-outline-secondary" href="usersGroups/create">
            <span class="fa fa-plus"></span>
            Добавить
        </a>
        <table class="table table-striped" id="datatable">
            <thead>
            <tr>
                <th>Название группы</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${usersGroopsList}" var="usersGroup">
                <tr>
                    <td>${user.name}</td>
                    <td><a href="usersGroups/update?id=${user.id}">РЕДАКТИРОВАТЬ</a></td>
                    <td><a href="usersGroups/delete?id=${user.id}">УДАЛИТЬ</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a type="button" class="btn btn-outline-secondary" href="usersGroups/create">
            <span class="fa fa-plus"></span>
            Добавить
        </a>
    </div>
</div>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>