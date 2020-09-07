<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Авторизация</title>
    <link rel="stylesheet" href="webjars/bootstrap/4.3.1/css/bootstrap.min.css">
    <link href="resources/css/signin.css" rel="stylesheet">
    <link rel="shortcut icon" href="resources/images/dtz.png">
    <script type="text/javascript" src="webjars/bootstrap/4.3.1/js/bootstrap.min.js" defer></script>
    <script type="text/javascript" src="webjars/jquery/3.3.1-2/jquery.min.js" defer></script>
</head>
<body class="text-center">
<form:form class="form-signin" id="login_form" action="spring_security_check" method="post">
    <img class="mb-4" src="resources/images/logo-text-login.png">
    <h2 class="h5 mb-3 font-weight-normal">Автоматизированная система дистанционного тестирования знаний ОАО "РЖД"</h2>
    <c:if test="${param.error}">
        <div class="error" style="color: #a94442"><H5>Неверный логин или пароль</H5></div>
    </c:if>
    <input class="form-control" id="Email" type="text" placeholder="Логин" name="username">
    <input class="form-control" id="inputPassword" type="password" placeholder="Пароль" name="password">
    <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
    <p class="mt-5 mb-3 text-muted">&copy; 2020</p>
</form:form>

</body>
</html>
