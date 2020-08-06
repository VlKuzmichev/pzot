<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="container">
    <br/>
    <h3 class="text-center">Новости</h3>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Дата</th>
            <th>Новость</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>06.08.2020</td>
            <td>Начало тестирования системы</td>
        </tr>
        </tbody>
    </table>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
