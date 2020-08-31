<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="container">
    <h3 class="border-bottom text-center" style="margin-top: 20px">Результаты тестирования</h3>
    <div class="text-center" style="margin-top: 20px">
        <H4>Поздравляем!</H4>
        <p class="text-primary">Ваш результат: ${result}%</p>
    </div>
</div>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>