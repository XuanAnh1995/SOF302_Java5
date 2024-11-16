<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Thêm nhân viên</title>
    <!-- Thêm Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .form-container {
            margin-top: 50px;
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .form-group label {
            font-weight: bold;
        }
        .form-check-label {
            margin-left: 10px;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="form-container">
                <h3 class="text-center">Thêm Nhân Viên</h3>

                <!-- Form -->
                <form:form action="/nhanvien/add" method="post" modelAttribute="nhanVien" class="mt-4">

                    <!-- Thông báo message -->
                    <div class="mb-3 text-primary">
                            ${message}
                    </div>

                    <!-- Input ten -->
                    <div class="form-group mb-3">
                        <label for="ten">Tên:</label>
                        <form:input path="ten" class="form-control" />
                        <form:errors path="ten" cssClass="error"/>
                    </div>

                    <!-- Input maNV -->
                    <div class="form-group mb-3">
                        <label for="maNV">Mã:</label>
                        <form:input path="maNV" class="form-control" />
                        <form:errors path="maNV" cssClass="error"/>
                    </div>

                    <!-- Input tenDangNhap -->
                    <div class="form-group mb-3">
                        <label for="tenDangNhap">Tên Đăng Nhập:</label>
                        <form:input path="tenDangNhap" class="form-control" />
                        <form:errors path="tenDangNhap" cssClass="error"/>
                    </div>

                    <!-- Input matKhau -->
                    <div class="form-group mb-3">
                        <label for="matKhau">Mật khẩu:</label>
                        <form:input path="matKhau" class="form-control" />
                        <form:errors path="matKhau" cssClass="error"/>
                    </div>

                    <!-- Radio buttons for Trạng thái -->
                    <div class="form-group mb-3">
                        <label>Trạng thái:</label><br>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="trangThai" id="hieuLuc" value="true" checked>
                            <label class="form-check-label" for="hieuLuc">Đang làm việc</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="trangThai" id="khongHieuLuc" value="false">
                            <label class="form-check-label" for="khongHieuLuc">Nghỉ việc</label>
                        </div>
                    </div>

                    <!-- Submit button -->
                    <div class="text-center">
                        <form:button class="btn btn-primary">Submit</form:button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

<!-- Thêm Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>