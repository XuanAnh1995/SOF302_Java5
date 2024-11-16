<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Thêm Sản Phẩm Chi Tiết</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .form-container {
            margin-top: 50px;
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }
        .form-group label {
            font-weight: bold;
        }
        .error {
            color: red;
            font-size: 14px;
        }
        .form-header {
            background-color: #007bff;
            color: white;
            padding: 10px;
            border-radius: 8px;
        }
        select, input[type="text"] {
            height: 45px;
        }
        .form-check-label {
            margin-left: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="form-container">
                <div class="form-header text-center">
                    <h3>Thêm Sản Phẩm Chi Tiết</h3>
                </div>

                <!-- Form -->
                <form:form action="/sanphamchitiet/add" method="post" modelAttribute="sanPhamChiTiet" class="mt-4">

                    <!-- Thông báo message -->
                    <c:if test="${!empty message}">
                        <div class="alert alert-info text-center">
                                ${message}
                        </div>
                    </c:if>

                    <!-- Input Mã -->
                    <div class="form-group mb-3">
                        <label for="maSPCT">Mã SPCT:</label>
                        <form:input path="maSPCT" class="form-control" />
                        <form:errors path="maSPCT" cssClass="error"/>
                    </div>

                    <!-- Select Màu Sắc -->
                    <div class="form-group mb-3">
                        <label for="mauSac">Màu sắc:</label>
                        <form:select path="mauSac" class="form-select">
                            <c:forEach items="${list_MauSac}" var="mauSac">
                                <option value="${mauSac.id}">${mauSac.ten}</option>
                            </c:forEach>
                        </form:select>
                    </div>

                    <!-- Select Kích Thước -->
                    <div class="form-group mb-3">
                        <label for="kichThuoc">Kích thước:</label>
                        <form:select path="kichThuoc" class="form-select">
                            <c:forEach items="${list_KichThuoc}" var="kichThuoc">
                                <option value="${kichThuoc.id}">${kichThuoc.ten}</option>
                            </c:forEach>
                        </form:select>
                    </div>

                    <!-- Select Sản Phẩm -->
                    <div class="form-group mb-3">
                        <label for="sanPham">Sản phẩm:</label>
                        <form:select path="sanPham" class="form-select">
                            <c:forEach items="${list_SanPham}" var="sanPham">
                                <option value="${sanPham.id}">${sanPham.ten}</option>
                            </c:forEach>
                        </form:select>
                    </div>

                    <!-- Input Số Lượng -->
                    <div class="form-group mb-3">
                        <label for="soLuong">Số lượng:</label>
                        <form:input path="soLuong" class="form-control" />
                        <form:errors path="soLuong" cssClass="error"/>
                    </div>

                    <!-- Input Đơn Gía -->
                    <div class="form-group mb-3">
                        <label for="donGia">Đơn giá:</label>
                        <form:input path="donGia" class="form-control" />
                        <form:errors path="donGia" cssClass="error"/>
                    </div>

                    <!-- Radio buttons for Trạng thái -->
                    <div class="form-group mb-3">
                        <label>Trạng thái:</label><br>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="trangThai" id="hieuLuc" value="true" checked>
                            <label class="form-check-label" for="hieuLuc">Còn hàng</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="trangThai" id="khongHieuLuc" value="false">
                            <label class="form-check-label" for="khongHieuLuc">Hết hàng</label>
                        </div>
                    </div>

                    <!-- Submit button -->
                    <div class="text-center">
                        <form:button class="btn btn-primary btn-lg">Submit</form:button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
