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
    <br/>
    <h3 class="text-center">Результат тестирования</h3>
    <form method="post" action="userTests">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Тестирование завершено</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </form>
</div>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>