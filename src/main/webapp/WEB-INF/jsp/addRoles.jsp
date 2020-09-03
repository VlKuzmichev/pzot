<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="container">
    <h3 class="text-center" style="margin-top: 20px">Добавление ролей</h3>
    <a type="button" class="btn btn-outline-secondary" href="users">
        <span class="fa fa-backward"></span>
        Назад
    </a>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Роль</th>
            <th>Добавить</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${roles}" var="role">
            <tr>
                <td>${role}</td>
                <td><a href="users/roles/add?role=${role}&id=${user.id}" title="Добавить">
                    <span class='fa fa-plus' style="color:green"></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a type="button" class="btn btn-outline-secondary" href="users">
        <span class="fa fa-backward"></span>
        Назад
    </a>
</div>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>