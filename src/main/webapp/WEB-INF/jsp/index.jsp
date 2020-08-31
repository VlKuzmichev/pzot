<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="container">
    <img class="img-fluid mx-auto d-block" style="margin-top:20px" src="resources/images/test.jpg" height="20%"
         width="20%"/>
    <h3 class="text-center" style="margin-top: 10px">События</h3>
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
