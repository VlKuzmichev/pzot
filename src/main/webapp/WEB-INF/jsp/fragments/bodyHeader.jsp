<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
                        <button class="btn btn-dark" href="profile">
                            <span class="fa fa">Профиль</span>
                        </button>
                        <div class="mx-1">
                        </div>
                        <button class="btn btn-danger" type="submit" hint="Выход">
                            <span class="fa fa-sign-out"> Выход</span>
                        </button>
                    </form:form>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container" id="menu">
    <ul class="navbar-nav ml-lg-5">
        <li class="nav-item">
            <a class="btn btn-outline-secondary" href="">Главная</a>
            <a class="btn btn-outline-secondary" href="userTests">Мои тесты</a>
            <sec:authorize access="hasRole('ROLE_EXAMINER')">
                <a class="btn btn-outline-secondary" href="tests">Подготовка тестов</a>
                <a class="btn btn-outline-secondary" href="questionsGroups">Группы вопросов</a>
                <a class="btn btn-outline-secondary" href="questions">Вопросы</a>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <a class="btn btn-outline-secondary" href="usersGroups">Группы пользователей</a>
                <a class="btn btn-outline-secondary" href="users">Пользователи</a>
            </sec:authorize>
        </li>
    </ul>
</div>

<script type="text/javascript">
    const localeCode = "${pageContext.response.locale}";
</script>