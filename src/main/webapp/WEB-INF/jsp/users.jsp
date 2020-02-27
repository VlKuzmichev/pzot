<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<%--<script type="text/javascript" src="resources/js/upor.departments.js" defer></script>--%>
<script type="text/javascript" src="resources/js/upor.common.js" defer></script>
<script type="text/javascript" src="resources/js/upor.users.js" defer></script>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron pt-4">
    <div class="container">
        <h3 class="text-center">2113123</h3>
        <button class="btn btn-outline-secondary" onclick="add()">
            <span class="fa fa-plus"></span>
            dfdsfsh dfgdfg
        </button>
        <table class="table table-striped" id="datatable">
            <thead>
            <tr>
                <th>User name</th>
                <th>Full name</th>
                <th>Email</th>
                <th>Roles</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
        </table>
    </div>
</div>

<div class="modal fade" tabindex="-1" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="modalTitle"></h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form id="detailsForm">
                    <input type="hidden" id="id" name="id">
                    <div class="form-group">
                        <label for="name" class="col-form-label">User name</label>
                        <input type="text" class="form-control" id="name" name="name"
                               placeholder="User name">
                    </div>
                    <div class="form-group">
                        <label for="fullName" class="col-form-label">Full name</label>
                        <input type="text" class="form-control" id="fullName" name="fullName"
                               placeholder="Full name">
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">
                    <span class="fa fa-close"></span>
                    Cancel
                </button>
                <button type="button" class="btn btn-primary" onclick="save()">
                    <span class="fa fa-check"></span>
                    Save
                </button>
            </div>
        </div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>