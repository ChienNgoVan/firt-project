<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="/WEB-INF/jsp/backend/common/head.jsp"></jsp:include>
<jsp:include page="/WEB-INF/jsp/backend/common/nav.jsp"></jsp:include>
<style>
    .error {
        color: red;
    }
</style>
<div class="container">
    <div>
        <div class="bg-light p-5 rounded">
            <div class="col-sm-8 mx-auto">
                <h1>Tạo mới tài khoản</h1>
                <p style="color: red">${message}</p>
                <form:form class="row g-3 needs-validation" method="post" action="/backend/user/save" modelAttribute="userDto">
                    <div class="col-md-6">
                        <label for="validationCustom01" class="form-label">Họ và tên</label>
                        <form:input type="text" class="form-control" id="validationCustom01" path="fullName" />
                        <form:errors cssClass="error" path="fullName"></form:errors>
                    </div>
                    <div class="col-md-6">
                        <label for="validationCustom02" class="form-label">Email<span class="error">(*)</span></label>
                        <form:input type="text" class="form-control" id="validationCustom02" path="email" />
                        <form:errors cssClass="error" path="email"></form:errors>
                    </div>
                    <div class="col-md-6">
                        <label for="validationCustom03" class="form-label">Mật khẩu</label>
                        <form:input type="password" class="form-control" id="validationCustom03" path="password" />
                        <form:errors cssClass="error" path="password"></form:errors>
                    </div>
                    <div class="col-md-6">
                        <label for="validationCustom04" class="form-label">Nhập lại mật khẩu</label>
                        <form:input type="password" class="form-control" id="validationCustom04" path="rePassword" />
                        <form:errors cssClass="error" path="rePassword"></form:errors>
                    </div>
                    <div class="col-md-6">
                        <label for="validationCustom04" class="form-label">Quyền hạn<span class="error">(ADMIN,CUSTOMER,USER)</span></label>
                        <form:input type="password" class="form-control" id="validationCustom04" path="role" />
                        <form:errors cssClass="error" path="rePassword"></form:errors>
                    </div>
                    <div class="col-md-6">
                        <label for="validationCustom04" class="form-label">Địa Chỉ</label>
                        <form:input type="password" class="form-control" id="validationCustom04" path="address" />
                        <form:errors cssClass="error" path="rePassword"></form:errors>
                    </div>
                    <div class="col-md-6">
                        <label for="validationCustom04" class="form-label">Số điện thoại liên hệ</label>
                        <form:input type="password" class="form-control" id="validationCustom04" path="phone" />
                        <form:errors cssClass="error" path="rePassword"></form:errors>
                    </div>
                    <div class="col-12">
                        <button class="btn btn-primary" type="submit">Tạo mới</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/jsp/backend/common/footer.jsp"></jsp:include>

