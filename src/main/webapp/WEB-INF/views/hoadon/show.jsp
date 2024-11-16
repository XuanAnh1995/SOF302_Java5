<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Danh sách Hóa Đơn</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        table {
            margin-top: 20px;
        }
    </style>

</head>
<body>
<div class="container">
    <div class="form-container col-md-6 offset-md-3">
        <h2 class="text-center text-primary">Chi tiết Hóa Đơn</h2>
        <form>
            <div class="form-group">
                <label for="id">ID:</label>
                <input type="number" class="form-control" id="id" name="id" value="${hoaDon.id}" readonly>
            </div>
            <div class="form-group">
                <label for="idKhachHang">Khách Hàng:</label>
                <input type="text" class="form-control" id="idKhachHang" name="idKhachHang" value="${hoaDon.khachHang.ten}" readonly>
            </div>
            <div class="form-group">
                <label for="idNhanVien">Nhân Viên:</label>
                <input type="text" class="form-control" id="idNhanVien" name="idNhanVien" value="${hoaDon.nhanVien.maNV}" readonly>
            </div>
            <div class="form-group">
                <label for="ngayMuaHang">Ngày Mua Hàng:</label>
                <input type="date" class="form-control" id="ngayMuaHang" name="ngayMuaHang" value="${hoaDon.ngayMuaHang}" readonly>
            </div>
            <div class="form-group">
                <label>Trạng Thái:</label><br>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="trangThai" id="hoanThanh" value="true" ${hoaDon.trangThai ? "checked" : ""} disabled>
                    <label class="form-check-label" for="hoanThanh">Hoàn thành</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="trangThai" id="chuaHoanThanh" value="false" ${hoaDon.trangThai ? "" : "checked"} disabled>
                    <label class="form-check-label" for="chuaHoanThanh">Chưa hoàn thành</label>
                </div>
            </div>
        </form>
    </div>
</div>

<div class="container">
    <h2 class="mt-5 text-center text-primary">Danh sách Hóa Đơn</h2>
    <table class="table table-bordered table-hover">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Tên Khách Hàng</th>
            <th>Mã Nhân Viên</th>
            <th>Ngày Mua Hàng</th>
            <th>Trạng thái</th>
            <th>Hành Động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list_HoaDon}" var="hoaDon">
            <tr class="table-row">
                <td>${hoaDon.id}</td>
                <td>${hoaDon.khachHang.id}</td>
                <td>${hoaDon.nhanVien.id}</td>
                <td>${hoaDon.ngayMuaHang}</td>
                <td>${hoaDon.trangThai ? "Hoàn thành" : "Chưa hoàn thành"}</td>
                <td>
                    <a href="/hoadon/detail?id=${hoaDon.id}" class="btn btn-info btn-sm" onclick="highlightRow(this.closest('tr'));">Detail</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/main" class="btn btn-secondary">Quay lại</a>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
