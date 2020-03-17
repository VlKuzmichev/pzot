<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<nav class="navbar navbar-expand-md navbar-light bg-light py-0">
    <div class="container">
        <a href="" class="navbar-brand"> АС ДТЗ "Автоматизированная система дистанционного тестирования знаний"</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
<!--            <span class="navbar-toggler-icon">Icon</span>  -->
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                        <form:form class="form-inline my-2" action="logout" method="post">
                            <a class="btn btn-secondary" href="profile">
                                    <%-- <sec:authentication property="principal.userTo.name"/>--%>
                                Профиль пользователя</a>
                            <div class="mx-1">

                            </div>

                            <button class="btn btn-danger" type="submit" hint="Выход">
                                <span class="fa fa-sign-out"></span>
                            </button>
                        </form:form>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container-top" id="menu">
    <ul class="navbar-nav ml-lg-5">
                <li class="nav-item">
<!--            <a class="btn btn-secondary mr-1" href="/">Мои тесты</a> -->
            <a class="btn btn-outline-secondary" href="/">Мои тесты</a>
            <a class="btn btn-outline-secondary" href="/">Тесты</a>
            <a class="btn btn-outline-secondary" href="/">Группы вопросов</a>
            <a class="btn btn-outline-secondary" href="questions">Вопросы</a>
            <a class="btn btn-outline-secondary" href="usersGroups">Группы пользователей</a>
            <a class="btn btn-outline-secondary" href="users">Пользователи</a>
        </li>
    </ul>
</div>

<script type="text/javascript">
    const localeCode = "${pageContext.response.locale}";
</script>