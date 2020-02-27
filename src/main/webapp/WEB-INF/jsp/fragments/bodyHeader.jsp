<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<nav class="navbar navbar-expand-md navbar-light bg-light py-0">
    <div class="container">
        <a href="" class="navbar-brand"> ris </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                        <form:form class="form-inline my-2" action="logout" method="post">
                            <a class="btn btn-outline-secondary" href="profile">
                                    <%-- <sec:authentication property="principal.userTo.name"/>--%>
                                sdfwegergert/></a>
                            <div class="mx-1">
                                asdfasd
                            </div>

                            <button class="btn btn-danger" type="submit">
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
            <a class="btn btn-secondary mr-1" href="/"> asdf/></a>
            <a class="btn btn-secondary mr-1" href="/">dfasdf</a>
            <a class="btn btn-secondary mr-1" href="/">sadfasdf</a>
                <a class="btn btn-danger mr-1" href="users">sdfas</a>
        </li>
    </ul>
</div>

<script type="text/javascript">
    const localeCode = "${pageContext.response.locale}";
</script>